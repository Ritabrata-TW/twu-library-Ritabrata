package com.twu.biblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    public List<String> options;
    private Customers customersModel;


    public Menus(Customers customersModel) {
        this.customersModel = customersModel;
        options = new ArrayList<>();
        options.add("0. Quit");
        options.add("1. List Books");
        options.add("2. Checkout Book");
        options.add("3. Return Book");
        options.add("4. List Movies");
        options.add("5. Checkout Movie");
        options.add("6. Return Movie");
        options.add("7. Login");
        options.add("8. Logout");
        options.add("9. View your details");

    }

    public List<String> getOptions() {
        if (!customersModel.checkIfLoggedIn()) {
            return options.subList(0, 8);
        }
        return options;
    }

    public int validateChoice(int choice) {
        if (!customersModel.checkIfLoggedIn() && choice >= 0 && choice <= 7)
            return choice;

        if (customersModel.checkIfLoggedIn() && choice >= 0 && choice <= 9) {
            return choice;
        }
        return -1;

    }
}
