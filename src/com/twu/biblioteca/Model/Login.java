package com.twu.biblioteca.Model;

import java.util.ArrayList;

public class Login {
    private boolean loginStatus;
    private ArrayList<LoginData> userRecords;


    public Login(){
        loginStatus = false;
        userRecords = new ArrayList<>();
        userRecords.add(new LoginData("rmoitra@thoughtworks.com","abcd"));
    }

    public void logIn(LoginData loginData) {
        if(userRecords.contains(loginData)) {
            loginStatus = true;
        }
    }

    public boolean getLoginStatus() {
        return loginStatus;
    }
}
