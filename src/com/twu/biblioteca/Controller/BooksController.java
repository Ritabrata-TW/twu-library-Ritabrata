package com.twu.biblioteca.Controller;

import com.twu.biblioteca.View.MenuView;
import com.twu.biblioteca.View.BooksView;
import com.twu.biblioteca.Model.BooksModel;

public class BooksController {
    BooksModel booksModel;
    BooksView booksView;
    MenuController menuController;

    public BooksController(BooksModel booksModel, BooksView booksView, MenuController menuController) {
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

    public void displayBooks(){
        booksView.displayBooks(booksModel.getBooks());
    }

}
