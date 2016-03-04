package com.twu.biblioteca.View;

import com.twu.biblioteca.Model.DTO.Movie;

import java.util.List;

public class MoviesView {
    InputOutputHandler inputOutputHandler;

    public MoviesView(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            if (!movie.checkoutStatus())
                inputOutputHandler.writeMessage(movie.toString());
        }
    }

    public Integer getMovieNumber(String message) {
        try {
            return inputOutputHandler.input(message);
        } catch (Exception exception) {
            return -1;
        }
    }

}
