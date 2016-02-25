package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MenuView {
    InputOutputHandler inputOutputHandler;
    BooksView booksView;

    public MenuView(InputOutputHandler inputOutputHandler, BooksView booksView){
        this.inputOutputHandler = inputOutputHandler;
        this.booksView = booksView;
    }

    public int mainMenu() {
        inputOutputHandler.writeMessage("/n Main Menu");
        inputOutputHandler.writeMessage("1. List Books");
        try {
            return inputOutputHandler.input("Enter your choice!");
        }
        catch (Exception e) {
            return 0;
        }
    }

    public void displayMessage(String message) {
        inputOutputHandler.writeMessage(message);
    }

    public void displayBooks(List<Book> books) {
        booksView.displayBooks(books);
    }
}
