package com.twu.biblioteca;

public class Book {
    String name;
    String author;
    int yearOfPublication;

    public Book(String name, String author, int yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public void display(Writer inputOutputStream) {
        String serialisedBook = name + " " + author + " " + yearOfPublication;
        inputOutputStream.writeMessage(serialisedBook);
    }
}
