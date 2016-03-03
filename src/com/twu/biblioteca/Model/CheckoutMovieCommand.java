package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.MoviesController;

public class CheckoutMovieCommand implements Command{
    private MoviesController moviesController;

    public CheckoutMovieCommand(MoviesController moviesController) {
        this.moviesController = moviesController;
    }

    @Override
    public int execute() {
        int movieNumber = moviesController.getMovieNumber("Enter the number of the movie that you want to checkout");

        moviesController.checkoutMovie(movieNumber);

        return 1;
    }
}
