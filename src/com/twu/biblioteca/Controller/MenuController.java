package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.BooksModel;
import com.twu.biblioteca.View.MenuView;

public class MenuController {
    private MenuView menuView;
    BooksModel booksModel;

    public MenuController(MenuView menuView, BooksModel booksModel) {
        this.menuView = menuView;
        this.booksModel = booksModel;
    }

    public void mainMenu() {
        int choice = menuView.mainMenu();
        if (choice != 1) {
            menuView.displayMessage("Select a valid option!");
            return;
        }
        menuView.displayBooks(booksModel.getBooks());
    }
}

