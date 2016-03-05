package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Commands.*;
import com.twu.biblioteca.Model.Dependencies;

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
        CheckoutMovieCommand checkoutMovieCommand = (CheckoutMovieCommand) dependencies.get(CheckoutMovieCommand.class);
        ReturnMovieCommand returnMovieCommand = (ReturnMovieCommand) dependencies.get(ReturnMovieCommand.class);
        LoginCommand loginCommand = (LoginCommand) dependencies.get(LoginCommand.class);
        LogoutCommand logoutCommand = (LogoutCommand) dependencies.get(LogoutCommand.class);

        CommandFactory commandFactory = (CommandFactory) dependencies.get(CommandFactory.class);
        commandFactory.register(1, displayBooksCommand);
        commandFactory.register(-1, invalidInputCommand);
        commandFactory.register(0, exitCommand);
        commandFactory.register(2, checkoutBookCommand);
        commandFactory.register(3, returnBookCommand);
        commandFactory.register(4, displayMoviesCommand);
        commandFactory.register(5, checkoutMovieCommand);
        commandFactory.register(6, returnMovieCommand);
        commandFactory.register(7, loginCommand);
        commandFactory.register(8, logoutCommand);
        MenusController menuController = (MenusController) dependencies.get(MenusController.class);
        menuController.welcome();

        int nextAction = 1;

        while (nextAction != 0) {
            int choice = menuController.mainMenu();
            Command command = commandFactory.commandFor(choice);
            nextAction = command.execute();
        }
    }
}

