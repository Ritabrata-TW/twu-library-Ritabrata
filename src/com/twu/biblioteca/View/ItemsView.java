package com.twu.biblioteca.View;

import com.twu.biblioteca.Item;

import java.util.List;

public class ItemsView {
    InputOutputHandler inputOutputHandler;

    public ItemsView(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayItems(List<Item> items) {
        for (Item item : items) {
            if (!item.checkoutStatus())
                inputOutputHandler.writeMessage(item.toString());
        }
    }

    public Integer getItemNumber(String message) {
        try {
            return inputOutputHandler.input(message);
        } catch (Exception exception) {
            return -1;
        }
    }
}
