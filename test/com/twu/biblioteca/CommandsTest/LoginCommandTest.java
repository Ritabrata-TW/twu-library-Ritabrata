package com.twu.biblioteca.CommandsTest;

import com.twu.biblioteca.Controller.CustomersController;
import com.twu.biblioteca.Model.Commands.LoginCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginCommandTest {

    @Test
    public void shouldBeAbleToLogin() {
        CustomersController customersController = mock(CustomersController.class);
        LoginCommand loginCommand = new LoginCommand(customersController);

        loginCommand.execute();

        verify(customersController).logIn();
    }
}
