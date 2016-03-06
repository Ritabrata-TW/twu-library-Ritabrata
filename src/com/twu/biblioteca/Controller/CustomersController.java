package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Exceptions.LoginDetailsInvalidException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;
import com.twu.biblioteca.Model.Customers;
import com.twu.biblioteca.Model.LoginData;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.CustomersView;

public class CustomersController {
    private Customers customersModel;
    private CustomersView customersView;
    private AppView appView;


    public CustomersController(Customers customersModel, CustomersView customersView, AppView appView) {
        this.customersModel = customersModel;
        this.customersView = customersView;
        this.appView = appView;
    }


    public void logIn() {
        LoginData loginData = customersView.inputDetails();

        try {
            customersModel.logIn(loginData);
            appView.displayMessage("Login Successful!");
        } catch (LoginDetailsInvalidException loginDetailsInvalidException) {
            appView.displayMessage("Invalid Login details. Please try again.");
        }
    }

    public void logout() {
        try{
            customersModel.logout();
            appView.displayMessage("You have been logged out! ");
        }catch(UserNotLoggedInException userNotLoggedInException) {
            appView.displayMessage("You are not currently logged in.");
        }
    }

    public void displayDetails() {
        customersView.displayDetails(customersModel.details());
    }
}
