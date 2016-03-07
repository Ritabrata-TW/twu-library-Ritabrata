package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.CustomersController;

public class ListCustomerDetailsCommand implements Command {
    private CustomersController customersController;

    public ListCustomerDetailsCommand(CustomersController customersController) {
        this.customersController = customersController;
    }

    @Override
    public int execute() {
        customersController.displayDetails();
        return 1;
    }

    @Override
    public Integer code() {
        return 9;
    }
}
