package com.twu.biblioteca.Model;

public class LoginData {
    String emailId;
    String password;

    public LoginData(String emailId,String password){
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginData loginData = (LoginData) o;

        if (emailId != null ? !emailId.equals(loginData.emailId) : loginData.emailId != null) return false;
        return password != null ? password.equals(loginData.password) : loginData.password == null;

    }

    @Override
    public int hashCode() {
        int result = emailId != null ? emailId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
