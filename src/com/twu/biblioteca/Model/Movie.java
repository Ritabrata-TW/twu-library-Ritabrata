package com.twu.biblioteca.Model;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (serialNumber != movie.serialNumber) return false;
        if (year != movie.year) return false;
        if (Float.compare(movie.rating, rating) != 0) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        if (director != null ? !director.equals(movie.director) : movie.director != null) return false;
        return checkoutStatus != null ? checkoutStatus.equals(movie.checkoutStatus) : movie.checkoutStatus == null;

    }

    @Override
    public int hashCode() {
        int result = serialNumber;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        result = 31 * result + (checkoutStatus != null ? checkoutStatus.hashCode() : 0);
        return result;
    }

    public void checkout() {
        checkoutStatus = true;
    }
}
