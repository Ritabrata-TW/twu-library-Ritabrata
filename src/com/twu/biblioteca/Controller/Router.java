package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Commands.Command;
import com.twu.biblioteca.Model.Commands.CommandFactory;
import com.twu.biblioteca.Model.Dependencies;
import com.twu.biblioteca.Model.Result;

public class Router {

    Dependencies dependencies;

    public Router(Dependencies dependencies) {
        this.dependencies = dependencies;
    }


    public void startApp() {
        CommandFactory commandFactory = (CommandFactory) dependencies.get(CommandFactory.class);

        commandFactory.registerFrom(dependencies);
        MenusController menuController = (MenusController) dependencies.get(MenusController.class);
        menuController.welcome();

        Result nextAction;

        do {
            int choice = menuController.mainMenu();
            Command command = commandFactory.commandFor(choice);
            nextAction = command.execute();
        } while (!nextAction.ShouldTerminateLoop());
    }
}

