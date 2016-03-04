package com.twu.biblioteca.Model;

import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;

import java.util.List;

public class Movies {
    List<Movie> movies;

    public Movies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Movie checkoutMovie(int movieNumber) throws NotFoundException, InvalidInputException {
        if (movieNumber == -1) {
            throw new InvalidInputException();
        }

        for (Movie movie : movies) {
            if (movie.getNumber() == movieNumber && !movie.checkoutStatus()) {
                movie.checkout();
                return movie;
            }

        }
        throw new NotFoundException("This book doesn't exist in the records");
    }
}
