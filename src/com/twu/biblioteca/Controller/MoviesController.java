package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Movies;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.ItemsView;

public class MoviesController {
    private Movies moviesModel;
    private ItemsView itemsView;
    private AppView appView;

    public MoviesController(Movies moviesModel, ItemsView itemsView, AppView appView) {
        this.moviesModel = moviesModel;
        this.itemsView = itemsView;
        this.appView = appView;
    }

    public void displayMovies() {
        itemsView.displayItems(moviesModel.getItems());
    }

    public void checkoutMovie() {
        int movieNumber = getMovieNumber("Enter the number of the movie that you want to checkout");

        try {
            moviesModel.checkoutItem(movieNumber);
            appView.displayMessage("Thank you! Enjoy the movie! ");
        } catch (NotFoundException bookNotfoundException) {
            appView.displayMessage("That book is not available.");
        } catch (InvalidInputException invalidInputException) {
            appView.displayMessage("Please select a valid option! ");
        }
    }

    public Integer getMovieNumber(String message) {
        return itemsView.getItemNumber(message);
    }
}
