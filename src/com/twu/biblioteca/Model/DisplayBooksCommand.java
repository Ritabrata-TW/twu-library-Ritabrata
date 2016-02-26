package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;

public class DisplayBooksCommand implements Command {
    public BooksController booksController;

    public DisplayBooksCommand(BooksController booksController) {

        this.booksController = booksController;
    }

    @Override
    public void execute() {
        booksController.displayBooks();
    }
}
