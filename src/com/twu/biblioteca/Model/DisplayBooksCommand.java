package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;

public class DisplayBooksCommand implements Command {

    @Override
    public void execute(BooksController booksController) {
        booksController.displayBooks();
    }
}
