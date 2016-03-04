package com.twu.biblioteca.View;

import com.twu.biblioteca.Book;

import java.util.List;

public class BooksView {
    InputOutputHandler inputOutputHandler;

    public BooksView(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayBooks(List<Book> books) {
        for (Book book : books) {
            if (!book.checkoutStatus())
                inputOutputHandler.writeMessage(book.toString());
        }
    }

    public Integer getBookNumber(String message) {
        try {
            return inputOutputHandler.input(message);
        } catch (Exception exception) {
            return -1;
        }
    }


}

