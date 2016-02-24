package com.twu.biblioteca;

// Run the biblioteca application
public class Application {
    public static void main(String[] args) {
        LibraryModel libraryModel = new LibraryModel();
        LibraryView libraryView = new LibraryView(libraryModel,new InputOutputHandler(System.out, System.in));
        libraryModel.addBooks();
        libraryView.welcome();
        libraryView.mainMenu();
    }
}
