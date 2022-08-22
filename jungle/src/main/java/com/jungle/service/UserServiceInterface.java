package com.jungle.service;

import java.util.ArrayList;
import java.util.List;

import com.jungle.entities.User;

public interface UserServiceInterface {
    
    User createNewUserService(User newUser);

    User getUserByIdService(int user_id);

    ArrayList<User> searchForUserService(String username);

    List<User> getAllUsersService();

    boolean deleteUserService(User userToBeDeleted);

    User loginUser(User loginUser);
}
