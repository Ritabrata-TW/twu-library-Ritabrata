package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Controller.BooksController;

public class CheckoutBookCommand implements Command {

    private BooksController booksController;

    public CheckoutBookCommand(BooksController booksController) {
        this.booksController = booksController;
    }


    @Override
    public int execute() {
        booksController.checkoutBook();

        return 1;
    }
}
