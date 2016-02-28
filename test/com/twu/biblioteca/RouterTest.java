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
    Command exitCommand;

    @Before
    public void setup() {
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
        exitCommand = mock(ExitCommand.class);

        doNothing().when(commandFactory).register(0,invalidInputCommand);
        doNothing().when(menuController).welcome();
        router = new Router(dependencies);
        doNothing().when(displayBooksCommand).execute();

    }


    @Test
    public void shouldBeAbleToWelcomeTheUser() {
        when(menuController.mainMenu()).thenReturn(1);
        when(commandFactory.commandFor(1)).thenReturn(displayBooksCommand);


        router.startApp();

        verify(menuController).welcome();
    }


    @Test
    public void shouldBeAbleToDisplayBookListForTheUserWhenHeChoosesOneOnMainMenu() {
        when(menuController.mainMenu()).thenReturn(1);
        when(commandFactory.commandFor(1)).thenReturn(displayBooksCommand);


        router.startApp();

        verify(displayBooksCommand).execute();
    }


    @Test
    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNumericInvalidMenuOptionInMainMenuOption() {
        when(menuController.mainMenu()).thenReturn(0);
        when(commandFactory.commandFor(0)).thenReturn(invalidInputCommand);

        router.startApp();

        verify(invalidInputCommand).execute();
    }

    @Test
    public void ShouldBeAbleToQuitApplicationIfUserOptsTheQuitOption() {
        when(menuController.mainMenu()).thenReturn(9);
        when(commandFactory.commandFor(9)).thenReturn(exitCommand);

        router.startApp();

        verify(exitCommand).execute();

    }
}
