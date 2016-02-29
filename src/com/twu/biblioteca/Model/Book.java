package com.twu.biblioteca.Model;
//Dto for book
public class Book {
    String name;
    String author;
    int yearOfPublication;
    private boolean checkoutStatus;

    public Book(String name, String author, int yearOfPublication, boolean checkoutStatus) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.checkoutStatus = checkoutStatus;
    }

    @Override
    public String toString() {
        return name + " " + author + " " + yearOfPublication;    }

    public boolean CheckoutStatus() {
        return checkoutStatus;
    }
}
