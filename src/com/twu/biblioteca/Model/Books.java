package com.twu.biblioteca.Model;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;

import java.util.List;

//Welcome User, Display Main menu
public class Books implements Items{
    String welcomeMessage;
    List<Book> books;

    public Books(List<Book> books) {
        welcomeMessage = "**** Welcome Customer! We are glad to have you at Books! ****";
        this.books = books;
    }

    @Override
    public List<Book> getItems() {
        return books;
    }

    @Override
    public Object checkoutItem(int number) throws NotFoundException, InvalidInputException {
        isInputValid(number);

        for (Book book : books) {
            if (book.getNumber().equals(number) && !book.checkoutStatus()) {
                book.checkout();
                return book;
            }

        }
        throw new NotFoundException("This book doesn't exist in the records");
    }

    public void returnBook(Integer bookNumber) throws BookAlreadyPresentException, InvalidInputException {
        isInputValid(bookNumber);


        for (Book book : books) {
            if (book.getNumber().equals(bookNumber) && book.checkoutStatus()) {
                book.returnBook();
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
