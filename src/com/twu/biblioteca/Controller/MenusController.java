package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Menus;
import com.twu.biblioteca.View.MenuView;

public class MenusController {
    private Menus menuModel;
    private MenuView menuView;

    public MenusController(Menus menuModel, MenuView menuView) {
        this.menuModel = menuModel;
        this.menuView = menuView;
    }

    public int mainMenu() {
        int choice = menuView.displayMenuOptions(menuModel.getOptions());
        return menuModel.validateChoice(choice);
    }

    public void displayMessage(String message) {
        menuView.displayMessage(message);
    }

    public void welcome() {
        menuView.welcome();
    }
}

