package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.CustomersController;
import com.twu.biblioteca.Model.Result;

public class LoginCommand implements Command {

    private CustomersController customersController;

    public LoginCommand(CustomersController customersController) {

        this.customersController = customersController;
    }

    @Override
    public Result execute() {
        customersController.logIn();
        return new Result(false);
    }

    @Override
    public Integer code() {
        return 7;
    }
}
