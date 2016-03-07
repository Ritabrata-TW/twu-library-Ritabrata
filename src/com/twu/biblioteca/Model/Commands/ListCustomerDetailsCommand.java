package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.CustomersController;
import com.twu.biblioteca.Model.Result;

public class ListCustomerDetailsCommand implements Command {
    private CustomersController customersController;

    public ListCustomerDetailsCommand(CustomersController customersController) {
        this.customersController = customersController;
    }

    @Override
    public Result execute() {
        customersController.displayDetails();
        return new Result(false);
    }

    @Override
    public Integer code() {
        return 9;
    }
}
