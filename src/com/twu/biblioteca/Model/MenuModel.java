package com.twu.biblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class MenuModel {
    public List<String> options;

    public MenuModel() {
        options =new ArrayList<String>();
        options.add("1. List Books");
    }

    public List<String> getOptions(){
        return options;
    }
}
