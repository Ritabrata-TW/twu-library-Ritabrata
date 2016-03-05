package com.twu.biblioteca;

//Dto for book
public class Book implements Item {
    Integer serialNumber;
    String name;
    String author;
    int yearOfPublication;
    private boolean checkoutStatus;
    private String checkedOutBy;

    public Book(Integer serialNumber, String name, String author, int yearOfPublication, boolean checkoutStatus, String checkedOutBy) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.checkoutStatus = checkoutStatus;
        this.checkedOutBy = checkedOutBy;
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
    public void checkout(String libraryNumber) {
        checkoutStatus = true;
        checkedOutBy = libraryNumber;
    }

    @Override
    public void returnItem() {
        checkoutStatus = false;
    }

    @Override
    public String getCheckedOutBy() {
        return checkedOutBy;
    }

    @Override
    public Integer getNumber() {
        return serialNumber;
    }


}
