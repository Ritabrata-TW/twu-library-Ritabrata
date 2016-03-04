package com.twu.biblioteca;

//Dto for book
public class Book implements Item{
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
        return serialNumber + " " + name + " " + author + " " + yearOfPublication;
    }

    @Override
    public boolean checkoutStatus() {
        return checkoutStatus;
    }

    @Override
    public void checkout() {
        checkoutStatus = true;
    }

    public void returnBook() {
        checkoutStatus = false;
    }

    @Override
    public Integer getNumber() {
        return serialNumber;
    }
}
