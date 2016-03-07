package com.twu.biblioteca.View;

import com.twu.biblioteca.Item;

import java.util.List;

public class ItemsView {
    InputOutputHandler inputOutputHandler;
    private AppView appView;

    public ItemsView(InputOutputHandler inputOutputHandler, AppView appView) {
        this.inputOutputHandler = inputOutputHandler;
        this.appView = appView;
    }

    public void displayItems(List<Item> items) {
        items.stream().filter(item -> !item.checkoutStatus()).forEach(item -> inputOutputHandler.writeMessage(item.toString()));
    }

    public Integer getItemNumber(String message) {
        try {
            return inputOutputHandler.input(message);
        } catch (Exception exception) {
            return -1;
        }
    }

    public void displayMessage(String message) {
        appView.displayMessage(message);
    }
}
