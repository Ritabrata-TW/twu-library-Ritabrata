package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.CustomersController;

public class LoginCommand implements Command{

    private CustomersController customersController;

    public LoginCommand(CustomersController customersController){

        this.customersController = customersController;
    }

    @Override
    public int execute() {
        customersController.logIn();
        return 1;
    }
}
