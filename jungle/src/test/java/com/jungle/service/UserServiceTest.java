package com.jungle.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import com.jungle.entities.User;
import com.jungle.exceptions.BlankInputs;
import com.jungle.exceptions.DuplicateEmail;
import com.jungle.exceptions.DuplicateUsername;
import com.jungle.exceptions.InvalidInputException;
import com.jungle.exceptions.UnallowedSpaces;
import com.jungle.repository.UserDAO;
import com.jungle.utils.UserLoginRules;

public class UserServiceTest {

    public static UserDAO userDao = new UserDAO();
    public static UserLoginRules userLoginRules = new UserLoginRules();
    public static UserServiceInterface userService = new UserService(userDao, userLoginRules);

    public static UserDAO mockDao = Mockito.mock(UserDAO.class);
    public static UserLoginRules mockLoginRules = Mockito.mock(UserLoginRules.class);
    public static UserServiceInterface mockService = new UserService(mockDao, mockLoginRules);

    @Test
    public void checkUsernameMatchPositiveTest(){ // this test is saying that the user put into here DOESN'T match what is in the database. it does not break biz rules
        User nonMatchUser = new User("nonmatch");
        boolean result = userLoginRules.checkUsernameMatch(nonMatchUser, "crazyorangemonkey");
        Assert.assertTrue(result); // assert true because it is true and does NOT break biz rules
    }

    @Test
    public void checkUsernameMatchNegativeTest(){ // this test is negative because it DOES break biz rules. spongebob is already in the databae
        User matchUser = new User("crazyorangemonkey");
        boolean result = userLoginRules.checkUsernameMatch(matchUser, "crazyorangemonkey");
        Assert.assertFalse(result); // assert false because it is false and DOES break biz rules
    }

    @Test   // this means that my login credentials DO match login credentials in the system
    public void checkLoginCredentialsPositiveTest(){
        User successUser = new User("crazyorangemonkey", "password");
        boolean result = userLoginRules.checkLoginCredentials(successUser, "crazyorangemonkey", "password");
        Assert.assertTrue(result);
    }

    @Test // this means that NEITHER of my login credentials match login credentials in the system
    public void checkLoginCredentialsNegativeTestBoth(){
        User unsuccessUser = new User("incorrect username", "incorrect password");
        boolean result = userLoginRules.checkLoginCredentials(unsuccessUser,"crazyorangemonkey", "password");
        Assert.assertFalse(result);
    }

    @Test // this means that my USERNAME of my login credentials DOES NOT match login credentials in the system
    public void checkLoginCredentialsNegativeTestUsername(){
        User unsuccessUsername = new User("incorrect username", "password");
        boolean result = userLoginRules.checkLoginCredentials(unsuccessUsername,"crazyorangemonkey", "password");
        Assert.assertFalse(result);
    }

    @Test // this means that my PASSWORD of my login credentials DOES NOT match login credentials in the system
    public void checkLoginCredentialsNegativeTestPassword(){
        User unsuccessPassword = new User("crazyorangemonkey", "incorrect password");
        boolean result = userLoginRules.checkLoginCredentials(unsuccessPassword, "crazyorangemonkey", "password");
        Assert.assertFalse(result);
    }

    @Test
    public void serviceGetUserByIdPositive(){
        User result = userService.getUserByIdService(1);
        Assert.assertNotNull(result);
    }

    @Test(expected = InvalidInputException.class)
    public void serviceGetUserByIdNegative(){
        int userId = -1337;
        Mockito.when(userService.getUserByIdService(userId)).thenThrow(new InvalidInputException("Invalid Input: UserId Must Be A Non 0 Positive"));
        mockService.getUserByIdService(userId);
    }

    @Test
    public void serviceSearchForUserPositive(){
        ArrayList<User> result = userService.searchForUserService("crazyorangemonkey");
        Assert.assertNotNull(result);
    }

    @Test(expected = InvalidInputException.class)
    public void serviceSearchForUserEmptyNameNeg(){
        String noSuchUser = "Loremipsumdolorsitamet,consectetueradipiscingelixxxxxxx";
        Mockito.when(userService.searchForUserService(noSuchUser)).thenThrow(new InvalidInputException("Invalid Input: Empty Username"));
        mockService.searchForUserService(noSuchUser);
    }

    @Test(expected = InvalidInputException.class)
    public void serviceSearchForUserExcessiveCharNeg(){
        String noSuchUser = "Loremipsumdolorsitamet,consectetueradipiscingelixxxxxxx";
        Mockito.when(userService.searchForUserService(noSuchUser)).thenThrow(new InvalidInputException("Invalid Input: UserName Exceeds 50 Characters"));
        mockService.searchForUserService(noSuchUser);
    }

    @Test
    public void serviceGetAllUsersPositive(){
        List<User> result = userService.getAllUsersService();
        Assert.assertNotNull(result);
    }

    @Test
    public void mockCreateNewUserPositive(){
        long date = 742892400000L;
        User createNewUser = new User(
            "Chameleon",
            "Greenbean",
            "camoflauge@gmail.com",
            date,
            "camoflauge",
            "password"
        );
        Mockito.when(mockDao.createNewUser(createNewUser)).thenReturn(createNewUser);
        User result = mockService.createNewUserService(createNewUser);
        Assert.assertNotNull(result.getUser_id());
    }

