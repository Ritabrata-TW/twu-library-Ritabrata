package com.twu.biblioteca;
//Dto for book
public class Book {
    String name;
    String author;
    int yearOfPublication;

    public Book(String name, String author, int yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return name + " " + author + " " + yearOfPublication;    }
}
