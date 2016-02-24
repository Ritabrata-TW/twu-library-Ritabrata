package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryController {
    LibraryModel libraryModel;
    LibraryView libraryView;
    InputOutputHandler inputOutputHandler;

    LibraryController(LibraryModel libraryModel, LibraryView libraryView, InputOutputHandler inputOutputHandler) {
        this.libraryModel = libraryModel;
        this.libraryView = libraryView;
        this.inputOutputHandler = inputOutputHandler;
    }

    public ArrayList<Book> getBooks() {
        return (ArrayList<Book>) libraryModel.getBooks();
    }
}
