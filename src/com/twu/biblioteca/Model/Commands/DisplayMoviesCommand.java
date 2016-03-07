package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Model.Result;

public class DisplayMoviesCommand implements Command {
    ItemController itemController;

    public DisplayMoviesCommand(ItemController itemController) {
        this.itemController = itemController;
    }

    @Override
    public Result execute() {
        itemController.displayItems();
        return new Result(false);
    }

    @Override
    public Integer code() {
        return 4;
    }
}
