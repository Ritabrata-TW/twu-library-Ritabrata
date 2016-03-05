package com.twu.biblioteca.Model;

public class LoginData {
    String libraryNumber;
    String password;

    public LoginData(String libraryNumber, String password){
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginData loginData = (LoginData) o;

        if (libraryNumber != null ? !libraryNumber.equals(loginData.libraryNumber) : loginData.libraryNumber != null) return false;
        return password != null ? password.equals(loginData.password) : loginData.password == null;

    }

    @Override
    public int hashCode() {
        int result = libraryNumber != null ? libraryNumber.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
