package com.twu.biblioteca.ModelsTest;

import java.util.HashMap;
import java.util.Map;

public class Login {
    private boolean loginStatus;
    private Map<String,String> userRecords;


    Login(){
        loginStatus = false;
        userRecords = new HashMap<>();
        userRecords.put("rmoitra@thoughtworks.com","abcd");
    }

    public void logIn(String emailId, String password) {
        if(userRecords.containsKey(emailId) && userRecords.get(emailId).equals(password)) {
            loginStatus = true;
        }
    }

    public boolean getLoginStatus() {
        return loginStatus;
    }
}
