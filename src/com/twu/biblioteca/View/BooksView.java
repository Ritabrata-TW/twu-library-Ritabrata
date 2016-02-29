package com.twu.biblioteca.View;

import com.twu.biblioteca.Model.Book;

import java.util.List;

public class BooksView {
    InputOutputHandler inputOutputHandler;

    public BooksView(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }



    public void displayBooks(List<Book> books) {
        for (Book book:books) {
            if(!book.checkoutStatus())
            inputOutputHandler.writeMessage(book.toString());
        }
    }

    public String getBookname() {
        return inputOutputHandler.getString();
    }


}

