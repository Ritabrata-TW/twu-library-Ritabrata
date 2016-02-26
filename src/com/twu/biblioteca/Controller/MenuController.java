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
        return choice;
    }
}

