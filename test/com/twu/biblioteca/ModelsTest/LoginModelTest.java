package com.twu.biblioteca.ModelsTest;

import com.twu.biblioteca.Model.Exceptions.LoginDetailsInvalidException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;
import com.twu.biblioteca.Model.Login;
import com.twu.biblioteca.Model.LoginData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LoginModelTest {
    Login loginModel;

    @Before
    public void setup() {
        loginModel = new Login();
    }

    @Test
    public void userShouldBeAbleToLoginWhenCorrectUserInformationIsEntered() throws LoginDetailsInvalidException {
        loginModel.logIn(new LoginData("123-4567", "abcd"));

        Assert.assertTrue(loginModel.checkIfLoggedIn());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void userShouldNotBeAbleToLoginWhenIncorrectUserInformationIsEntered() throws LoginDetailsInvalidException {
        expectedException.expect(LoginDetailsInvalidException.class);

        loginModel.logIn(new LoginData("someone@thoughtworks.com", "abcd"));
    }

    @Test
    public void shouldBeAbleToKeepRecordOfThePresentLoggedInUser() throws LoginDetailsInvalidException {
        loginModel.logIn(new LoginData("123-4567", "abcd"));

        Assert.assertTrue(loginModel.checkIfLoggedIn());
        Assert.assertEquals("123-4567", loginModel.loggedInUserId());
    }

    @Test
    public void shouldBeAbleToLogout() throws LoginDetailsInvalidException, UserNotLoggedInException {
        loginModel.logIn(new LoginData("123-4567", "abcd"));

        loginModel.logout();

        Assert.assertFalse(loginModel.checkIfLoggedIn());
        Assert.assertEquals(null,loginModel.loggedInUserId());
    }

    @Test
    public void shouldNotBeAbleToLogoutIfNotPreviouslyLoggedIn() throws UserNotLoggedInException {
        expectedException.expect(UserNotLoggedInException.class);

        loginModel.logout();
    }

}
