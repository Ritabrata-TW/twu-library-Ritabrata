package com.twu.biblioteca.CommandsTest;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.CustomersController;
import com.twu.biblioteca.Model.Commands.CheckoutMovieCommand;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutMovieCommandTest {
    @Test
    public void shouldBeAbleToCheckoutMovieWhenCommandIsExecuted() {
        ItemController moviesController = mock(ItemController.class);
        CheckoutMovieCommand checkoutMovieCommand = new CheckoutMovieCommand(moviesController);
        when(moviesController.getItemNumber("Enter the number of the item that you want to checkout")).thenReturn(1);

        checkoutMovieCommand.execute();

        verify(moviesController).checkoutItem("movie");
    }


}
