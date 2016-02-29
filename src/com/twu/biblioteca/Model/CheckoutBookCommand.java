package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;

public class CheckoutBookCommand implements Command {

    private BooksController booksController;

    public CheckoutBookCommand(BooksController booksController) {
        this.booksController = booksController;
    }

    @Override
    public int execute() {
        String bookName = booksController.getBookName("Enter the number of the book that you want to checkout");

        booksController.checkoutBook(bookName);

        return 1;
    }
}
