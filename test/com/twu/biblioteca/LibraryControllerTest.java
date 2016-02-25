package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class LibraryControllerTest {
    InputOutputHandler inputOutputHandler;
    ArrayList<Book> books;
    LibraryModel libraryModel;
    LibraryView libraryView;
    LibraryController libraryController;


    @Before
    public void setup() {
        inputOutputHandler = mock(InputOutputHandler.class);
        books = new ArrayList<Book>(5);
        books.add(new Book("Head First Design Pattern!", "Martin Fowler", 2007));
        libraryModel = new LibraryModel(books);
        libraryView = new LibraryView(inputOutputHandler);
        libraryController = new LibraryController(libraryModel, libraryView);

    }


    @Test
    public void shouldBeAbleToDisplayBookListForTheUserWhenHeChoosesOneOnMainMenu() {
        doNothing().when(inputOutputHandler).writeMessage("/n Main Menu");
        doNothing().when(inputOutputHandler).writeMessage("1. List Books");
        when(inputOutputHandler.input("Enter your choice!")).thenReturn(1);

        libraryController.mainMenu();

        verify(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");
    }
}
