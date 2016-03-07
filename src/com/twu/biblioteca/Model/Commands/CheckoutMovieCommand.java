package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;

public class CheckoutMovieCommand implements Command {
    private ItemController itemController;

    public CheckoutMovieCommand(ItemController itemController) {
        this.itemController = itemController;
    }

    @Override
    public int execute() {
        itemController.checkoutItem("movie");
        return 1;
    }

    @Override
    public Integer code() {
        return 5;
    }
}
