package com.twu.biblioteca.ModelsTest;

import org.junit.Assert;
import org.junit.Test;

public class LoginModelTest {

    @Test
    public void userShouldBeAbleToLoginWhenCorrectUserInformationIsEntered() {
        Login loginModel = new Login();

        loginModel.logIn("rmoitra@thoughtworks.com","abcd");

        Assert.assertTrue(loginModel.getLoginStatus());
    }

    @Test
    public void userShouldNotBeAbleToLoginWhenIncorrectUserInformationIsEntered() {
        Login loginModel = new Login();

        loginModel.logIn("someone@thoughtworks.com","abcd");

        Assert.assertFalse(loginModel.getLoginStatus());
    }
}
