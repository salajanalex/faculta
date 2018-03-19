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

        User usr = new User("Marceo","Popoviciu");

        /**
         * List all users from DB (DB -> Repo -> View)
         */
        userRepo.setUserRepo();
        userList = userRepo.getUserRepo();
        for (User user:userList ) {
            System.out.println(user.toString());
        }

        /**
         * find by username
         */
      //  userRepo.findUserByUsername("alex");

        /**
         * add new User
         */
      //  userRepo.addUser(usr);


        /**
         * delete an user from DB
         */
       // userRepo.deleteUser(usr);


        /**
         * List all users from Repo (Repo -> view)
         */
        userList = userRepo.getUserRepo();
        for (User user:userList ) {
            System.out.println(user.toString());
        }



    }


}