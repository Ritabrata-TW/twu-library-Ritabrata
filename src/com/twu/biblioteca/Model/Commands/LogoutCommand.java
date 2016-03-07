package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.CustomersController;
import com.twu.biblioteca.Model.Result;

public class LogoutCommand implements Command {
    private CustomersController customersController;

    public LogoutCommand(CustomersController customersController) {
        this.customersController = customersController;
    }

    @Override
    public Result execute() {
        customersController.logout();
        return new Result(false);
    }

    @Override
    public Integer code() {
        return 8;
    }
}
