package com.twu.biblioteca.ModelsTest;

import com.twu.biblioteca.Model.Exceptions.LoginDetailsInvalidException;
import com.twu.biblioteca.Model.Login;
import com.twu.biblioteca.Model.LoginData;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LoginModelTest {

    @Test
    public void userShouldBeAbleToLoginWhenCorrectUserInformationIsEntered() throws LoginDetailsInvalidException {
        Login loginModel = new Login();

        loginModel.logIn(new LoginData("123-4567","abcd"));

        Assert.assertTrue(loginModel.checkIfLoggedIn());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void userShouldNotBeAbleToLoginWhenIncorrectUserInformationIsEntered() throws LoginDetailsInvalidException {
        expectedException.expect(LoginDetailsInvalidException.class);

        Login loginModel = new Login();

        loginModel.logIn(new LoginData("someone@thoughtworks.com","abcd"));
    }

    @Test
    public void shouldBeAbleToKeepRecordOfThePresentLoggedInUser() throws LoginDetailsInvalidException {
        Login loginModel = new Login();

        loginModel.logIn(new LoginData("123-4567","abcd"));

        Assert.assertTrue(loginModel.checkIfLoggedIn());
        Assert.assertEquals("123-4567",loginModel.loggedInUserId());
    }

}
