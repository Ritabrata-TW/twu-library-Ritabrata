package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.LoginController;

public class CheckoutBookCommand implements Command {

    private ItemController itemController;
    private LoginController loginController;

    public CheckoutBookCommand(ItemController itemController, LoginController loginController) {
        this.itemController = itemController;
        this.loginController = loginController;
    }

    @Override
    public int execute() {
        itemController.checkoutItem(loginController);
        return 1;
    }
}
