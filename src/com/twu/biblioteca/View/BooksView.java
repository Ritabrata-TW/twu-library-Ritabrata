package com.twu.biblioteca.View;

import com.twu.biblioteca.Model.Book;

import java.util.List;

public class BooksView {
    InputOutputHandler inputOutputHandler;
    String message;

    public BooksView(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
        message = "**** Welcome Customer! We are glad to have you at BooksModel! ****";
    }

    public void welcome(){
        inputOutputHandler.writeMessage(message);
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

