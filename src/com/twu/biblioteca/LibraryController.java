package com.twu.biblioteca;

public class LibraryController {
    LibraryModel libraryModel;
    BooksView libraryView;

    LibraryController(LibraryModel libraryModel, BooksView libraryView) {
        this.libraryModel = libraryModel;
        this.libraryView = libraryView;
    }

    public void startApp()  {
        this.welcome();
        this.mainMenu();
    }

    private void welcome() {
        libraryView.welcome();
    }

    public void mainMenu()  {
        int choice = libraryView.mainMenu();
        if(choice == 1) {
            libraryView.displayBooks(libraryModel.getBooks());
        }

        libraryView.displayMessage("Select a valid option!");
    }
}
