package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Login;
import com.twu.biblioteca.Model.LoginData;
import com.twu.biblioteca.View.LoginView;

public class LoginController {
    private Login loginModel;
    private LoginView loginView;

    public LoginController(Login loginModel, LoginView loginView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
    }


    public void logIn() {
        LoginData loginData = loginView.inputDetails();
        loginModel.logIn(loginData);
    }
}
