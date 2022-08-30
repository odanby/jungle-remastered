# Test Plan

A test plan is a project-wide document with information specific to the project that it is attached to.

It:
- explains what technologies are being used
- deadlines
- what is actually being developed/tested
- other project specific info

## Goal
My goal is to create a full-stack social media application, "The Jungle".

I will be creating a functional user interface that works with a dynamic database, and run automated tests of every level to ensure our application meets all of our sprint requirements.

My deadline is 9/9.

## Technologies
- HTML
    - The backbone of webpages
- CSS
    - Styles webpages
- Javascript
    - Helps add dynamic features to UI
    - Methods to work with API
- Java
    - Hibernate
        - Uses object-relational mapping to connect Java code with SQL database
    - Cucumber-Junit
        - Testing framework that integrates with Cucumber
    - Cucumber
        - Testing framework to turn acceptance criteria into executable steps
    - Selenium
        - Browser automation tool
- SQL
    - Heroku
    - DBeaver
- Mockito
    - Can create mock objects so I can run service tests without affecting our database
- Javalin
    - Supports HTTP requests
- Postman
    - Can set up API
- Trello
    - Project management board

## Sprint Backlog
These are all the user stories we need to complete to create a minimum viable product (MVP):

- User Registration
    - Users can register a new account
    - System should ensure there are no duplicate emails
    - System should ensure there are no duplicate usernames
- User Login
    - Users can login with correct credentials
    - System will not allow incorrect credentials to login
- User Logout
    - Users can log out
- User Profile
    - Users
- User Posts
- User Comments
- Group Create/Join
- Group Profile
- Group Posts
- Group Comments
- Chat Page
    - Global
    - Group