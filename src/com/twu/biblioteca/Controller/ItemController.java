package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;
import com.twu.biblioteca.Model.Items;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.ItemsView;

public class ItemController {
    Items itemsModel;
    ItemsView itemsView;
    private AppView appView;

    public ItemController(Items itemsModel, ItemsView itemsView, AppView appView) {
        this.itemsModel = itemsModel;
        this.itemsView = itemsView;
        this.appView = appView;
    }

    public void displayItems() {
        itemsView.displayItems(itemsModel.getItems());
    }

    public void checkoutItem(LoginController loginController) {
        int bookNumber = getItemNumber("Enter the number of the item that you want to checkout");

        try {
            itemsModel.checkoutItem(bookNumber, loginController);
            appView.displayMessage("Thank you! Enjoy! ");
        } catch (NotFoundException bookNotfoundException) {
            appView.displayMessage("That item is not available.");
        } catch (InvalidInputException invalidInputException) {
            appView.displayMessage("Please select a valid option! ");
        } catch (UserNotLoggedInException userNotLoggedInException) {
            appView.displayMessage("You need to be logged in to checkout an item! ");
        }
    }

    public Integer getItemNumber(String message) {
        return itemsView.getItemNumber(message);
    }

    public void returnItem() {
        Integer bookNumber = getItemNumber("Enter the name of the item that you want to return");

        try {
            itemsModel.returnItem(bookNumber);
            appView.displayMessage("Thank you for returning.");
        } catch (BookAlreadyPresentException bookAlreadyPresentException) {
            appView.displayMessage("That is not a valid item to return.");
        } catch (InvalidInputException invalidInputException) {
            appView.displayMessage("Please select a valid option! ");
        }
    }

}
