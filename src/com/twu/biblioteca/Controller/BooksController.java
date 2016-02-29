package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.BookAlreadyPresentException;
import com.twu.biblioteca.Model.BookNotFoundException;
import com.twu.biblioteca.Model.BooksModel;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.BooksView;

public class BooksController {
    BooksModel booksModel;
    BooksView booksView;
    private AppView appView;

    public BooksController(BooksModel booksModel, BooksView booksView, AppView appView) {
        this.booksModel = booksModel;
        this.booksView = booksView;
        this.appView = appView;
    }

    public void displayBooks() {
        booksView.displayBooks(booksModel.getBooks());
    }

    public void checkoutBook(String bookName) {
        try {
            booksModel.checkoutBook(bookName);
            appView.displayMessage("Thank you! Enjoy the book! " + bookName);
        } catch (BookNotFoundException bookNotfoundException) {
            appView.displayMessage("That book is not available.");
        }
    }

    public String getBookName(String message) {
        appView.displayMessage(message);
        return booksView.getBookname();
    }

    public void returnBook(String bookName) {
        try {
            booksModel.returnBook(bookName);
            appView.displayMessage("Thank you for returning the book.");
        } catch(BookAlreadyPresentException bookAlreadyPresentException) {
            appView.displayMessage("That is not a valid book to return.");
        }
    }
}
