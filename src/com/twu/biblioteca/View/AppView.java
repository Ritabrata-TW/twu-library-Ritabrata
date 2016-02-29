package com.twu.biblioteca.View;

public class AppView {

    private InputOutputHandler inputOutputHandler;

    public AppView(InputOutputHandler inputOutputHandler) {

        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayMessage(String message) {
        inputOutputHandler.writeMessage(message);
    }

}
