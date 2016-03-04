package com.twu.biblioteca.ControllersTest;

import com.twu.biblioteca.Controller.LoginController;
import com.twu.biblioteca.Model.Login;
import com.twu.biblioteca.Model.LoginData;
import com.twu.biblioteca.View.LoginView;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginControllerTest {
    Login loginModel;
    LoginView loginView;
    LoginController loginController;

    @Before
    public void setup() {
        loginModel = mock(Login.class);
        loginView = mock(LoginView.class);
        loginController = new LoginController(loginModel,loginView);
    }

    @Test
    public void shouldBeAbleToAskUserForHisDetails() {
        loginController.logIn();

        verify(loginView).inputDetails();
    }

    @Test
    public void shouldBeAbleToLogInUserOnRecieveingDetails() {
        LoginData loginData = new LoginData("ritabrata1808@live.com", "abcd");
        when(loginView.inputDetails()).thenReturn(loginData);

        loginController.logIn();

        verify(loginModel).logIn(loginData);
    }
}
