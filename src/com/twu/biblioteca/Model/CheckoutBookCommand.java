package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Controller.MenuController;

public class CheckoutBookCommand implements Command{

    private MenuController menuController;
    private BooksController booksController;

    public CheckoutBookCommand(MenuController menuController, BooksController booksController){
        this.menuController = menuController;
        this.booksController = booksController;
    }

    @Override
    public int execute() {
        menuController.displayMessage("Enter the number of the book that you want to checkout");
        String bookName = menuController.getBookName();

        booksController.checkoutBook(bookName);

        return 1;
    }
}
