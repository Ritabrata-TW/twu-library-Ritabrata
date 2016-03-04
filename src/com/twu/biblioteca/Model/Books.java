package com.twu.biblioteca.Model;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;

import java.util.List;

//Welcome User, Display Main menu
public class Books implements Items{
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
    public Object checkoutItem(int number) throws NotFoundException, InvalidInputException {
        isInputValid(number);

        for (Item book : books) {
            if (book.getNumber().equals(number) && !book.checkoutStatus()) {
                book.checkout();
                return book;
            }

        }
        throw new NotFoundException("This book doesn't exist in the records");
    }



    @Override
    public void returnItem(Integer bookNumber) throws InvalidInputException, BookAlreadyPresentException {
        isInputValid(bookNumber);

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
}
