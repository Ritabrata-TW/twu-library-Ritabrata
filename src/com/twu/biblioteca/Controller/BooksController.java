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

    public Book checkoutBook(String bookName) throws BookNotFoundException {
        try {
            return booksModel.checkoutBook(bookName);
        }
        catch (BookNotFoundException bookNotfoundException) {
            throw new BookNotFoundException("Book not found");
        }

    }
}
