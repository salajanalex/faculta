package main;
import connection.DBConfig;
import connection.DBConnection;
import repository.UserRepo;
import model.User;

import java.sql.*;
import java.util.ArrayList;

class StartApp{

    public static void main(String[] args) {
        UserRepo userRepo = new UserRepo();
        ArrayList<User> userList= new ArrayList<User>();
        userRepo.setUserRepo();
        userList = userRepo.getUserRepo();
        for (User user:userList ) {
            System.out.println(user.toString());
        }
    } 




//    public static void main(String args[]){
//        DBConnection con = new DBConnection();
//        Connection connection = con.getConnection();
//
//        try{
//            Statement stmt=connection.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from inscriere");
//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
//            connection.close();
//        }catch(Exception e){ System.out.println(e);}
//    }

}