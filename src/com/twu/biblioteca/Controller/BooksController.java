package com.twu.biblioteca.Controller;

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
}
