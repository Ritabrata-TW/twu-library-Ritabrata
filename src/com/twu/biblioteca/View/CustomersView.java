package com.twu.biblioteca.View;

import com.twu.biblioteca.Model.LoginData;

public class CustomersView {

    private InputOutputHandler inputOutputHandler;
    private AppView appView;

    public CustomersView(InputOutputHandler inputOutputHandler, AppView appView) {

        this.inputOutputHandler = inputOutputHandler;
        this.appView = appView;
    }

    public LoginData inputDetails() {
        inputOutputHandler.writeMessage("Please enter your library number.");
        String username = inputOutputHandler.getString();
        inputOutputHandler.writeMessage("Please enter your password.");
        String password = inputOutputHandler.getString();

        return new LoginData(username, password);
    }

    public void displayDetails(String details) {
        inputOutputHandler.writeMessage(details);
    }

    public void displayMessage(String message) {
        appView.displayMessage(message);
    }
}
