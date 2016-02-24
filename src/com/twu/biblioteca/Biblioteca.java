package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    Writer inputOutputStream;
    String welcomeMessage;
    List<Book> books;

    Biblioteca(Writer inputOutputStream) {
        this.inputOutputStream = inputOutputStream;
        welcomeMessage = "**** Welcome Customer! We are glad to have you at Biblioteca! ****";
        books = new ArrayList<Book>();
        books.add(new Book("Head First Design Pattern!","Martin Fowler",2007));
    }

    public static void main(String[] args) {
    }

    public void welcome(){
        inputOutputStream.writeMessage(welcomeMessage);
    }


    public void displayBooks() {
        for(Book book : books) {
            book.display(inputOutputStream);
        }
    }
}
