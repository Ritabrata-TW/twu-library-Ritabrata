package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Controller.MenuController;
import com.twu.biblioteca.View.BooksView;
import com.twu.biblioteca.View.InputOutputHandler;
import com.twu.biblioteca.View.MenuView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Router {
    List<Book> books;
    BooksModel booksModel;
    InputOutputHandler inputOutputHandler;
    BooksView booksView;
    MenuView menuView;
    BooksController booksController;
    MenuModel menuModel;
    MenuController menuController;
    CommandFactory commandFactory;
    private Dependencies dependencies;


    public Router() {
        books = new ArrayList<Book>(5);
        books.add(new Book("Head First Design Pattern!", "Martin Fowler", 2007));
        books.add(new Book("Head First Java", "Someone!", 2009));
        booksModel = new BooksModel(books);
        inputOutputHandler = new InputOutputHandler(System.out, System.in);
        booksView = new BooksView(inputOutputHandler);
        menuView = new MenuView(inputOutputHandler);
        booksController = new BooksController(booksModel, booksView);
        menuModel = new MenuModel();
        menuController = new MenuController(menuModel, menuView);
        commandFactory = new CommandFactory();
    }

    public Router(Dependencies dependencies) {

        this.dependencies = dependencies;
    }


    public void startApp() {
        DisplayBooksCommand displayBooksCommand = new DisplayBooksCommand(booksController);
        InvalidInputCommand invalidInputCommand = new InvalidInputCommand(menuController);
        commandFactory.register(1, displayBooksCommand);
        commandFactory.register(0, invalidInputCommand);
        booksController.welcome();
        int choice = menuController.mainMenu();

        Command command = commandFactory.commandFor(choice);
        command.execute();
    }

    public void startAppNew() {
        DisplayBooksCommand displayCommand = (DisplayBooksCommand) dependencies.get(DisplayBooksCommand.class);
        commandFactory.register(1, displayCommand);
        booksController.welcome();
        int choice = menuController.mainMenu();

        Command command = commandFactory.commandFor(choice);
        command.execute();
    }
}

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
        new BooksController(booksModel, booksView);
        MenuModel menuModel = new MenuModel();
        new MenuController(menuModel, menuView);
        new CommandFactory();
        Dependencies dependencies = new Dependencies();
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
        dependencies.register(BooksModel.class, booksModel);
    }

    public Object get(Class<?> clazz) {
        return null;
    }
}
