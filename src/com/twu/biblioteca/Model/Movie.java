package com.twu.biblioteca.Model;

public class Movie {

    int serialNumber;
    String name;
    int year;
    String director;
    float rating;

    public Movie(int serialNumber, String name, int year, String director, float rating) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return serialNumber + " " + name + " " + year + " " + director + " " + rating;
    }
}
