//package repository;
//
//import connection.DBConnection;
//import model.User;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.PreparedStatement;
//import java.util.ArrayList;
//
//public class UserRepo1 {
//    static DBConnection connection = new DBConnection();
//    static Connection con = connection.getConnection();
//
//    public static ArrayList<User> userRepo = new ArrayList<User>();
//
//    /**
//     * Setting the repo = creating/updating local repo from DB
//     */
////    public static void setUserRepo(){
////        try {
////            ArrayList<User> newUserRepo = new ArrayList<User>();
////            Statement stmt = con.createStatement();
////            ResultSet rs = stmt.executeQuery("select * from user");
////            while (rs.next()){
////                try {
////                    User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
////                    newUserRepo.add(user);
////                }catch (Exception ex){ System.out.println(ex);}
////                }
////            userRepo=newUserRepo;
////        }catch(Exception e){ System.out.println(e);}
////    }
//
//    /**
//     * trebuie apelat ca sa nu cream mai multe conexiuni
//     */
//    public void closeConnection() {
//        try {
//            con.close();
//        } catch (Exception ex) {System.out.println(ex);
//        }
//    }
//
//    /**
//     * Returns all the users.
//     * @return ArrayList
//     */
//    public ArrayList<User> getUserRepo(){
//        return this.userRepo;
//    }
//
//    /**
//     * adds user to the DB and makes update to the repository.
//     * @param user
//     */
//    public void addUser(User user){
//        try {
//            String query = " insert into user (username, password)" + " values (?, ?)";
//
//            // create the mysql insert preparedstatement
//            PreparedStatement preparedStmt = con.prepareStatement(query);
//            preparedStmt.setString (1, user.getUsername());
//            preparedStmt.setString (2, user.getPassword());
//
//            // execute the preparedstatement
//            preparedStmt.execute();
//            setUserRepo();
//
//        }
//        catch (Exception e)
//        {
//            System.err.println("Got an exception!");
//            System.err.println(e.getMessage());
//        }
//    }
//
//    /**
//     * Removes user from DB and makes update in repo
//     * @param user
//     */
//
//    public void deleteUser(User user){
//        try {
//            String query = " DELETE FROM user WHERE username = ?";
//
//            // create the mysql insert preparedstatement
//            PreparedStatement preparedStmt = con.prepareStatement(query);
//            preparedStmt.setString (1, user.getUsername());
//
//            // execute the preparedstatement
//            preparedStmt.execute();
//            UserRepo1.setUserRepo();
//
//        }
//        catch (Exception e)
//        {
//            System.err.println("Got an exception!");
//            System.err.println(e.getMessage());
//        }
//    }
//
//    public void findUserByUsername(String usrname){
//        try {
//            //Statement stmt = con.createStatement();
//            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `user` WHERE `username` = ?");
//            stmt.setString(1, usrname);
//            ResultSet rs = stmt.executeQuery(); //"select * from user WHERE username=usrname");
//            if (!rs.isBeforeFirst() ) {
//                System.out.println("No user found");
//            }else {
//                System.out.println("User " + usrname + " was found!");
//            }
//
//        }catch(Exception e){ System.out.println(e);}
//    }
//}
