package com.twu.biblioteca.View;


import java.util.List;

public class MenuView {
    String message = "**** Welcome Customer! We are glad to have you at Books! ****";

    InputOutputHandler inputOutputHandler;

    public MenuView(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void welcome() {
        inputOutputHandler.writeMessage(message);
    }


    public int displayMenuOptions(List<String> options) {
        for (String option : options){
            inputOutputHandler.writeMessage(option);
        }

        return getInputFromUser();
    }

    public int getInputFromUser() {
        try {
            return inputOutputHandler.input("Enter your choice");
        } catch (Exception e) {
            return -1;
        }
    }
}
