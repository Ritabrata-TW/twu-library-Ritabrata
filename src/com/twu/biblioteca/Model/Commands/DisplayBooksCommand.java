package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.BooksController;

public class DisplayBooksCommand implements Command {
    public BooksController booksController;

    public DisplayBooksCommand(BooksController booksController) {
        this.booksController = booksController;
    }

    @Override
    public int execute() {
        booksController.displayBooks();
        return 1;
    }
}
