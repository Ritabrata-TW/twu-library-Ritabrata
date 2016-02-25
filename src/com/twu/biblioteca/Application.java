package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

// Run the biblioteca application
public class Application {
    public static void main(String[] args)  {
        List<Book> books = new ArrayList<Book>(5);
        books.add(new Book("Head First Design Pattern!", "Martin Fowler", 2007));
        books.add(new Book("Head First Java", "Someone!", 2009));
        BooksModel booksModel = new BooksModel(books);
        InputOutputHandler inputOutputHandler = new InputOutputHandler(System.out, System.in);
        BooksView booksView = new BooksView(inputOutputHandler);
        MenuView menuView = new MenuView(inputOutputHandler,booksView);
        MenuController menuController = new MenuController(menuView,booksModel);
        BooksController booksController = new BooksController(booksModel, booksView,menuController);
        booksController.startApp();
    }
}