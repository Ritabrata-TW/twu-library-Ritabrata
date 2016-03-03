package com.twu.biblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class Movies {
    List<Movie> movies;

    public Movies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
