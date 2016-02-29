package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.BookNotFoundException;
import com.twu.biblioteca.View.BooksView;
import com.twu.biblioteca.Model.BooksModel;

public class BooksController {
    BooksModel booksModel;
    BooksView booksView;

    public BooksController(BooksModel booksModel, BooksView booksView) {
        this.booksModel = booksModel;
        this.booksView = booksView;
    }

    public void displayBooks(){
        booksView.displayBooks(booksModel.getBooks());
    }

    public void checkoutBook(String bookName) {
        try {
            booksModel.checkoutBook(bookName);
            booksView.displayMessage("You have Successfully checked out " + bookName);
        }
        catch (BookNotFoundException bookNotfoundException) {
            booksView.displayMessage("This Book is not Present in the library now. ");
        }
    }
}
