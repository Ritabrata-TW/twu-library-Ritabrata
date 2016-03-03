package com.twu.biblioteca.View;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Movie;

import java.util.List;

public class MoviesView {
    InputOutputHandler inputOutputHandler;

    public MoviesView(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayMovies(List<Movie> movies) {
        for (Movie movie:movies) {
            inputOutputHandler.writeMessage(movie.toString());
        }
    }

}
