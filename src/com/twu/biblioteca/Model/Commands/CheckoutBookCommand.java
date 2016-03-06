package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;

public class CheckoutBookCommand implements Command {

    private ItemController itemController;

    public CheckoutBookCommand(ItemController itemController) {
        this.itemController = itemController;
    }

    @Override
    public int execute() {
        itemController.checkoutItem();
        return 1;
    }
}
