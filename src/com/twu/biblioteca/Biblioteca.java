package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Welcome User, Display Main menu
public class Biblioteca {
    InputOutputHandler inputOutputHandler;
    String welcomeMessage;
    List<Book> books;

    Biblioteca(InputOutputHandler inputOutputStream) {
        this.inputOutputHandler = inputOutputStream;
        welcomeMessage = "**** Welcome Customer! We are glad to have you at Biblioteca! ****";
        books = new ArrayList<Book>();
    }

    public void addBooks() {
        books.add(new Book("Head First Design Pattern!","Martin Fowler",2007));
    }


    public void welcome(){
        inputOutputHandler.writeMessage(welcomeMessage);
    }


    public void displayBooks() {
        for(Book book : books) {
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
}
