package com.twu.biblioteca.Model;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Model.Exceptions.LoginDetailsInvalidException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;

import java.util.HashMap;
import java.util.Map;

public class Customers {
    private boolean loginStatus;
    private Map<String, Customer> customerRecords;
    String loggedInUserId;


    public Customers() {
        loginStatus = false;
        customerRecords = new HashMap<>();
        customerRecords.put("123-4567", new Customer("123-4567", "abcd", "Ritabrata Moitra", "rmoitra@thoughtworks.com", "8013976041"));
        customerRecords.put("111-2222", new Customer("111-2222", "1234", "Narasimha Prasad", "nprasadd@thoughtworks.com", "1234567890"));
    }

    public void logIn(LoginData loginData) throws LoginDetailsInvalidException {
        if (customerRecords.containsKey(loginData.libraryNumber) && customerRecords.get(loginData.libraryNumber).authenticate(loginData)) {
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
        if (!loginStatus)
            throw new UserNotLoggedInException();

        loginStatus = false;
        loggedInUserId = null;
    }

    public String details() throws UserNotLoggedInException {
        if(loginStatus)
        return customerRecords.get(loggedInUserId).toString();

        throw new UserNotLoggedInException();
    }


}
