package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Model.Result;

public class ReturnMovieCommand implements Command {
    private ItemController itemController;

    public ReturnMovieCommand(ItemController itemController) {
        this.itemController = itemController;
    }

    @Override
    public Result execute() {
        itemController.returnItem("movie");
        return new Result(false);
    }

    @Override
    public Integer code() {
        return 6;
    }
}
