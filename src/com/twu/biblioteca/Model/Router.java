package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Controller.MenuController;
import com.twu.biblioteca.View.BooksView;
import com.twu.biblioteca.View.InputOutputHandler;
import com.twu.biblioteca.View.MenuView;

import java.util.ArrayList;
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
    Dependencies dependencies;


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
        DisplayBooksCommand displayBooksCommand = (DisplayBooksCommand) dependencies.get(DisplayBooksCommand.class);
        InvalidInputCommand invalidInputCommand = (InvalidInputCommand) dependencies.get(InvalidInputCommand.class);

        CommandFactory commandFactory = (CommandFactory) dependencies.get(CommandFactory.class);
        commandFactory.register(1, displayBooksCommand);
        commandFactory.register(0, invalidInputCommand);
        BooksController booksController = (BooksController) dependencies.get(BooksController.class);
        booksController.welcome();

        MenuController menuController = (MenuController) dependencies.get(MenuController.class);
        int choice = menuController.mainMenu();

        Command command = commandFactory.commandFor(choice);
        command.execute();
    }


}

