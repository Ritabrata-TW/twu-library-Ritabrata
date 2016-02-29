package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.MenuController;

public class Router {

    Dependencies dependencies;

    public Router(Dependencies dependencies) {
        this.dependencies = dependencies;
    }


    public void startApp() {
        DisplayBooksCommand displayBooksCommand = (DisplayBooksCommand) dependencies.get(DisplayBooksCommand.class);
        InvalidInputCommand invalidInputCommand = (InvalidInputCommand) dependencies.get(InvalidInputCommand.class);
        ExitCommand exitCommand = (ExitCommand) dependencies.get(ExitCommand.class);
        CheckoutBookCommand checkoutBookCommand = (CheckoutBookCommand) dependencies.get(CheckoutBookCommand.class);
        ReturnBookCommand returnBookCommand = (ReturnBookCommand) dependencies.get(ReturnBookCommand.class);

        CommandFactory commandFactory = (CommandFactory) dependencies.get(CommandFactory.class);
        commandFactory.register(1, displayBooksCommand);
        commandFactory.register(0, invalidInputCommand);
        commandFactory.register(2, exitCommand);
        commandFactory.register(3, checkoutBookCommand);
        commandFactory.register(4, returnBookCommand);
        MenuController menuController = (MenuController) dependencies.get(MenuController.class);
        menuController.welcome();

        int nextAction = 1;

        while(nextAction != 0) {
            int choice = menuController.mainMenu();
            Command command = commandFactory.commandFor(choice);
            nextAction = command.execute();
        }
    }


}

