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


    public CustomersController(Customers customersModel, CustomersView customersView) {
        this.customersModel = customersModel;
        this.customersView = customersView;
    }


    public void logIn() {
        LoginData loginData = customersView.inputDetails();

        try {
            customersModel.logIn(loginData);
            customersView.displayMessage("Login Successful!");
        } catch (LoginDetailsInvalidException loginDetailsInvalidException) {
            customersView.displayMessage("Invalid Login details. Please try again.");
        }
    }

    public void logout() {
        try{
            customersModel.logout();
            customersView.displayMessage("You have been logged out! ");
        }catch(UserNotLoggedInException userNotLoggedInException) {
            customersView.displayMessage("You are not currently logged in.");
        }
    }

    public void displayDetails() {
        try {
            customersView.displayDetails(customersModel.details());
        }
        catch (UserNotLoggedInException userNotLoggedInException) {
            customersView.displayMessage("You are not currently logged in.");
        }
    }
}
