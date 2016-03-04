package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.MoviesController;

public class CheckoutMovieCommand implements Command {
    private MoviesController moviesController;

    public CheckoutMovieCommand(MoviesController moviesController) {
        this.moviesController = moviesController;
    }

    @Override
    public int execute() {

        moviesController.checkoutMovie();

        return 1;
    }
}
