package com.twu.biblioteca.Model.Exceptions;

public class BookAlreadyPresentException extends Throwable{
    public BookAlreadyPresentException(String message) {
        super(message);
    }
}
