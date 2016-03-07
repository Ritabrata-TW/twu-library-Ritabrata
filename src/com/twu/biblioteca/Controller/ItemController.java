package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;
import com.twu.biblioteca.Model.Items;
import com.twu.biblioteca.View.ItemsView;

public class ItemController {
    Items itemsModel;
    ItemsView itemsView;

    public ItemController(Items itemsModel, ItemsView itemsView) {
        this.itemsModel = itemsModel;
        this.itemsView = itemsView;
    }

    public void displayItems() {
        itemsView.displayItems(itemsModel.getItems());
    }

    public void checkoutItem(String itemtype) {
        int itemNumber = getItemNumber("Enter the number of the " + itemtype + " that you want to checkout");

        try {
            itemsModel.checkoutItem(itemNumber);
            itemsView.displayMessage("Thank you! Enjoy the " + itemtype + "! ");
        } catch (NotFoundException bookNotfoundException) {
            itemsView.displayMessage("That " + itemtype + " is not available.");
        } catch (InvalidInputException invalidInputException) {
            itemsView.displayMessage("Please select a valid option! ");
        } catch (UserNotLoggedInException userNotLoggedInException) {
            itemsView.displayMessage("You need to be logged in to checkout a " + itemtype);
        }
    }

    public Integer getItemNumber(String message) {
        return itemsView.getItemNumber(message);
    }

    public void returnItem(String itemtype) {
        Integer itemNumber = getItemNumber("Enter the number of the " + itemtype + " that you want to return");

        try {
            itemsModel.returnItem(itemNumber);
            itemsView.displayMessage("Thank you for returning the " + itemtype);
        } catch (BookAlreadyPresentException bookAlreadyPresentException) {
            itemsView.displayMessage("That is not a valid " + itemtype + " to return.");
        } catch (InvalidInputException invalidInputException) {
            itemsView.displayMessage("Please select a valid option! ");
        } catch (UserNotLoggedInException userNotLoggedInException) {
            itemsView.displayMessage("You need to be logged in to return a " + itemtype);
        }
    }

}
