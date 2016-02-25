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
        BooksView booksView = new BooksView(new InputOutputHandler(System.out, System.in));

        BooksController booksController = new BooksController(booksModel, booksView);
        booksController.startApp();
    }
}
