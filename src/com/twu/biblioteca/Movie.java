package com.twu.biblioteca;

public class Movie implements Item {

    int serialNumber;
    String name;
    int year;
    String director;
    float rating;
    Boolean checkoutStatus;

    public Movie(int serialNumber, String name, int year, String director, float rating, Boolean checkoutStatus) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkoutStatus = checkoutStatus;
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

    }

    @Override
    public void checkout() {
        checkoutStatus = true;
    }
}
