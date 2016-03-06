package com.twu.biblioteca.Model;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;

import java.util.List;

public class Movies implements Items {
    List<Item> movies;
    private Customers customersModel;

    public Movies(List<Item> movies, Customers customersModel) {
        this.movies = movies;
        this.customersModel = customersModel;
    }

    @Override
    public List<Item> getItems() {
        return movies;
    }

    @Override
    public Item checkoutItem(int movieNumber) throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        isInputValid(movieNumber);
        isLoggedIn();

        for (Item movie : movies) {
            if (movie.getNumber() == movieNumber && !movie.checkoutStatus()) {
                movie.checkout(customersModel.loggedInUserId());
                return movie;
            }

        }
        throw new NotFoundException("This movie doesn't exist in the records");
    }

    public void isLoggedIn() throws UserNotLoggedInException {
        if (!customersModel.checkIfLoggedIn())
            throw new UserNotLoggedInException();
    }

    private void isInputValid(int movieNumber) throws InvalidInputException {
        if (movieNumber == -1) {
            throw new InvalidInputException();
        }
    }

    @Override
    public void returnItem(Integer movieNumber) throws InvalidInputException, BookAlreadyPresentException, UserNotLoggedInException {
        isInputValid(movieNumber);
        isLoggedIn();

        for (Item movie : movies) {
            if (movie.getNumber().equals(movieNumber) && movie.checkoutStatus()) {
                movie.returnItem();
                return;
            }

        }
        throw new BookAlreadyPresentException("This movie doesn't exist in the records");
    }
}
