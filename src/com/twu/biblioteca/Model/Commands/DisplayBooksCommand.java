package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Model.Result;

public class DisplayBooksCommand implements Command {
    public ItemController itemController;

    public DisplayBooksCommand(ItemController itemController) {
        this.itemController = itemController;
    }

    @Override
    public Result execute() {
        itemController.displayItems();
        return new Result(false);
    }

    @Override
    public Integer code() {
        return 1;
    }
}
