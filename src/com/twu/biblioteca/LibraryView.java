package com.twu.biblioteca;

import java.util.List;

public class LibraryView {
    InputOutputHandler inputOutputHandler;

    public LibraryView(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void welcome(){
        inputOutputHandler.writeMessage("**** Welcome Customer! We are glad to have you at LibraryModel! ****");
    }

    public void displayBooks(List<Book> books) {
        for (Book book:books) {
            inputOutputHandler.writeMessage(book.toString());
        }
    }

    public int mainMenu() {
        inputOutputHandler.writeMessage("/n Main Menu");
        inputOutputHandler.writeMessage("1. List Books");

        Integer choice = inputOutputHandler.input("Enter your choice!");
        return choice;
    }


}

