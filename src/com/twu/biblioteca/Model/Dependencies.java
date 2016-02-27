package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Controller.MenuController;
import com.twu.biblioteca.View.BooksView;
import com.twu.biblioteca.View.InputOutputHandler;
import com.twu.biblioteca.View.MenuView;

import java.util.Arrays;
import java.util.HashMap;

public class Dependencies {

    private final HashMap<Class<?>, Object> objects;

    public Dependencies() {
        objects = new HashMap<Class<?>, Object>();
    }

    public Dependencies(HashMap<Class<?>, Object> dependencies) {
        objects = dependencies;
    }

    public void register(Class clazz, Object dependency) {
        objects.put(clazz, dependency);
    }

    public static Dependencies init() {
        BooksModel booksModel = new BooksModel(Arrays.asList(new Book("Head First Design Pattern!", "Martin Fowler", 2007)));
        InputOutputHandler inputOutputHandler = new InputOutputHandler(System.out, System.in);
        BooksView booksView = new BooksView(inputOutputHandler);
        MenuView menuView = new MenuView(inputOutputHandler);
        BooksController booksController = new BooksController(booksModel, booksView);
        MenuModel menuModel = new MenuModel();
        MenuController menuController = new MenuController(menuModel, menuView);
        CommandFactory commandFactory = new CommandFactory();
        DisplayBooksCommand displayBooksCommand = new DisplayBooksCommand(booksController);
        InvalidInputCommand invalidInputCommand = new InvalidInputCommand(menuController);

        Dependencies dependencies = new Dependencies();
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(InputOutputHandler.class, inputOutputHandler);
        dependencies.register(BooksView.class, booksView);
        dependencies.register(MenuView.class, menuView);
        dependencies.register(BooksController.class, booksController);
        dependencies.register(MenuController.class, menuController);
        dependencies.register(CommandFactory.class, commandFactory);
        dependencies.register(MenuModel.class, menuModel);
        dependencies.register(DisplayBooksCommand.class,displayBooksCommand);
        dependencies.register(InvalidInputCommand.class,invalidInputCommand);

        return dependencies;
    }

    public Object get(Class<?> clazz) {
        return objects.get(clazz);
    }
}

