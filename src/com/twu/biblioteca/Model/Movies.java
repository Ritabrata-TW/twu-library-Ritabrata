package com.twu.biblioteca.Model;

import java.util.ArrayList;

public class Movies {
    private ArrayList<Movie> movies;

    public Movies(ArrayList<Movie> movies) {

        this.movies = movies;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
