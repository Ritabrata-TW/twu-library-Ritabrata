package com.twu.biblioteca.CommandsTest;

import com.twu.biblioteca.Controller.LoginController;
import com.twu.biblioteca.Model.Commands.LoginCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginCommandTest {

    @Test
    public void shouldBeAbleToLogin() {
        LoginController loginController = mock(LoginController.class);
        LoginCommand loginCommand = new LoginCommand(loginController);

        loginCommand.execute();

        verify(loginController).logIn();
    }
}
