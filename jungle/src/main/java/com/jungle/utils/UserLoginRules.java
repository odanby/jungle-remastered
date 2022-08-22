package com.jungle.utils;

import com.jungle.entities.User;

public class UserLoginRules {
    
    public boolean checkUsernameMatch(User userToCheck, String actualUsername) {

        if(userToCheck.getUsername().equals(actualUsername)){                    
            return false;   // if the business rule is broken, we return false
        } else {
            return true;    // if the business rule is being followed, we return true
        }
    }

    // this is part of my check to see if login credentials match an entry
    public boolean checkLoginCredentials(User credentialsToCheck, String actualUsernameCredential, String actualPasswordCredential){
        if(credentialsToCheck.getUsername().equals(actualUsernameCredential) && credentialsToCheck.getUser_password().equals(actualPasswordCredential)){
            return true;    // business rule is being followed
        } else {
            return false;   // business rule is being broken
        }
    }
}
