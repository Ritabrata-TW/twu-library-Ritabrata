package com.twu.biblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    public List<String> options;

    public Menus() {
        options = new ArrayList<>();
        options.add("1. List Books");
        options.add("2. Checkout Book");
        options.add("3. Return Book");
        options.add("4. List Movies");
        options.add("5. Checkout Movie");
        options.add("6. Return Movie");
        options.add("7. Login");
        options.add("8. Logout");
        options.add("9. View your details");
        options.add("0. Quit");
    }

    public List<String> getOptions() {
        return options;
    }

    public int validateChoice(int choice) {
        if (choice >= 0 && choice <= 9) {
            return choice;
        }
        return -1;

    }
}
