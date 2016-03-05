package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.LoginController;
import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;

import java.util.List;

public interface Items<T> {
    List<?> getItems();
    T checkoutItem(int number, LoginController loginController) throws InvalidInputException, NotFoundException, UserNotLoggedInException;
    void returnItem(Integer number) throws InvalidInputException, BookAlreadyPresentException;

}
