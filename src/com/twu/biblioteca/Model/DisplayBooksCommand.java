package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.View.MenuView;

public class DisplayBooksCommand implements Command {

    @Override
    public void execute(BooksController booksController) {
        booksController.displayBooks();
    }
}
