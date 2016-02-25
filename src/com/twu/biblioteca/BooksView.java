package com.twu.biblioteca;

import java.util.List;

public class BooksView {
    InputOutputHandler inputOutputHandler;

    public BooksView(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void welcome(){
        inputOutputHandler.writeMessage("**** Welcome Customer! We are glad to have you at BooksModel! ****");
    }

    public void displayMessage(String message) {
        inputOutputHandler.writeMessage(message);
    }

    public void displayBooks(List<Book> books) {
        for (Book book:books) {
            inputOutputHandler.writeMessage(book.toString());
        }
    }


}

