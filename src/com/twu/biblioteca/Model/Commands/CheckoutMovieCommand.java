package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Model.Result;

public class CheckoutMovieCommand implements Command {
    private ItemController itemController;

    public CheckoutMovieCommand(ItemController itemController) {
        this.itemController = itemController;
    }

    @Override
    public Result execute() {
        itemController.checkoutItem("movie");
        return new Result(false);
    }

    @Override
    public Integer code() {
        return 5;
    }
}
