package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Controller.MenuController;
import com.twu.biblioteca.View.AppView;
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

    public void register(Class clazz, Object dependency) {
        objects.put(clazz, dependency);
    }

    public static Dependencies init() {
        Books booksModel = new Books(Arrays.asList(new Book(100, "Head First Design Pattern", "Martin Fowler", 2007, false),
                                                            new Book(101, "Head First Java","Martin Fowler",2009,false),
                                                            new Book(102, "Imperial C","Dennis Ritchie",1948,false)));

        InputOutputHandler inputOutputHandler = new InputOutputHandler(System.out, System.in);
        BooksView booksView = new BooksView(inputOutputHandler);
        AppView appView = new AppView(inputOutputHandler);
        MenuView menuView = new MenuView(inputOutputHandler);
        BooksController booksController = new BooksController(booksModel, booksView, appView);
        Menus menuModel = new Menus();
        MenuController menuController = new MenuController(menuModel, menuView, appView);
        CommandFactory commandFactory = new CommandFactory();
        DisplayBooksCommand displayBooksCommand = new DisplayBooksCommand(booksController);
        InvalidInputCommand invalidInputCommand = new InvalidInputCommand(menuController);
        ExitCommand exitCommand = new ExitCommand();
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand(booksController);
        ReturnBookCommand returnBookCommand = new ReturnBookCommand(booksController);

        Dependencies dependencies = new Dependencies();
        dependencies.register(Books.class, booksModel);
        dependencies.register(InputOutputHandler.class, inputOutputHandler);
        dependencies.register(BooksView.class, booksView);
        dependencies.register(MenuView.class, menuView);
        dependencies.register(BooksController.class, booksController);
        dependencies.register(MenuController.class, menuController);
        dependencies.register(CommandFactory.class, commandFactory);
        dependencies.register(Menus.class, menuModel);
        dependencies.register(DisplayBooksCommand.class,displayBooksCommand);
        dependencies.register(InvalidInputCommand.class,invalidInputCommand);
        dependencies.register(ExitCommand.class,exitCommand);
        dependencies.register(CheckoutBookCommand.class,checkoutBookCommand);
        dependencies.register(AppView.class,appView);
        dependencies.register(ReturnBookCommand.class,returnBookCommand);

        return dependencies;
    }

    public Object get(Class<?> clazz) {
        return objects.get(clazz);
    }
}