    @Test
    public void mockCreateNewUserNegative(){
        try{
            long date = 742892400000L;
            User createNewUser = new User(
                "Chameleon",
                "Greenbean",
                "",
                date,
                "camoflauge",
                "password"
            );
            Mockito.when(mockDao.createNewUser(createNewUser)).thenReturn(createNewUser);
            mockService.createNewUserService(createNewUser);
            Assert.fail();
        } catch (BlankInputs e){
            Assert.assertEquals("Please fill in the blank fields :)", e.getMessage());
        }
    }

    @Test(expected = DuplicateEmail.class)
    public void createUserDupeEmailNegative(){
            long date = 742892400000L;
            User createUserDupeEmail = new User(
                "Chameleon",
                "Greenbean",
                "hotcheetahs@gmail.com",
                date,
                "camoflauge",
                "password"
            );
            Mockito.when(mockDao.createNewUser(createUserDupeEmail)).thenThrow(new DuplicateEmail("Email already in use!"));
            mockService.createNewUserService(createUserDupeEmail);
    }
    
    @Test(expected = DuplicateUsername.class)
    public void createUserDupeUsernameNegative(){
            long date = 742892400000L;
            User createUserDupeUsername = new User(
                "Chameleon",
                "Greenbean",
                "greenbean@gmail.com",
                date,
                "hotcheetahs",
                "password"
            );
            Mockito.when(mockDao.createNewUser(createUserDupeUsername)).thenThrow(new DuplicateUsername("Username is already taken!"));
            mockService.createNewUserService(createUserDupeUsername);
    }

    @Test(expected = UnallowedSpaces.class)
    public void createUserUnallowedSpacesUsernameNeg(){
        long date = 742892400000L;
        User createUserUnallowedSpacesUsername = new User(
            "Chameleon",
            "Greenbean",
            "greenbean@gmail.com",
            date,
            "green bean",
            "password"
        );
        Mockito.when(mockDao.createNewUser(createUserUnallowedSpacesUsername)).thenThrow(new UnallowedSpaces("No spaces in username!"));
        mockService.createNewUserService(createUserUnallowedSpacesUsername);
    }

    @Test(expected = UnallowedSpaces.class)
    public void createUserUnallowedSpacesPasscodeNeg(){
        long date = 742892400000L;
        User createUserUnallowedSpacesPasscode = new User(
            "Chameleon",
            "Greenbean",
            "greenbean@gmail.com",
            date,
            "greenbean",
            "pass word"
        );
        Mockito.when(mockDao.createNewUser(createUserUnallowedSpacesPasscode)).thenThrow(new UnallowedSpaces("No spaces in password!"));
        mockService.createNewUserService(createUserUnallowedSpacesPasscode);
    }

    @Test(expected = BlankInputs.class)
    public void createUserBlankInputsFNameNeg(){
        long date = 742892400000L;
        User createUserBlankInputs = new User(
            "",
            "Greenbean",
            "greenbean@gmail.com",
            date,
            "greenbean",
            "password"
        );
        Mockito.when(mockDao.createNewUser(createUserBlankInputs)).thenThrow(new BlankInputs("Please enter your first name!"));
        mockService.createNewUserService(createUserBlankInputs);
    }

    @Test(expected = BlankInputs.class)
    public void createUserBlankInputsLNameNeg(){
        long date = 742892400000L;
        User createUserBlankInputsLName = new User(
            "Chameleon",
            "",
            "greenbean@gmail.com",
            date,
            "greenbean",
            "password"
        );
        Mockito.when(mockDao.createNewUser(createUserBlankInputsLName)).thenThrow(new BlankInputs("Please enter your last name!"));
        mockService.createNewUserService(createUserBlankInputsLName);
    }

    @Test(expected = BlankInputs.class)
    public void createUserBlankInputsEmailNeg(){
        long date = 742892400000L;
        User createUserBlankInputsEmail = new User(
            "Chameleon",
            "Greenbean",
            "",
            date,
            "greenbean",
            "password"
        );
        Mockito.when(mockDao.createNewUser(createUserBlankInputsEmail)).thenThrow(new BlankInputs("Please enter an email!"));
        mockService.createNewUserService(createUserBlankInputsEmail);
    }

    @Test(expected = BlankInputs.class)
    public void createUserBlankInputsUsernameNeg(){
        long date = 742892400000L;
        User createUserBlankInputsUsername = new User(
            "Chameleon",
            "Greenbean",
            "greenbean@gmail.com",
            date,
            "",
            "password"
        );
        Mockito.when(mockDao.createNewUser(createUserBlankInputsUsername)).thenThrow(new BlankInputs("Please enter a username!"));
        mockService.createNewUserService(createUserBlankInputsUsername);
    }

    @Test(expected = BlankInputs.class)
    public void createUserBlankInputsPasscodeNeg(){
        long date = 742892400000L;
        User createUserBlankInputsPasscode = new User(
            "Chameleon",
            "Greenbean",
            "greenbean@gmail.com",
            date,
            "greenbean",
            ""
        );
        Mockito.when(mockDao.createNewUser(createUserBlankInputsPasscode)).thenThrow(new BlankInputs("Please enter a password!"));
        mockService.createNewUserService(createUserBlankInputsPasscode);
    }

    @Test(expected = BlankInputs.class)
    public void createUserBlankInputsBirthdateNeg(){
        // long date = 742892400000L;
        User createUserBlankInputsBirthdate = new User(
            "Chameleon",
            "Greenbean",
            "greenbean@gmail.com",
            0L,
            "greenbean",
            "password"
        );
        Mockito.when(mockDao.createNewUser(createUserBlankInputsBirthdate)).thenThrow(new BlankInputs("Please enter your date of birth!"));
        mockService.createNewUserService(createUserBlankInputsBirthdate);
    }
    
}
