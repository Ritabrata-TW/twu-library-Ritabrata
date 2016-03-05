package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.LoginController;

public class LoginCommand implements Command{

    private LoginController loginController;

    public LoginCommand(LoginController loginController){

        this.loginController = loginController;
    }

    @Override
    public int execute() {
        loginController.logIn();
        return 1;
    }
}
