package com.twu.biblioteca.CommandsTest;

import com.twu.biblioteca.Controller.MenusController;
import com.twu.biblioteca.Model.Commands.InvalidInputCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InvalidInputCommandTest {
    @Test
    public void shouldBeAbleToDisplayInvalidInputWarning() {
        MenusController menuController = mock(MenusController.class);
        InvalidInputCommand invalidInputCommand = new InvalidInputCommand(menuController);

        invalidInputCommand.execute();

        verify(menuController).displayMessage("Select a valid option!");
    }
}
