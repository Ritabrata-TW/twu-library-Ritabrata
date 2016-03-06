package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.CustomersController;

public class ReturnBookCommand implements Command {

    private ItemController itemController;
    private CustomersController customersController;

    public ReturnBookCommand(ItemController itemController, CustomersController customersController) {
        this.itemController = itemController;
        this.customersController = customersController;
    }

    @Override
    public int execute() {
        itemController.returnItem();
        return 1;
    }
}
