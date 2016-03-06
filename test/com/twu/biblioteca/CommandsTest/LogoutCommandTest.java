package com.twu.biblioteca.CommandsTest;

import com.twu.biblioteca.Controller.CustomersController;
import com.twu.biblioteca.Model.Commands.LogoutCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LogoutCommandTest {
    @Test
    public void shouldBeAbleToLogout() {
        CustomersController customersController = mock(CustomersController.class);
        LogoutCommand logoutCommand = new LogoutCommand(customersController);

        logoutCommand.execute();

        verify(customersController).logout();
    }

}
