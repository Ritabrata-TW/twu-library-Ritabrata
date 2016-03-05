package com.twu.biblioteca.CommandsTest;

import com.twu.biblioteca.Controller.LoginController;
import com.twu.biblioteca.Model.Commands.LogoutCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LogoutCommandTest {
    @Test
    public void shouldBeAbleToLogout() {
        LoginController loginController = mock(LoginController.class);
        LogoutCommand logoutCommand = new LogoutCommand(loginController);

        logoutCommand.execute();

        verify(loginController).logout();
    }

}
