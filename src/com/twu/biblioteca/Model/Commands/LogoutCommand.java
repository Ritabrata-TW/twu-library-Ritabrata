package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.LoginController;

public class LogoutCommand implements Command {
    private LoginController loginController;

    public LogoutCommand(LoginController loginController){
        this.loginController = loginController;
    }

    @Override
    public int execute() {
        loginController.logout();
        return 1;
    }
}
