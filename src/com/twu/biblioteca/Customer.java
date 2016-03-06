package com.twu.biblioteca;

public class Customer {
    String libraryNumber;
    String password;
    String name;
    String emailId;
    String number;

    public Customer(String libraryNumber, String password, String name, String emailId, String number) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.emailId = emailId;
        this.number = number;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return name + " " + emailId + " " + number;
    }
}
