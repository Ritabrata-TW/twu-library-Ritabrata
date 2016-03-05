package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Exceptions.LoginDetailsInvalidException;
import com.twu.biblioteca.Model.Login;
import com.twu.biblioteca.Model.LoginData;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.LoginView;

public class LoginController {
    private Login loginModel;
    private LoginView loginView;
    private AppView appView;


    public LoginController(Login loginModel, LoginView loginView, AppView appView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
        this.appView = appView;
    }


    public void logIn() throws LoginDetailsInvalidException {
        LoginData loginData = loginView.inputDetails();

        try{
            loginModel.logIn(loginData);
            appView.displayMessage("Login Successful!");
        }catch (LoginDetailsInvalidException loginDetailsInvalidException) {
            appView.displayMessage("Invalid Login details. Please try again.");
        }
    }
}
