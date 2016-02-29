package com.twu.biblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class MenuModel {
    public List<String> options;

    public MenuModel() {
        options =new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        options.add("4. Return Book");
    }

    public List<String> getOptions(){
        return options;
    }
}
