package com.jungle.api;

import com.jungle.controllers.UserController;
import com.jungle.repository.UserDAO;
import com.jungle.service.UserService;
import com.jungle.utils.HibernateUtil;
import com.jungle.utils.UserLoginRules;

import io.javalin.Javalin;

public class Main {

    public static void main (String[] args){

        HibernateUtil.getSessionFactory();

        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });

        UserDAO userDAO = new UserDAO();
        UserLoginRules userLoginRules = new UserLoginRules();
        UserService userService = new UserService(userDAO, userLoginRules);
        UserController userController = new UserController(userService);

        // user controllers
        app.patch("/user/login", userController.loginUser);
        app.post("/user/registration", userController.registerUser);
        app.get("/user/search/{username}", userController.SearchUserByUsername);
        app.get("/user/{userId}", userController.getUserById);
        app.get("/users", userController.getAllUsers);

        app.start();

    }
    
}
