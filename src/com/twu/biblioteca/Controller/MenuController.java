package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.MenuModel;
import com.twu.biblioteca.View.MenuView;

public class MenuController {
    private MenuModel menuModel;
    private MenuView menuView;

    public MenuController(MenuModel menuModel, MenuView menuView) {
        this.menuModel = menuModel;
        this.menuView = menuView;
    }

    public int mainMenu() {
        int choice = menuView.displayMenuOptions(menuModel.getOptions());

        if(choice >=1 && choice <=2)
        return choice;

        return 0;
    }

    public void WarnInvalidInput() {
        menuView.displayMessage("Select a valid option!");
    }

    public void welcome() {
        menuView.welcome();
    }
}

