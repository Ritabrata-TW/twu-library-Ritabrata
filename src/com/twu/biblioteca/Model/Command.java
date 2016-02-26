package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.View.MenuView;

public interface Command {
    void execute(MenuView menuView);
}
