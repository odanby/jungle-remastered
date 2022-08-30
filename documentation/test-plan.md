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

My deadline is 9/16.

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

## Sprint Backlog and Acceptance Criteria
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
    - Users can create a profile (about me, status, dob, groups)
    - Users can update their profile
    - Users can create their own avatar as their profile pic
- User Posts
    - Users can create a post
    - Users can delete a post
- User Comments
    - Users can create a comment
    - Users can delete a comment

## Testing Requirements
See Sprint Backlog for what user stories we will be testing for.


- Unit Tests
    - "Repository Layer"
        - All methods must have a positive test
            - This is where we will take a single piece of the application's code logic and test it in isolation
            - The goal of this is to check the logic of the code we have written
    - "Service Layer"
        - All methods must have a negative test per business rule
            - We can use Mockito to stub the methods for these tests
            - This is where we will confirm that we have handled any business logic that has specifically been requested

- Integration Tests
    - API
        - All routes must have a positive test
        - All routes must have a negative test per business rue

- End to End Tests
    - All acceptance criteria must be tested via Cucumber and Selenium

## Timeline
- Week of 8/29 - 9/2
    - Create wireframes
    - Write documentation
    - Turn user stories into acceptance criteria
    - Create project management board (serving as requirements traceability matrix)
    - Create database
    - Create basic UI
    - Create all entities/objects, repo tests, service tests
- Week of 9/2 - 9/9
    - More advanced UI design
    - Create profile avatar feature
- Week of 9/12 - 9/16
    - End to End tests
    - Debugging
    - Present project to family