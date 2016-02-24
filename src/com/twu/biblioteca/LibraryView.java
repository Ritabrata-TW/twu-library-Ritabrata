package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryView {
    private LibraryModel libraryModel;
    InputOutputHandler inputOutputHandler;

    public LibraryView(LibraryModel libraryModel, InputOutputHandler inputOutputHandler ) {
        this.libraryModel = libraryModel;
        this.inputOutputHandler = inputOutputHandler;
    }

    public void welcome(){
        inputOutputHandler.writeMessage("**** Welcome Customer! We are glad to have you at LibraryModel! ****");
    }


    public void displayBooks() {
        for (Book book : getBooks()) {
            inputOutputHandler.writeMessage(book.toString());
        }
    }

    public void mainMenu() {
        inputOutputHandler.writeMessage("/n Main Menu");
        inputOutputHandler.writeMessage("1. List Books");

        Integer choice = inputOutputHandler.input("Enter your choice!");
        if(choice == 1) {
            displayBooks();
        }
    }

    public ArrayList<Book> getBooks() {
        return new LibraryController(libraryModel,this,inputOutputHandler).getBooks();
    }
}

