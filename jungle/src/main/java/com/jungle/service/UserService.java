package com.jungle.service;

import java.util.ArrayList;
import java.util.List;

import com.jungle.entities.User;
import com.jungle.exceptions.BlankInputs;
import com.jungle.exceptions.IncorrectLogin;
import com.jungle.exceptions.InvalidInputException;
import com.jungle.exceptions.UnallowedSpaces;
import com.jungle.repository.UserDAO;
import com.jungle.utils.UserLoginRules;

public class UserService implements UserServiceInterface {

    private final UserDAO userDAO;
    private final UserLoginRules userLoginRules;

    public UserService(UserDAO userDAO, UserLoginRules userLoginRules){
        this.userDAO = userDAO;
        this.userLoginRules = userLoginRules;
    }

    @Override
    public User createNewUserService(User newUser) {
        if(newUser.getUsername().matches(".*\\s+.*")){
            throw new UnallowedSpaces("No spaces in username or password, please!");
        } else if (newUser.getUser_password().matches(".*\\s+.*")){
            throw new UnallowedSpaces("No spaces in username or password, please!");
        } else if (newUser.getUsername().isEmpty() || newUser.getFirst_name().isEmpty() ||
                    newUser.getLast_name().isEmpty() || newUser.getUser_password().isEmpty()
                    || newUser.getEmail().isEmpty() ){
            throw new BlankInputs("Please fill in the blank fields :)");
        } else {
            return this.userDAO.createNewUser(newUser);
        }
    }

    @Override
    public User getUserByIdService(int user_id) {
        if(user_id <= 0){
            throw new InvalidInputException("No Negative Nellies!");
        }
        return this.userDAO.getUserById(user_id);
    }

    @Override
    public ArrayList<User> searchForUserService(String username) {
        if(username.isEmpty()){
            throw new InvalidInputException("Feed me a user");
        } else if (username.length() > 50){
            throw new InvalidInputException("That sounds like too big of a meal");
        }
        return this.userDAO.searchForUser(username);
    }

    @Override
    public List<User> getAllUsersService() {
        return this.userDAO.getAllUsers();
    }

    @Override
    public boolean deleteUserService(User userToBeDeleted) {
        return this.userDAO.deleteUser(userToBeDeleted);
    }

    @Override
    public User loginUser(User loginUser) {
        List<User> loginArray = this.userDAO.getAllUsers();
        for(int x = 0; x < loginArray.size(); x++){
            User pulledUser = loginArray.get(x);
            if(this.userLoginRules.checkLoginCredentials(pulledUser, loginUser.getUsername(), loginUser.getUser_password())){
                return loginUser;
            }
        }
        throw new IncorrectLogin("Incorrect login: please try again!");
    }
    
}
