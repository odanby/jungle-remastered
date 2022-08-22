package com.jungle.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jungle.entities.User;

public class UserTest {

    public static UserDAOInterface userDao = new UserDAO();
    
    // test to create a user
    @Test
    public void createNewUser(){
        long date = 742892400000L;
        User createNewUser = new User(
            "Cheetah",
            "Spots",
            "hotcheetahs@gmail.com" + Math.random()* 100,
            date,
            "hotcheetahs" + Math.random()* 100,
            "password"
        );
        User result = userDao.createNewUser(createNewUser);
        Assert.assertNotNull(result);
    }

    // test to get user by id
    @Test
    public void getUserById(){
        User result = userDao.getUserById(1);
        Assert.assertNotNull(result);
    }

    // test to search for users by username
    @Test
    public void searchForUser(){
        ArrayList<User> result = userDao.searchForUser("crazyorangemonkey");
        Assert.assertNotNull(result);
    }

    // test to get all users
    @Test
    public void getAllUsers(){
        List<User> result = userDao.getAllUsers();
        Assert.assertNotNull(result);
    }

    // test to delete a user
    @Test
    public void deleteUser(){
        long date = 742892400000L;
        User userToBeDeleted = new User(            
            "Tigress",
            "Queen",
            "tigressqueen@gmail.com",
            date,
            "queent",
            "password"
        );
        userDao.createNewUser(userToBeDeleted);
        boolean result = userDao.deleteUser(userToBeDeleted);
        Assert.assertTrue(result);
    }
}
