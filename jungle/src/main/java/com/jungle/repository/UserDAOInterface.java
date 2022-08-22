package com.jungle.repository;

import java.util.ArrayList;
import java.util.List;

import com.jungle.entities.User;

public interface UserDAOInterface {

    // create a user
    User createNewUser(User newUser);

    // get user by user_id
    User getUserById(int user_id);

    // get all users by username
    ArrayList<User> searchForUser(String username);

    // get all users
    List<User> getAllUsers();

    // delete account
    boolean deleteUser(User userToBeDeleted);

}
