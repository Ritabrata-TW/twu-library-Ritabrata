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
    Command checkoutBookCommand;

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
        checkoutBookCommand = mock(CheckoutBookCommand.class);

        doNothing().when(commandFactory).register(0,invalidInputCommand);
        doNothing().when(menuController).welcome();
        router = new Router(dependencies);

        when(displayBooksCommand.execute()).thenReturn(1);
        when(invalidInputCommand.execute()).thenReturn(1);
        when(checkoutBookCommand.execute()).thenReturn(1);
        when(exitCommand.execute()).thenReturn(0);

    }


    @Test
    public void shouldBeAbleToWelcomeTheUser() {
        when(menuController.mainMenu())
                .thenReturn(1)
                .thenReturn(2);

        when(commandFactory.commandFor(1)).thenReturn(displayBooksCommand);
        when(commandFactory.commandFor(2)).thenReturn(exitCommand);

        router.startApp();

        verify(menuController).welcome();
    }


    @Test
    public void shouldBeAbleToDisplayBookListForTheUserWhenHeChoosesOneOnMainMenu() {
        when(menuController.mainMenu())
                .thenReturn(1)
                .thenReturn(2);

        when(commandFactory.commandFor(1)).thenReturn(displayBooksCommand);
        when(commandFactory.commandFor(2)).thenReturn(exitCommand);

        router.startApp();

        verify(displayBooksCommand).execute();
    }


    @Test
    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNumericInvalidMenuOptionInMainMenuOption() {
        when(menuController.mainMenu())
                .thenReturn(0)
                .thenReturn(2);

        when(commandFactory.commandFor(0)).thenReturn(invalidInputCommand);
        when(commandFactory.commandFor(2)).thenReturn(exitCommand);

        router.startApp();

        verify(invalidInputCommand).execute();
    }

    @Test
    public void ShouldBeAbleToQuitApplicationIfUserOptsTheQuitOption() {
        when(menuController.mainMenu())
                .thenReturn(2);

        when(commandFactory.commandFor(2)).thenReturn(exitCommand);

        router.startApp();

        verify(exitCommand).execute();

    }

    @Test
    public void shouldBeAbleToCheckoutABookWhenUserEntersOptionForCheckout() {
        when(menuController.mainMenu())
                .thenReturn(3)
                .thenReturn(2);
        when(commandFactory.commandFor(3)).thenReturn(checkoutBookCommand);
        when(commandFactory.commandFor(2)).thenReturn(exitCommand);

        router.startApp();

        verify(checkoutBookCommand).execute();

    }
}
