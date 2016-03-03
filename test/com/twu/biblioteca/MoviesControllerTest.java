package com.twu.biblioteca;

import com.sun.org.glassfish.external.statistics.annotations.Reset;
import com.twu.biblioteca.Controller.MoviesController;
import com.twu.biblioteca.Model.InvalidInputException;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Model.Movies;
import com.twu.biblioteca.Model.NotFoundException;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.MoviesView;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class MoviesControllerTest {
    ArrayList<Movie> movies;
    Movies moviesModel;
    MoviesView moviesView;
    MoviesController moviesController;
    Movie movie;
    AppView appView;


    @Before
    public void setup() {
        movie = new Movie(1, "The Schindler's List", 1994, "Steven Spielberg", 10, false);
        movies = new ArrayList<Movie>();
        movies.add(movie);
        moviesModel = mock(Movies.class);
        moviesView = mock(MoviesView.class);
        appView = mock(AppView.class);
        moviesController = new MoviesController(moviesModel, moviesView, appView);
        when(moviesModel.getMovies()).thenReturn(movies);
    }

    @Test
    public void shouldBeAbleToDisplayBooks() {
        doNothing().when(moviesView).displayMovies(movies);

        moviesController.displayMovies();

        verify(moviesView).displayMovies(movies);
    }

    @Test
    public void shouldBeAbleToDisplaySuccesMessageToUserOnSuccessfulCheckoutOfAMovie() {
        moviesController.checkoutMovie(1);

        verify(appView).displayMessage("Thank you! Enjoy the movie! ");
    }

    @Test
    public void shouldBeAbleToWarnInvalidInputToUser() throws NotFoundException, InvalidInputException {
        when(moviesModel.checkoutMovie(100)).thenThrow(new InvalidInputException());

        moviesController.checkoutMovie(100);

        verify(appView).displayMessage("Please select a valid option! ");
    }

    @Test
    public void shouldBeAbleToWarnInvalidInputToUserIfMovieIsNotFound() throws NotFoundException, InvalidInputException {
        when(moviesModel.checkoutMovie(100)).thenThrow(new NotFoundException("Movie not found"));

        moviesController.checkoutMovie(100);

        verify(appView).displayMessage("That book is not available.");
    }

}
