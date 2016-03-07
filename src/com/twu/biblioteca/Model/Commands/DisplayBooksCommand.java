package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;

public class DisplayBooksCommand implements Command {
    public ItemController itemController;

    public DisplayBooksCommand(ItemController itemController) {
        this.itemController = itemController;
    }

    @Override
    public int execute() {
        itemController.displayItems();
        return 1;
    }

    @Override
    public Integer code() {
        return 1;
    }
}
