package com.twu.biblioteca;

import com.twu.biblioteca.Controller.MoviesController;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Model.Movies;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.MoviesView;
import org.junit.Before;
import org.junit.Test;

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
        movie = new Movie(1, "The Schindler's List", 1994, "Steven Spielberg", 10);
        movies = new ArrayList<Movie>();
        movies.add(movie);
        moviesModel = mock(Movies.class);
        moviesView = mock(MoviesView.class);
        appView = mock(AppView.class);
        moviesController = new MoviesController(moviesModel, moviesView);
        when(moviesModel.getMovies()).thenReturn(movies);
    }

    @Test
    public void shouldBeAbleToDisplayBooks() {
        doNothing().when(moviesView).displayMovies(movies);

        moviesController.displayMovies();

        verify(moviesView).displayMovies(movies);
    }

}
