package com.twu.biblioteca.Model.Commands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    Map<Integer, Command> choiceCommandMap;

    public CommandFactory() {
        choiceCommandMap = new HashMap<Integer, Command>();
    }

    public void register(Integer choice, Command command) {
        choiceCommandMap.put(choice, command);
    }

    public Command commandFor(int choice) {
        return choiceCommandMap.get(choice);
    }
}
