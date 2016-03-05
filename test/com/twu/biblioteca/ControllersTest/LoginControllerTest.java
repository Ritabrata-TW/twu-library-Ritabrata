package com.twu.biblioteca.ControllersTest;

import com.twu.biblioteca.Controller.LoginController;
import com.twu.biblioteca.Model.Exceptions.LoginDetailsInvalidException;
import com.twu.biblioteca.Model.Login;
import com.twu.biblioteca.Model.LoginData;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.LoginView;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoginControllerTest {
    Login loginModel;
    LoginView loginView;
    LoginController loginController;
    AppView appView;

    @Before
    public void setup() {
        loginModel = mock(Login.class);
        loginView = mock(LoginView.class);
        appView = mock(AppView.class);
        loginController = new LoginController(loginModel,loginView,appView);
    }

    @Test
    public void shouldBeAbleToAskUserForHisDetails() throws LoginDetailsInvalidException {
        loginController.logIn();

        verify(loginView).inputDetails();
    }

    @Test
    public void shouldBeAbleToLogInUserOnRecieveingDetails() throws LoginDetailsInvalidException {
        LoginData loginData = new LoginData("ritabrata1808@live.com", "abcd");
        when(loginView.inputDetails()).thenReturn(loginData);

        loginController.logIn();

        verify(loginModel).logIn(loginData);
    }

    @Test
    public void shouldBeAbleToNotifyUserOnInvalidInputOfData() throws LoginDetailsInvalidException {
        when(loginView.inputDetails()).thenReturn(new LoginData("abcd","abcd"));
        doThrow(LoginDetailsInvalidException.class).when(loginModel).logIn(new LoginData("abcd","abcd"));

        loginController.logIn();

        verify(appView).displayMessage("Invalid Login details. Please try again.");
    }
}
