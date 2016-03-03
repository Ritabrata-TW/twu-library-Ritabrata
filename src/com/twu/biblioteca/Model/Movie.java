package com.twu.biblioteca.Model;

public class Movie {
    private int serialNumber;
    String name;
    int yaer;
    String director;
    float rating;

    public Movie(int serialNumber, String name, int yaer, String director, float rating) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.yaer = yaer;
        this.director = director;
        this.rating = rating;
    }

}
