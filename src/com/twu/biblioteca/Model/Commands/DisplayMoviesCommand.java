package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;

public class DisplayMoviesCommand implements Command {
    ItemController itemController;

    public DisplayMoviesCommand(ItemController itemController) {
        this.itemController = itemController;
    }

    @Override
    public int execute() {
        itemController.displayItems();
        return 1;
    }

    @Override
    public Integer code() {
        return 4;
    }
}
