package com.twu.biblioteca;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Controller.MenuController;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.BooksModel;
import com.twu.biblioteca.View.BooksView;
import com.twu.biblioteca.View.InputOutputHandler;
import com.twu.biblioteca.View.MenuView;

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
        BooksController booksController = new BooksController(booksModel, booksView);
        MenuController menuController = new MenuController(menuView,booksController);
        booksView.welcome();
        menuController.mainMenu();
    }


}
