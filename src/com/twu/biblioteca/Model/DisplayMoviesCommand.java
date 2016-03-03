package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.MoviesController;

public class DisplayMoviesCommand implements Command{
    MoviesController moviesController;

    public DisplayMoviesCommand(MoviesController moviesController) {
        this.moviesController = moviesController;
    }

    @Override
    public int execute() {
        moviesController.displayMovies();
        return 1;
    }
}
