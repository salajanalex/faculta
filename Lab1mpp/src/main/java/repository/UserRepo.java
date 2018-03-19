package repository;

import connection.DBConnection;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserRepo {
    DBConnection connection = new DBConnection();
    Connection con = connection.getConnection();

    private ArrayList<User> userRepo = new ArrayList<User>();

    public void setUserRepo(){
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while (rs.next()){
                try {
                    User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                    userRepo.add(user);
                }catch (Exception ex){ System.out.println(ex);}
        }

        }catch(Exception e){ System.out.println(e);}
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (Exception ex) {System.out.println(ex);
        }
    }

    public ArrayList<User> getUserRepo(){
        return this.userRepo;
    }
}
