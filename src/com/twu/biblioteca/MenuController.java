package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuController {
    private MenuView menuView;
    BooksModel booksModel;

    public MenuController(MenuView menuView,BooksModel booksModel) {
        this.menuView = menuView;
        this.booksModel = booksModel;
    }

    public void mainMenu() {
        int choice = menuView.mainMenu();
        if(choice == 1) {
            menuView.displayBooks(booksModel.getBooks());
        }

        menuView.displayMessage("Select a valid option!");
    }
}
