package com.twu.biblioteca.Model;

import java.util.List;

public class MenuModel {
    public List<String> options;

    public MenuModel() {
        options.add("1. List Books");
    }

    public List<String> getOptions(){
        return options;
    }
}
