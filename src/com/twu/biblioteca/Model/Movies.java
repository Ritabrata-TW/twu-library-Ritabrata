package com.twu.biblioteca.Model;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;

import java.util.List;

public class Movies implements Items{
    List<Item> movies;

    public Movies(List<Item> movies) {
        this.movies = movies;
    }

    @Override
    public List<Item> getItems() {
        return movies;
    }

    @Override
    public Item checkoutItem(int movieNumber) throws NotFoundException, InvalidInputException {
        if (movieNumber == -1) {
            throw new InvalidInputException();
        }

        for (Item movie : movies) {
            if (movie.getNumber() == movieNumber && !movie.checkoutStatus()) {
                movie.checkout();
                return movie;
            }

        }
        throw new NotFoundException("This movie doesn't exist in the records");
    }

    @Override
    public void returnItem(Integer movieNumber) throws InvalidInputException, BookAlreadyPresentException {
        if (movieNumber == -1) {
            throw new InvalidInputException();
        }

        for (Item movie : movies) {
            if (movie.getNumber().equals(movieNumber) && movie.checkoutStatus()) {
                movie.returnItem();
                return;
            }

        }
        throw new BookAlreadyPresentException("This movie doesn't exist in the records");
    }
}
