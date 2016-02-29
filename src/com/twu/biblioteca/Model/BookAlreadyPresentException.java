package com.twu.biblioteca.Model;

public class BookAlreadyPresentException extends Throwable{
    BookAlreadyPresentException(String message) {
        super(message);
    }
}
