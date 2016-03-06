package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.CustomersController;

public class LogoutCommand implements Command {
    private CustomersController customersController;

    public LogoutCommand(CustomersController customersController) {
        this.customersController = customersController;
    }

    @Override
    public int execute() {
        customersController.logout();
        return 1;
    }
}
