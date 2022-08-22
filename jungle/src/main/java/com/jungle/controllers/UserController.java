package com.jungle.controllers;

import com.jungle.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.jungle.exceptions.*;
import com.jungle.entities.User;


import io.javalin.http.Handler;

public class UserController {

    private UserService userService;
    private Gson gson;

    public UserController(UserService userService){
        this.userService = userService;
        this.gson = new Gson();
    }

    public Handler loginUser = ctx -> {
        
        try {
           // get json from request body
           String json = ctx.body();
  
           // convert json to our java object
           User userToLogin = this.gson.fromJson(json, User.class);
  
           // pass the data into the service layer and get method result back
           User result = this.userService.loginUser(userToLogin);
  
           // convert the result into a json
           String resultJson = this.gson.toJson(result);
  
           // set the response body and status code
           ctx.result(resultJson);
           ctx.status(200);
  
        } catch(IncorrectLogin e) {
           // create a map to easily make key/value pair for json
           Map<String, String> message =  new HashMap<>();
  
           // place the exception message into the map
           message.put("message", e.getMessage());
  
           // convert the map into a json
           String messageJson = this.gson.toJson(message);
  
           // attach the json to the response body and set the status code
           ctx.result(messageJson);
           ctx.status(400); 
        }
       };

    public Handler SearchUserByUsername = ctx -> {
        String username = ctx.pathParam("username");
        Gson gson = new Gson();
        try {
            ArrayList<User> users = this.userService.searchForUserService(username);
            if(users == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
            HashMap<String, ArrayList<User>> map = new HashMap<>();
            map.put("searchResult", users);
            String userJSON = gson.toJson(map);
            ctx.result(userJSON);
            ctx.status(200);
        } catch (InvalidInputException e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    public Handler getAllUsers = ctx -> {
        Gson gson = new Gson();
        try {
            List<User> users = this.userService.getAllUsersService();
            if (users == null) {
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
            String usersJSONs = gson.toJson(users);
            ctx.result(usersJSONs);
            ctx.status(200);
        } catch (UserNotFound e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };   

    public Handler getUserById = ctx -> {
        int userId = Integer.parseInt(ctx.pathParam("userId"));
        Gson gson = new Gson();
        try {
            User user = this.userService.getUserByIdService(userId);
            if (user == null) {
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String userJSON = gson.toJson(user);
                ctx.result(userJSON);
                ctx.status(200);
            }
        } catch (InvalidInputException e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        } catch (UserNotFound e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        } catch (UsernameOrPasscodeException e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };
    
    public Handler registerUser = ctx -> {
        Gson gson = new Gson();
        try {
            User newUser = gson.fromJson(ctx.body(), User.class);
            User createdUser = this.userService.createNewUserService(newUser);
            if (createdUser == null) {
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
            String createdUserJson = gson.toJson(createdUser);
            ctx.result(createdUserJson);
            ctx.status(201);
        } catch (UnallowedSpaces e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        } catch (DuplicateEmail e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        } catch (DuplicateUsername e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        } catch (BlankInputs e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };
}
