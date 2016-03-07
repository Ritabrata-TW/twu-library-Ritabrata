package com.twu.biblioteca.ControllersTest;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.MenusController;
import com.twu.biblioteca.Controller.Router;
import com.twu.biblioteca.Model.Commands.*;
import com.twu.biblioteca.Model.Dependencies;
import com.twu.biblioteca.Model.Result;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RouterTest {
    Router router;
    Dependencies dependencies;
    DisplayBooksCommand displayBooksCommand;
    ItemController itemController;
    MenusController menuController;
    CommandFactory commandFactory;
    InvalidInputCommand invalidInputCommand;
    ExitCommand exitCommand;
    CheckoutBookCommand checkoutBookCommand;
    ReturnBookCommand returnBookCommand;
    DisplayMoviesCommand displayMoviesCommand;
    CheckoutMovieCommand checkoutMovieCommand;
    LoginCommand loginCommand;
    LogoutCommand logoutCommand;
    Result continueLoop;
    Result terminateLoop;
    ListCustomerDetailsCommand listCustomerDetailsCommand;
    ReturnMovieCommand returnMovieCommand;


    @Before
    public void setup() {
        dependencies = mock(Dependencies.class);
        displayBooksCommand = mock(DisplayBooksCommand.class);
        displayMoviesCommand = mock(DisplayMoviesCommand.class);
        itemController = mock(ItemController.class);
        when(dependencies.get(DisplayBooksCommand.class)).thenReturn(displayBooksCommand);
        menuController = mock(MenusController.class);
        when(dependencies.get(MenusController.class)).thenReturn(menuController);
        commandFactory = mock(CommandFactory.class);
        when(dependencies.get(CommandFactory.class)).thenReturn(commandFactory);
        doNothing().when(commandFactory).register(1, displayBooksCommand);
        invalidInputCommand = mock(InvalidInputCommand.class);
        exitCommand = mock(ExitCommand.class);
        checkoutBookCommand = mock(CheckoutBookCommand.class);
        returnBookCommand = mock(ReturnBookCommand.class);
        checkoutMovieCommand = mock(CheckoutMovieCommand.class);
        loginCommand = mock(LoginCommand.class);
        logoutCommand = mock(LogoutCommand.class);
        listCustomerDetailsCommand = mock(ListCustomerDetailsCommand.class);
        returnMovieCommand = mock(ReturnMovieCommand.class);

        continueLoop = new Result(false);
        terminateLoop = new Result(true);

        doNothing().when(commandFactory).register(0, invalidInputCommand);
        doNothing().when(menuController).welcome();
        router = new Router(dependencies);



        when(checkoutBookCommand.execute()).thenReturn(continueLoop);
        when(checkoutMovieCommand.execute()).thenReturn(continueLoop);
        when(displayBooksCommand.execute()).thenReturn(continueLoop);
        when(displayMoviesCommand.execute()).thenReturn(continueLoop);
        when(exitCommand.execute()).thenReturn(terminateLoop);
        when(invalidInputCommand.execute()).thenReturn(continueLoop);
        when(listCustomerDetailsCommand.execute()).thenReturn(continueLoop);
        when(loginCommand.execute()).thenReturn(continueLoop);
        when(logoutCommand.execute()).thenReturn(continueLoop);
        when(returnBookCommand.execute()).thenReturn(continueLoop);
        when(returnMovieCommand.execute()).thenReturn(continueLoop);
    }


    @Test
    public void shouldBeAbleToWelcomeTheUser() {
        when(menuController.mainMenu())
                .thenReturn(1)
                .thenReturn(0);

        when(commandFactory.commandFor(1)).thenReturn(displayBooksCommand);
        when(commandFactory.commandFor(0)).thenReturn(exitCommand);

        router.startApp();

        verify(menuController).welcome();
    }


    @Test
    public void shouldBeAbleToDisplayBookListForTheUserWhenHeChoosesOneOnMainMenu() {
        when(menuController.mainMenu())
                .thenReturn(1)
                .thenReturn(0);

        when(commandFactory.commandFor(1)).thenReturn(displayBooksCommand);
        when(commandFactory.commandFor(0)).thenReturn(exitCommand);

        router.startApp();

        verify(displayBooksCommand).execute();
    }


    @Test
    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNumericInvalidMenuOptionInMainMenuOption() {
        when(menuController.mainMenu())
                .thenReturn(-1)
                .thenReturn(0);

        when(commandFactory.commandFor(-1)).thenReturn(invalidInputCommand);
        when(commandFactory.commandFor(0)).thenReturn(exitCommand);

        router.startApp();

        verify(invalidInputCommand).execute();
    }

    @Test
    public void ShouldBeAbleToQuitApplicationIfUserOptsTheQuitOption() {
        when(menuController.mainMenu())
                .thenReturn(0);

        when(commandFactory.commandFor(0)).thenReturn(exitCommand);

        router.startApp();

        verify(exitCommand).execute();

    }

    @Test
    public void shouldBeAbleToCheckoutABookWhenUserEntersOptionForCheckout() {
        when(menuController.mainMenu())
                .thenReturn(3)
                .thenReturn(0);
        when(commandFactory.commandFor(3)).thenReturn(checkoutBookCommand);
        when(commandFactory.commandFor(0)).thenReturn(exitCommand);

        router.startApp();

        verify(checkoutBookCommand).execute();
    }

    @Test
    public void shouldBeAbleToReturnABookWhenUserEntersOptionForReturn() {
        when(menuController.mainMenu()).thenReturn(4).thenReturn(0);

        when(commandFactory.commandFor(4)).thenReturn(returnBookCommand);
        when(commandFactory.commandFor(0)).thenReturn(exitCommand);

        router.startApp();

        verify(returnBookCommand).execute();
    }

    @Test
    public void shouldBeAbleToListAllMoviesWhenUserEntersOptionForListMovies() {
        when(menuController.mainMenu()).thenReturn(5).thenReturn(0);

        when(commandFactory.commandFor(5)).thenReturn(displayMoviesCommand);
        when(commandFactory.commandFor(0)).thenReturn(exitCommand);

        router.startApp();

        verify(displayMoviesCommand).execute();
    }

    @Test
    public void shouldBeAbleToCheckoutAMovieWhenUserEntersOptionForCheckout() {
        when(menuController.mainMenu())
                .thenReturn(6)
                .thenReturn(0);

        when(commandFactory.commandFor(6)).thenReturn(checkoutMovieCommand);
        when(commandFactory.commandFor(0)).thenReturn(exitCommand);

        router.startApp();

        verify(checkoutMovieCommand).execute();
    }

    @Test
    public void shouldBeAbleToLogInWhenUserEntersOptionForLogout() {
        when(menuController.mainMenu())
                .thenReturn(7)
                .thenReturn(0);

        when(commandFactory.commandFor(7)).thenReturn(loginCommand);
        when(commandFactory.commandFor(0)).thenReturn(exitCommand);

        router.startApp();

        verify(loginCommand).execute();

    }

    @Test
    public void shouldBeAbleToLogoutWhenUserEntersOptionForLogout() {
        when(menuController.mainMenu())
                .thenReturn(8)
                .thenReturn(0);

        when(commandFactory.commandFor(8)).thenReturn(logoutCommand);
        when(commandFactory.commandFor(0)).thenReturn(exitCommand);

        router.startApp();

        verify(logoutCommand).execute();

    }

    @Test
    public void shouldBeAbleToExecuteMultipleOperationsBeforeQuittingTheApplication() {
        when(menuController.mainMenu())
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3)
                .thenReturn(4)
                .thenReturn(0);

        when(commandFactory.commandFor(1)).thenReturn(displayBooksCommand);
        when(commandFactory.commandFor(2)).thenReturn(checkoutBookCommand);
        when(commandFactory.commandFor(3)).thenReturn(returnBookCommand);
        when(commandFactory.commandFor(4)).thenReturn(checkoutMovieCommand);
        when(commandFactory.commandFor(0)).thenReturn(exitCommand);
        when(displayBooksCommand.execute()).thenReturn(continueLoop);
        when(checkoutBookCommand.execute()).thenReturn(continueLoop);
        when(returnBookCommand.execute()).thenReturn(continueLoop);
        when(checkoutMovieCommand.execute()).thenReturn(continueLoop);
        when(exitCommand.execute()).thenReturn(terminateLoop);
        router.startApp();

        verify(displayBooksCommand).execute();
        verify(checkoutBookCommand).execute();
        verify(returnBookCommand).execute();
        verify(checkoutMovieCommand).execute();
        verify(exitCommand).execute();
    }


}
