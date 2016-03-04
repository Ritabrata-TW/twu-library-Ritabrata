package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.MenusController;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Model.Commands.*;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.View.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dependencies {

    private final HashMap<Class<?>, Object> objects;

    public Dependencies() {
        objects = new HashMap<Class<?>, Object>();
    }

    public void register(Class clazz, Object dependency) {
        objects.put(clazz, dependency);
    }

    public static Dependencies init() {
        List<Item> books = Arrays.<Item>asList(new Book(100, "Head First Design Pattern", "Martin Fowler", 2007, false),
                new Book(101, "Head First Java", "Martin Fowler", 2009, false),
                new Book(102, "Imperial C", "Dennis Ritchie", 1948, false));
        Books booksModel = new Books(books);

        InputOutputHandler inputOutputHandler = new InputOutputHandler(System.out, System.in);
        ItemsView itemsView = new ItemsView(inputOutputHandler);
        AppView appView = new AppView(inputOutputHandler);
        MenuView menuView = new MenuView(inputOutputHandler);
        ItemController itemController = new ItemController(booksModel,itemsView,appView);
        Menus menuModel = new Menus();
        MenusController menuController = new MenusController(menuModel, menuView, appView);
        CommandFactory commandFactory = new CommandFactory();
        DisplayBooksCommand displayBooksCommand = new DisplayBooksCommand(itemController);
        InvalidInputCommand invalidInputCommand = new InvalidInputCommand(menuController);
        ExitCommand exitCommand = new ExitCommand();
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand(itemController);
        ReturnBookCommand returnBookCommand = new ReturnBookCommand(itemController);
        Movies movies = new Movies(Arrays.<Item>asList(new Movie(1, "The Schindler's List", 1994, "Steven Spielberg", 10, false), new Movie(2, "Swades", 2000, "Rakesh Roshan", 8, false)));
        ItemController moviesController = new ItemController(movies, itemsView, appView);
        DisplayMoviesCommand displayMoviesCommand = new DisplayMoviesCommand(moviesController);
        CheckoutMovieCommand checkoutMovieCommand = new CheckoutMovieCommand(moviesController);

        Dependencies dependencies = new Dependencies();
        dependencies.register(Books.class, booksModel);
        dependencies.register(InputOutputHandler.class, inputOutputHandler);
        dependencies.register(ItemsView.class, itemsView);
        dependencies.register(MenuView.class, menuView);
        dependencies.register(ItemController.class, itemController);
        dependencies.register(MenusController.class, menuController);
        dependencies.register(CommandFactory.class, commandFactory);
        dependencies.register(Menus.class, menuModel);
        dependencies.register(DisplayBooksCommand.class, displayBooksCommand);
        dependencies.register(InvalidInputCommand.class, invalidInputCommand);
        dependencies.register(ExitCommand.class, exitCommand);
        dependencies.register(CheckoutBookCommand.class, checkoutBookCommand);
        dependencies.register(AppView.class, appView);
        dependencies.register(ReturnBookCommand.class, returnBookCommand);
        dependencies.register(Movies.class, movies);
        dependencies.register(ItemController.class,moviesController);
        dependencies.register(DisplayMoviesCommand.class, displayMoviesCommand);
        dependencies.register(CheckoutMovieCommand.class, checkoutMovieCommand);
        return dependencies;
    }

    public Object get(Class<?> clazz) {
        return objects.get(clazz);
    }
}

