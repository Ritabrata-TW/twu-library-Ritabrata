package com.twu.biblioteca.Model.DTO;

public class Movie {

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

    public Boolean checkoutStatus() {
        return checkoutStatus;
    }

    public int getNumber() {
        return serialNumber;
    }

    public void checkout() {
        checkoutStatus = true;
    }
}
