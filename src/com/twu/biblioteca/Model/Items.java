package com.twu.biblioteca.Model;

import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;

import java.util.List;

public interface Items<T> {
    List<?> getItems();
    T checkoutItem(int number) throws InvalidInputException,NotFoundException;
    void returnItem(Integer number) throws InvalidInputException, BookAlreadyPresentException;

}
