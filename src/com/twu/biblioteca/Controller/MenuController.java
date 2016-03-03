package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.MenuModel;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.MenuView;

public class MenuController {
    private MenuModel menuModel;
    private MenuView menuView;
    private AppView appView;

    public MenuController(MenuModel menuModel, MenuView menuView, AppView appView) {
        this.menuModel = menuModel;
        this.menuView = menuView;
        this.appView = appView;
    }

    public int mainMenu() {
        int choice = menuView.displayMenuOptions(menuModel.getOptions());
        return menuModel.validateChoice(choice);
    }

    public void displayMessage(String message) {
        appView.displayMessage(message);
    }

    public void welcome() {
        menuView.welcome();
    }


}

