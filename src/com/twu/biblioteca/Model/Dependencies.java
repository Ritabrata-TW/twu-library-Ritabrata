package com.twu.biblioteca.Model;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Controller.CustomersController;
import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.MenusController;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Model.Commands.*;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.View.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dependencies {

    private final HashMap<Class<?>, Object> objects;

    public Dependencies() {
        objects = new HashMap<>();
    }

    public void register(Class clazz, Object dependency) {
        objects.put(clazz, dependency);
    }

    public static Dependencies init() {
        Customers customersModel = new Customers();
        List<Item> books = Arrays.<Item>asList(new Book(100, "Head First Design Pattern", "Martin Fowler", 2007),
                new Book(101, "Head First Java", "Martin Fowler", 2009),
                new Book(102, "Imperial C", "Dennis Ritchie", 1948));
        Books booksModel = new Books(books, customersModel);

        InputOutputHandler inputOutputHandler = new InputOutputHandler(System.out, System.in);
        AppView appView = new AppView(inputOutputHandler);
        MenuView menuView = new MenuView(inputOutputHandler);
        ItemsView itemsView = new ItemsView(inputOutputHandler, appView);
        ItemController itemController = new ItemController(booksModel, itemsView);
        Menus menuModel = new Menus(customersModel);
        MenusController menuController = new MenusController(menuModel, menuView, appView);
        CommandFactory commandFactory = new CommandFactory();
        DisplayBooksCommand displayBooksCommand = new DisplayBooksCommand(itemController);
        InvalidInputCommand invalidInputCommand = new InvalidInputCommand(menuController);
        ExitCommand exitCommand = new ExitCommand();
        Movies movies = new Movies(Arrays.<Item>asList(new Movie(1, "The Schindler's List", 1994, "Steven Spielberg", 10),
                new Movie(2, "Swades", 2000, "Rakesh Roshan", 8)), customersModel);
        ItemController moviesController = new ItemController(movies, itemsView);
        DisplayMoviesCommand displayMoviesCommand = new DisplayMoviesCommand(moviesController);
        CustomersView customersView = new CustomersView(inputOutputHandler, appView);
        CustomersController customersController = new CustomersController(customersModel, customersView);
        LoginCommand loginCommand = new LoginCommand(customersController);
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand(itemController);
        CheckoutMovieCommand checkoutMovieCommand = new CheckoutMovieCommand(moviesController);
        ReturnBookCommand returnBookCommand = new ReturnBookCommand(itemController);
        ReturnMovieCommand returnMovieCommand = new ReturnMovieCommand(moviesController);
        LogoutCommand logoutCommand = new LogoutCommand(customersController);
        ListCustomerDetailsCommand listCustomerDetailsCommand = new ListCustomerDetailsCommand(customersController);

        Dependencies dependencies = new Dependencies();
        dependencies.register(MenusController.class, menuController);
        dependencies.register(CommandFactory.class, commandFactory);
        dependencies.register(DisplayBooksCommand.class, displayBooksCommand);
        dependencies.register(InvalidInputCommand.class, invalidInputCommand);
        dependencies.register(ExitCommand.class, exitCommand);
        dependencies.register(CheckoutBookCommand.class, checkoutBookCommand);
        dependencies.register(ReturnBookCommand.class, returnBookCommand);
        dependencies.register(DisplayMoviesCommand.class, displayMoviesCommand);
        dependencies.register(CheckoutMovieCommand.class, checkoutMovieCommand);
        dependencies.register(ReturnMovieCommand.class, returnMovieCommand);
        dependencies.register(LoginCommand.class, loginCommand);
        dependencies.register(LogoutCommand.class, logoutCommand);
        dependencies.register(ListCustomerDetailsCommand.class, listCustomerDetailsCommand);
        return dependencies;
    }

    public Object get(Class<?> clazz) {
        return objects.get(clazz);
    }
}

