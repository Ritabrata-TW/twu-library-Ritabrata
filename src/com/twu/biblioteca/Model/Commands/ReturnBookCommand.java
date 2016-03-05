package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.LoginController;

public class ReturnBookCommand implements Command {

    private ItemController itemController;
    private LoginController loginController;

    public ReturnBookCommand(ItemController itemController, LoginController loginController) {
        this.itemController = itemController;
        this.loginController = loginController;
    }

    @Override
    public int execute() {
        itemController.returnItem(loginController);
        return 1;
    }
}
