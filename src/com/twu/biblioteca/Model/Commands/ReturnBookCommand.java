package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Model.Result;

public class ReturnBookCommand implements Command {

    private ItemController itemController;

    public ReturnBookCommand(ItemController itemController) {
        this.itemController = itemController;
    }

    @Override
    public Result execute() {
        itemController.returnItem("book");
        return new Result(false);
    }

    @Override
    public Integer code() {
        return 3;
    }
}
