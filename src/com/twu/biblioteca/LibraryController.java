package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryController {
    LibraryModel libraryModel;
    LibraryView libraryView;

    LibraryController(LibraryModel libraryModel, LibraryView libraryView) {
        this.libraryModel = libraryModel;
        this.libraryView = libraryView;
    }

    public void startApp(){
        this.welcome();
        this.mainMenu();
    }

    private void welcome() {
        libraryView.welcome();
    }

    public void mainMenu() {
        int choice = libraryView.mainMenu();
        if(choice == 1)
            libraryView.displayBooks(libraryModel.getBooks());
    }
}
