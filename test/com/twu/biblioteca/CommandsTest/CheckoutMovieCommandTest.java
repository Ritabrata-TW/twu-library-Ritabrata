package com.twu.biblioteca.CommandsTest;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.LoginController;
import com.twu.biblioteca.Model.Commands.CheckoutMovieCommand;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutMovieCommandTest {
    @Test
    public void shouldBeAbleToCheckoutMovieWhenCommandIsExecuted() {
        LoginController loginController = mock(LoginController.class);
        ItemController moviesController = mock(ItemController.class);
        CheckoutMovieCommand checkoutMovieCommand = new CheckoutMovieCommand(moviesController, loginController);
        when(moviesController.getItemNumber("Enter the number of the item that you want to checkout")).thenReturn(1);

        checkoutMovieCommand.execute();

        verify(moviesController).checkoutItem(loginController);
    }


}
