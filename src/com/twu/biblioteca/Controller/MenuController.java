package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.DisplayBooksCommand;
import com.twu.biblioteca.Model.MenuModel;
import com.twu.biblioteca.View.MenuView;

public class MenuController {
    private MenuModel menuModel;
    private MenuView menuView;
    private BooksController booksController;

    public MenuController(MenuModel menuModel, MenuView menuView, BooksController booksController) {
        this.menuModel = menuModel;
        this.menuView = menuView;
        this.booksController = booksController;
    }

    public void mainMenu() {
        int choice = menuView.displayMenuOptions(menuModel.getOptions());
        if (choice != 1) {
            menuView.displayMessage("Select a valid option!");
            return;
        }

        new DisplayBooksCommand().execute(booksController);
    }

    public void displayMenu() {
        menuView.displayMenuOptions(menuModel.getOptions());
    }
}

