package com.twu.biblioteca.Model;

import com.twu.biblioteca.Controller.BooksController;

public class ReturnBookCommand implements Command{

    private BooksController booksController;

    public ReturnBookCommand(BooksController booksController) {

        this.booksController = booksController;
    }

    @Override
    public int execute() {
        String bookName = booksController.getBookName("Enter the name of the book that you want to return");
        booksController.returnBook(bookName);
        return 1;
    }
}
