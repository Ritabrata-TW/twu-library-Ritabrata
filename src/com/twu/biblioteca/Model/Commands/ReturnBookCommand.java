package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.BooksController;

public class ReturnBookCommand implements Command {

    private BooksController booksController;

    public ReturnBookCommand(BooksController booksController) {

        this.booksController = booksController;
    }

    @Override
    public int execute() {
        booksController.returnBook();
        return 1;
    }
}
