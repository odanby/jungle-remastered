package com.jungle.repository;

import java.util.ArrayList;
import java.util.List;

import com.jungle.entities.User;
import com.jungle.utils.HibernateUtil;

public class UserDAO implements UserDAOInterface {

    @Override
    public User createNewUser(User newUser) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(newUser);
        HibernateUtil.endTransaction();
        return newUser;
    }

    @Override
    public User getUserById(int user_id) {
        HibernateUtil.beginTransaction();
        User returnUser = (User) HibernateUtil.getSession().createQuery("from User where user_id = :user_id", User.class).setParameter("user_id", user_id).uniqueResult();
        HibernateUtil.endTransaction();
        return returnUser;
    }

    @Override
    public ArrayList<User> searchForUser(String username) {
        HibernateUtil.beginTransaction();
        ArrayList<User> returnUsers = (ArrayList<User>) HibernateUtil.getSession().createQuery("from User where username = :username" , User.class).setParameter("username", username).list();
        HibernateUtil.endTransaction();
        return returnUsers;
    }

    @Override
    public List<User> getAllUsers() {
       HibernateUtil.beginTransaction();
       List<User> userList = HibernateUtil.getSession().createQuery("from User", User.class).getResultList();
       HibernateUtil.endTransaction();
       return userList;
    }

    @Override
    public boolean deleteUser(User userToBeDeleted) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(userToBeDeleted);
        HibernateUtil.endTransaction();
        return true;
    }
    
}
