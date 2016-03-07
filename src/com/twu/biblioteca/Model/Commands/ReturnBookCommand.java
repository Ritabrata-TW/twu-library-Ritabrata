package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;

public class ReturnBookCommand implements Command {

    private ItemController itemController;

    public ReturnBookCommand(ItemController itemController) {
        this.itemController = itemController;
    }

    @Override
    public int execute() {
        itemController.returnItem("book");
        return 1;
    }

    @Override
    public Integer code() {
        return 3;
    }
}
