package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.BookNotFoundException;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.BooksView;
import com.twu.biblioteca.Model.BooksModel;

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
            appView.displayMessage("You have Successfully checked out " + bookName);
        } catch (BookNotFoundException bookNotfoundException) {
            appView.displayMessage("This Book is not Present in the library now. ");
        }
    }

    public String getBookName(String message) {
        appView.displayMessage(message);
        return booksView.getBookname();
    }
}
