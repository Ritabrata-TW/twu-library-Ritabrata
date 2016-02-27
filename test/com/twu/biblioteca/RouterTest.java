package com.twu.biblioteca;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Controller.MenuController;
import com.twu.biblioteca.Model.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RouterTest {
    Router router;
    Dependencies dependencies;
    DisplayBooksCommand displayBooksCommand;
    BooksController booksController;
    MenuController menuController;
    CommandFactory commandFactory;
    InvalidInputCommand invalidInputCommand;

    @Before
    public void setup() {
        router = new Router();
        dependencies = mock(Dependencies.class);
        displayBooksCommand = mock(DisplayBooksCommand.class);
        booksController = mock(BooksController.class);
        when(dependencies.get(DisplayBooksCommand.class)).thenReturn(displayBooksCommand);
        menuController = mock(MenuController.class);
        when(dependencies.get(MenuController.class)).thenReturn(menuController);
        commandFactory = mock(CommandFactory.class);
        when(dependencies.get(CommandFactory.class)).thenReturn(commandFactory);
        doNothing().when(commandFactory).register(1,displayBooksCommand);
        invalidInputCommand = mock(InvalidInputCommand.class);
        doNothing().when(commandFactory).register(0,invalidInputCommand);
    }

    @Test
    public void shouldBeAbleToWelcomeTheUser() {
        router.startApp();

        verify(menuController).welcome();
    }


    @Test
    public void shouldBeAbleToDisplayBookListForTheUserWhenHeChoosesOneOnMainMenu() {

    }


//    @Test
//    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNumericInvalidMenuOptionInMainMenuOption() {
//
//    }
//
//    @Test
//    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNonNumericInvalidMenuOptionInMainMenuOption() {
//
//    }
}
