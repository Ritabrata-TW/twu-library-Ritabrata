package com.twu.biblioteca.Model;

import com.twu.biblioteca.Model.Exceptions.LoginDetailsInvalidException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;

import java.util.ArrayList;

public class Login {
    private boolean loginStatus;
    private ArrayList<LoginData> userRecords;
    String loggedInUserId;


    public Login() {
        loginStatus = false;
        userRecords = new ArrayList<>();
        userRecords.add(new LoginData("123-4567", "abcd"));
    }

    public void logIn(LoginData loginData) throws LoginDetailsInvalidException {
        if (userRecords.contains(loginData)) {
            loginStatus = true;
            loggedInUserId = loginData.libraryNumber;
            return;
        }
        throw new LoginDetailsInvalidException();
    }

    public boolean checkIfLoggedIn() {
        return loginStatus;
    }

    public String loggedInUserId() {
        return loggedInUserId;
    }

    public void logout() throws UserNotLoggedInException {
        if(!loginStatus)
            throw new UserNotLoggedInException();

        loginStatus = false;
        loggedInUserId = null;
    }
}
