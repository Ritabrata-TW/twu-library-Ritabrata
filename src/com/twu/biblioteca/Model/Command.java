package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;

public interface Command {
    void execute(BooksController booksController);
}
