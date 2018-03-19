package connection;
import connection.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection{

    /**
     * returns the connection tot the DB
     * @return connection
     */
    public Connection getConnection(String configFile) {
        DBConfig dbConfig;
        dbConfig = new DBConfig();
        dbConfig.setConfiguration(configFile);

       Connection connection = null;
        try {
            Class.forName(dbConfig.getDbDriver());
            connection = DriverManager.getConnection(
                    dbConfig.getDbUrl(), dbConfig.getDbUser(), dbConfig.getDbPass());
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}
