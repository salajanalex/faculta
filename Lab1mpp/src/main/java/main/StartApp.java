package main;
import connection.DBConfig;
import connection.DBConnection;

import java.sql.*;
class StartApp{






    public static void main(String args[]){
        DBConnection con = new DBConnection();
        Connection connection = con.getConnection("bd.config");

        try{
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from inscriere");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
            connection.close();
        }catch(Exception e){ System.out.println(e);}
    }

}