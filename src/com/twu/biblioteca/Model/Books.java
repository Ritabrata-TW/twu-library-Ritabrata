package com.twu.biblioteca.Model;

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
    private Customers customersModel;

    public Books(List<Item> books, Customers customersModel) {
        welcomeMessage = "**** Welcome Customer! We are glad to have you at Books! ****";
        this.books = books;
        this.customersModel = customersModel;
    }

    @Override
    public List<Item> getItems() {
        return books;
    }

    @Override
    public Item checkoutItem(int number) throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        isInputValid(number);
        if (!customersModel.checkIfLoggedIn())
            throw new UserNotLoggedInException();

        for (Item book : books) {
            if (book.getNumber().equals(number) && !book.checkoutStatus()) {
                book.checkout(customersModel.loggedInUserId());
                return book;
            }

        }
        throw new NotFoundException("This book doesn't exist in the records");
    }


    @Override
    public void returnItem(Integer bookNumber) throws InvalidInputException, BookAlreadyPresentException, UserNotLoggedInException {
        isInputValid(bookNumber);
        if (!customersModel.checkIfLoggedIn())
            throw new UserNotLoggedInException();

        for (Item book : books) {
            if (book.getNumber().equals(bookNumber) && book.checkoutStatus() && book.getCheckedOutBy().equals(customersModel.loggedInUserId())) {
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

    public void checkIfLoggedIn() throws UserNotLoggedInException {
        if (!customersModel.checkIfLoggedIn())
            throw new UserNotLoggedInException();
    }
}
