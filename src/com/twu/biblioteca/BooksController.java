package com.twu.biblioteca;

public class BooksController {
    BooksModel booksModel;
    BooksView booksView;

    BooksController(BooksModel booksModel, BooksView booksView) {
        this.booksModel = booksModel;
        this.booksView = booksView;
    }

    public void startApp()  {
        this.welcome();
        this.mainMenu();
    }

    private void welcome() {
        booksView.welcome();
    }

    public void mainMenu()  {
        int choice = booksView.mainMenu();
        if(choice == 1) {
            booksView.displayBooks(booksModel.getBooks());
        }

        booksView.displayMessage("Select a valid option!");
    }
}
