package utils.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection{
    public DBConfig dbConfig = new DBConfig();


    /**
     * returns the connection tot the DB
     * @return Connection
     */


    public Connection getConnection() {
        dbConfig.setConfiguration("bd.config");

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
