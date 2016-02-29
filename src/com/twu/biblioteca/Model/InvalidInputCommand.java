package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.MenuController;

public class InvalidInputCommand implements Command {
    private MenuController menuController;

    public InvalidInputCommand(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public int execute() {
        menuController.displayMessage("Select a valid option!");
        return 1;
    }
}
