package ro.salajan.service;

import ro.salajan.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User findUserByUsername(String username);
}
