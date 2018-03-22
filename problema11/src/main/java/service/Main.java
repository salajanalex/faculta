package service;

import ro.salajan.model.User;
import service.impl.UserServiceImplementation;

public class Main {
    static UserServiceImplementation impl = new UserServiceImplementation();

    public static void main(String[] args) {
//        User user = new User();
//            user =    impl.findUserByUsername("sava");
        System.out.println(impl.findUserByUsername("sava").toString());

    }
}
