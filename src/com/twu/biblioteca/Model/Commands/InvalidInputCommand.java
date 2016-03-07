package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.MenusController;

public class InvalidInputCommand implements Command {
    private MenusController menuController;

    public InvalidInputCommand(MenusController menuController) {
        this.menuController = menuController;
    }

    @Override
    public int execute() {
        menuController.displayMessage("Select a valid option!");
        return 1;
    }

    @Override
    public Integer code() {
        return -1;
    }
}
