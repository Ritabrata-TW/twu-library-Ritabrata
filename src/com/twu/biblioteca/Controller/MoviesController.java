package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.InvalidInputException;
import com.twu.biblioteca.Model.Movies;
import com.twu.biblioteca.Model.NotFoundException;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.MoviesView;

public class MoviesController {
    private Movies moviesModel;
    private MoviesView moviesView;
    private AppView appView;

    public MoviesController(Movies moviesModel, MoviesView moviesView, AppView appView) {
        this.moviesModel = moviesModel;
        this.moviesView = moviesView;
        this.appView = appView;
    }

    public void displayMovies() {
        moviesView.displayMovies(moviesModel.getMovies());
    }

    public void checkoutMovie(Integer movieNumber) {
        try {
            moviesModel.checkoutMovie(movieNumber);
            appView.displayMessage("Thank you! Enjoy the movie! ");
        } catch (NotFoundException bookNotfoundException) {
            appView.displayMessage("That book is not available.");
        } catch (InvalidInputException invalidInputException ) {
            appView.displayMessage("Please select a valid option! ");
        }
    }

    public Integer getMovieNumber(String message) {
        return moviesView.getMovieNumber(message);
    }
}
