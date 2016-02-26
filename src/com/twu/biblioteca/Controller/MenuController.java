package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Command;
import com.twu.biblioteca.Model.CommandFactory;
import com.twu.biblioteca.Model.MenuModel;
import com.twu.biblioteca.View.MenuView;

public class MenuController {
    private MenuModel menuModel;
    private MenuView menuView;
    private BooksController booksController;
    private CommandFactory commandFactory;

    public MenuController(MenuModel menuModel, MenuView menuView, BooksController booksController, CommandFactory commandFactory) {
        this.menuModel = menuModel;
        this.menuView = menuView;
        this.booksController = booksController;
        this.commandFactory = commandFactory;
    }

    public void mainMenu() {
        int choice = menuView.displayMenuOptions(menuModel.getOptions());
//        if (choice == 1) {
//            new DisplayBooksCommand().execute(booksController);
//            return;
//        }
//        menuView.displayMessage("Select a valid option!");
        Command command = commandFactory.commandFor(choice);
        command.execute(booksController);
    }
}

