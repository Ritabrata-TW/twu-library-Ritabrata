package com.twu.biblioteca;

import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.View.InputOutputHandler;
import com.twu.biblioteca.View.MoviesView;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MoviesViewTest {
    InputOutputHandler inputOutputHandler;
    MoviesView moviesView;
    List<Movie> movies;
    Movie schindlersList;
    Movie swades;


    @Before
    public void setup() {
        inputOutputHandler = mock(InputOutputHandler.class);
        movies = new ArrayList<Movie>();
        schindlersList = new Movie(1, "The Schindler's List", 1994, "Steven Spielberg", 10);
        swades = new Movie(2, "Swades", 2000, "Rakesh Roshan", 8);
        movies.add(schindlersList);
        movies.add(swades);
        moviesView = new MoviesView(inputOutputHandler);
    }

    @Test
    public void PresentBookListMustBeDisplayedForTheUser() {
        moviesView.displayMovies(movies);

        verify(inputOutputHandler).writeMessage("1 The Schindler's List 1994 Steven Spielberg 10.0");
        verify(inputOutputHandler).writeMessage("2 Swades 2000 Rakesh Roshan 8.0");
    }
}
