package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Controller.MenuController;

public class DisplayBooksCommand implements Command {
    public BooksController booksController;
    private MenuController menuController;

    public DisplayBooksCommand(BooksController booksController, MenuController menuController) {
        this.booksController = booksController;
        this.menuController = menuController;
    }

    @Override
    public int execute() {
        booksController.displayBooks();
        return 1;
    }
}
