package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Controller.MoviesController;

public class CheckoutBookCommand implements Command {

    private BooksController booksController;

    public CheckoutBookCommand(BooksController booksController) {
        this.booksController = booksController;
    }



    @Override
    public int execute() {
        int bookNumber = booksController.getBookNumber("Enter the number of the book that you want to checkout");

        booksController.checkoutBook(bookNumber);

        return 1;
    }
}
