package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Model.Result;

public class CheckoutBookCommand implements Command {

    private ItemController itemController;

    public CheckoutBookCommand(ItemController itemController) {
        this.itemController = itemController;
    }

    @Override
    public Result execute() {
        itemController.checkoutItem("book");
        return new Result(false);
    }

    @Override
    public Integer code() {
        return 2;
    }
}
