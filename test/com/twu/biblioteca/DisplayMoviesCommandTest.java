package com.twu.biblioteca;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Controller.MoviesController;
import com.twu.biblioteca.Model.DisplayBooksCommand;
import com.twu.biblioteca.Model.DisplayMoviesCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DisplayMoviesCommandTest {
    @Test
    public void shouldBeAbleToDisplayBooksWhenCommandIsExecuted() {
        MoviesController moviesController = mock(MoviesController.class);
        DisplayMoviesCommand displayMoviesCommand = new DisplayMoviesCommand(moviesController);

        displayMoviesCommand.execute();

        verify(moviesController).displayMovies();
    }
}
