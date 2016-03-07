package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.MenusController;
import com.twu.biblioteca.Model.Result;

public class InvalidInputCommand implements Command {
    private MenusController menuController;

    public InvalidInputCommand(MenusController menuController) {
        this.menuController = menuController;
    }

    @Override
    public Result execute() {
        menuController.displayMessage("Select a valid option!");
        return new Result(false);
    }

    @Override
    public Integer code() {
        return -1;
    }
}
