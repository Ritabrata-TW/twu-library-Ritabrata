package com.twu.biblioteca;

import com.twu.biblioteca.Controller.MoviesController;
import com.twu.biblioteca.Model.CheckoutMovieCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutMovieCommandTest {
    @Test
    public void shouldBeAbleToCheckoutMovieWhenCommandIsExecuted() {
        MoviesController moviesController = mock(MoviesController.class);
        CheckoutMovieCommand checkoutMovieCommand = new CheckoutMovieCommand(moviesController);
        when(moviesController.getMovieNumber("Enter the number of the movie that you want to checkout")).thenReturn(1);

        checkoutMovieCommand.execute();

        verify(moviesController).checkoutMovie(1);
    }


}
