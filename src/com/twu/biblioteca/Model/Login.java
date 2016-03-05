package com.twu.biblioteca.Model;

import com.twu.biblioteca.Model.Exceptions.LoginDetailsInvalidException;

import java.util.ArrayList;

public class Login {
    private boolean loginStatus;
    private ArrayList<LoginData> userRecords;


    public Login(){
        loginStatus = false;
        userRecords = new ArrayList<>();
        userRecords.add(new LoginData("rmoitra@thoughtworks.com","abcd"));
    }

    public void logIn(LoginData loginData) throws LoginDetailsInvalidException {
        if(userRecords.contains(loginData)) {
            loginStatus = true;
            return;
        }
        throw new LoginDetailsInvalidException();
    }

    public boolean getLoginStatus() {
        return loginStatus;
    }
}
