package com.twu.biblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    public List<String> options;

    public Menus() {
        options =new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Checkout Book");
        options.add("3. Return Book");
        options.add("4. List Movies");
        options.add("0. Quit");
    }

    public List<String> getOptions(){
        return options;
    }

    public int validateChoice(int choice) {
        if(choice >=0 && choice<=4) {
            return choice;
        }
        return -1;

    }
}
