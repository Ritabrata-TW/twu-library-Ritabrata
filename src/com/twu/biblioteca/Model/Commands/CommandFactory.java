package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Model.Dependencies;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    Map<Integer, Command> choiceCommandMap;

    public CommandFactory() {
        choiceCommandMap = new HashMap();
    }

    public void register(Integer choice, Command command) {
        choiceCommandMap.put(choice, command);
    }

    public Command commandFor(int choice) {
        return choiceCommandMap.get(choice);
    }

    public void registerFrom(Dependencies dependencies) {
        this.registerMany(dependencies, DisplayBooksCommand.class, InvalidInputCommand.class, CheckoutBookCommand.class, CheckoutMovieCommand.class,
                DisplayMoviesCommand.class, ExitCommand.class, ListCustomerDetailsCommand.class, LoginCommand.class, LogoutCommand.class, ReturnBookCommand.class,
                ReturnMovieCommand.class);

    }

    private void registerMany(Dependencies dependencies, Class<?>... commandClasses) {
        for (Class<?> commandClass : commandClasses) {
            Command commandObject = (Command) dependencies.get(commandClass);
            this.register(commandObject.code(), commandObject);
        }

    }
}
