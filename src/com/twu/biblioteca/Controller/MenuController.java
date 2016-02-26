package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.BooksModel;
import com.twu.biblioteca.Model.DisplayBooksCommand;
import com.twu.biblioteca.View.MenuView;

public class MenuController {
    private MenuView menuView;
    private BooksController booksController;

    public MenuController(MenuView menuView, BooksController booksController) {
        this.menuView = menuView;
        this.booksController = booksController;
    }

    public void mainMenu() {
        int choice = menuView.mainMenu();
        if (choice != 1) {
            menuView.displayMessage("Select a valid option!");
            return;
        }

//        booksController.displayBooks();
        new DisplayBooksCommand().execute(booksController);
    }
}

