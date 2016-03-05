package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.LoginController;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;

import java.util.List;

//Welcome User, Display Main menu
public class Books implements Items {
    String welcomeMessage;
    List<Item> books;

    public Books(List<Item> books) {
        welcomeMessage = "**** Welcome Customer! We are glad to have you at Books! ****";
        this.books = books;
    }

    @Override
    public List<Item> getItems() {
        return books;
    }

    @Override
    public Item checkoutItem(int number, LoginController loginController) throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        isInputValid(number);
        checkIfLoggedIn(loginController);

        for (Item book : books) {
            if (book.getNumber().equals(number) && !book.checkoutStatus()) {
                book.checkout(loginController.loggedInUserId());
                return book;
            }

        }
        throw new NotFoundException("This book doesn't exist in the records");
    }


    @Override
    public void returnItem(Integer bookNumber, LoginController loginController) throws InvalidInputException, BookAlreadyPresentException, UserNotLoggedInException {
        isInputValid(bookNumber);
        checkIfLoggedIn(loginController);

        for (Item book : books) {
            if (book.getNumber().equals(bookNumber) && book.checkoutStatus()) {
                book.returnItem();
                return;
            }

        }
        throw new BookAlreadyPresentException("That is not a valid book to return.");
    }

    private void isInputValid(Integer bookNumber) throws InvalidInputException {
        if (bookNumber == -1) {
            throw new InvalidInputException();
        }
    }

    public void checkIfLoggedIn(LoginController loginController) throws UserNotLoggedInException {
        if (!loginController.checkIfLoggedIn())
            throw new UserNotLoggedInException();
    }
}
