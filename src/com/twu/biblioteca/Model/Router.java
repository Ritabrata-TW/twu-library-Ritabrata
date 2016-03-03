package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.MenusController;

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
        DisplayMoviesCommand displayMoviesCommand = (DisplayMoviesCommand) dependencies.get(DisplayMoviesCommand.class);
        CheckoutMovieCommand checkoutMovieCommand = (CheckoutMovieCommand)dependencies.get(CheckoutMovieCommand.class);

        CommandFactory commandFactory = (CommandFactory) dependencies.get(CommandFactory.class);
        commandFactory.register(1, displayBooksCommand);
        commandFactory.register(-1, invalidInputCommand);
        commandFactory.register(0, exitCommand);
        commandFactory.register(2, checkoutBookCommand);
        commandFactory.register(3, returnBookCommand);
        commandFactory.register(4, displayMoviesCommand);
        commandFactory.register(5,checkoutMovieCommand);
        MenusController menuController = (MenusController) dependencies.get(MenusController.class);
        menuController.welcome();

        int nextAction = 1;

        while(nextAction != 0) {
            int choice = menuController.mainMenu();
            Command command = commandFactory.commandFor(choice);
            nextAction = command.execute();
        }
    }
}

