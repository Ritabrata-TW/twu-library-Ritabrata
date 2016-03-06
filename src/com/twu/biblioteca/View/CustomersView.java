package com.twu.biblioteca.View;

import com.twu.biblioteca.Model.LoginData;

public class CustomersView {

    private InputOutputHandler inputOutputHandler;

    public CustomersView(InputOutputHandler inputOutputHandler) {

        this.inputOutputHandler = inputOutputHandler;
    }

    public LoginData inputDetails() {
        inputOutputHandler.writeMessage("Please enter your library number.");
        String username = inputOutputHandler.getString();
        inputOutputHandler.writeMessage("Please enter your password.");
        String password = inputOutputHandler.getString();

        return new LoginData(username,password);
    }
}
