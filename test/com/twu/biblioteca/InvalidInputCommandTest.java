package com.twu.biblioteca;

import com.twu.biblioteca.Controller.MenuController;
import com.twu.biblioteca.Model.InvalidInputCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InvalidInputCommandTest {
    @Test
    public void shouldBeAbleToDisplayInvalidInputWarning() {
        MenuController menuController = mock(MenuController.class);
        InvalidInputCommand invalidInputCommand = new InvalidInputCommand(menuController);

        invalidInputCommand.execute();

        verify(menuController).displayMessage("Select a valid option!");
    }
}
