package com.twu.biblioteca.ModelsTest;

import com.twu.biblioteca.Model.Login;
import com.twu.biblioteca.Model.LoginData;
import org.junit.Assert;
import org.junit.Test;

public class LoginModelTest {

    @Test
    public void userShouldBeAbleToLoginWhenCorrectUserInformationIsEntered() {
        Login loginModel = new Login();

        loginModel.logIn(new LoginData("rmoitra@thoughtworks.com","abcd"));

        Assert.assertTrue(loginModel.getLoginStatus());
    }

    @Test
    public void userShouldNotBeAbleToLoginWhenIncorrectUserInformationIsEntered() {
        Login loginModel = new Login();

        loginModel.logIn(new LoginData("someone@thoughtworks.com","abcd"));

        Assert.assertFalse(loginModel.getLoginStatus());
    }
}
