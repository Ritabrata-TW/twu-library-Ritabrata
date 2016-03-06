package com.twu.biblioteca;

public class Movie implements Item {

    int serialNumber;
    String name;
    int year;
    String director;
    float rating;
    Boolean checkoutStatus;
    private String checkedOutBy;

    public Movie(int serialNumber, String name, int year, String director, float rating) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkoutStatus = false;
        this.checkedOutBy = null;
    }

    @Override
    public String toString() {
        return serialNumber + " " + name + " " + year + " " + director + " " + rating;
    }

    @Override
    public boolean checkoutStatus() {
        return checkoutStatus;
    }

    @Override
    public Integer getNumber() {
        return serialNumber;
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
    public void checkout(String libraryNumber) {
        checkoutStatus = true;
        checkedOutBy = libraryNumber;
    }
}
