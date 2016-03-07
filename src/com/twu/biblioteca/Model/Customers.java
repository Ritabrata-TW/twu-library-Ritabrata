package com.twu.biblioteca.Model;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Model.Exceptions.LoginDetailsInvalidException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;

import java.util.Map;

public class Customers {
    private boolean loginStatus;
    private Map<String, Customer> customerRecords;
    String loggedInUserId;


    public Customers(Map<String,Customer> customerRecords) {
        loginStatus = false;
        this.customerRecords = customerRecords;
    }

    public void logIn(LoginData loginData) throws LoginDetailsInvalidException {
        if (customerRecords.containsKey(loginData.libraryNumber) && customerRecords.get(loginData.libraryNumber).authenticate(loginData)) {
            loginStatus = true;
            loggedInUserId = loginData.libraryNumber;
            return;
        }
        throw new LoginDetailsInvalidException();
    }

    public String loggedInUserId() {
        return loggedInUserId;
    }

    public void logout() throws UserNotLoggedInException {
        if (!loginStatus)
            throw new UserNotLoggedInException();

        loginStatus = false;
        loggedInUserId = null;
    }

    public String details() throws UserNotLoggedInException {
        if (loginStatus)
            return customerRecords.get(loggedInUserId).toString();

        throw new UserNotLoggedInException();
    }


}
