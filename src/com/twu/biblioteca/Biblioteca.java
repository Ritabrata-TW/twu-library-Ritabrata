package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    Writer writer;
    String welcomeMessage;
    List<Book> books;

    Biblioteca(Writer inputOutputStream) {
        this.writer = inputOutputStream;
        welcomeMessage = "**** Welcome Customer! We are glad to have you at Biblioteca! ****";
        books = new ArrayList<Book>();
    }

    public void addBooks() {
        books.add(new Book("Head First Design Pattern!","Martin Fowler",2007));
    }


    public void welcome(){
        writer.writeMessage(welcomeMessage);
    }


    public void displayBooks() {
        for(Book book : books) {
            writer.writeMessage(book.toString());
        }
    }

    public void mainMenu() {
        writer.writeMessage("/n Main Menu");
        writer.writeMessage("1. List Books");
    }
}
