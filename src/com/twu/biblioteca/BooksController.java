package com.twu.biblioteca;

public class BooksController {
    BooksModel booksModel;
    BooksView booksView;
    MenuController menuController;

    BooksController(BooksModel booksModel, BooksView booksView, MenuController menuController) {
        this.booksModel = booksModel;
        this.booksView = booksView;
        this.menuController = menuController;
    }

    public void startApp()  {
        this.welcome();
        menuController.mainMenu();
    }

    private void welcome() {
        booksView.welcome();
    }


}
