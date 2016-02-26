package com.twu.biblioteca.Model;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    Map<Integer,Command> choiceCommandMap;

    public CommandFactory()
    {
        choiceCommandMap = new HashMap<Integer, Command>();
        choiceCommandMap.put(0,new InvalidInputCommand());
        choiceCommandMap.put(1,new DisplayBooksCommand());
    }

    public Command commandFor(int choice){
        return choiceCommandMap.get(choice);
    }
}
