package com.twu.biblioteca.Model;

import com.twu.biblioteca.Model.DTO.Book;
import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;

import java.util.List;

//Welcome User, Display Main menu
public class Books {
    String welcomeMessage;
    List<Book> books;

    public Books(List<Book> books) {
        welcomeMessage = "**** Welcome Customer! We are glad to have you at Books! ****";
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book checkoutBook(int bookNumber) throws NotFoundException, InvalidInputException {
        isInputValid(bookNumber);

        for (Book book : books) {
            if (book.getNumber().equals(bookNumber) && !book.checkoutStatus()) {
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
