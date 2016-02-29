package com.twu.biblioteca.Model;

import java.awt.font.ShapeGraphicAttribute;

//Dto for book
public class Book {
    Integer serialNumber;
    String name;
    String author;
    int yearOfPublication;
    private boolean checkoutStatus;

    public Book(Integer serialNumber, String name, String author, int yearOfPublication, boolean checkoutStatus) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.checkoutStatus = checkoutStatus;
    }

    @Override
    public String toString() {
        return serialNumber + " " + name + " " + author + " " + yearOfPublication;    }

    public boolean checkoutStatus() {
        return checkoutStatus;
    }

    public void checkout(){
        checkoutStatus = true;
    }

    public void returnBook() {
        checkoutStatus = false;
    }

    public Integer getNumber() {
        return serialNumber;
    }
}
