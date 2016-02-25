package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class LibraryViewTest {
    InputOutputHandler inputOutputHandler;
    LibraryView libraryView;
    List<Book> books;

    @Before
    public void setup() {
        books = new ArrayList<Book>(5);
        books.add(new Book("Head First Design Pattern!", "Martin Fowler", 2007));

        inputOutputHandler = mock(InputOutputHandler.class);
        libraryView = new LibraryView(inputOutputHandler);
    }

    @Test
    public void WelcomeMessageMustBeDisplayedForTheUser() {
        libraryView.welcome();

        verify(inputOutputHandler).writeMessage("**** Welcome Customer! We are glad to have you at LibraryModel! ****");
    }

    @Test
    public void ShouldBeAbleToDisplayMessage() {
        libraryView.displayMessage("Message");

        verify(inputOutputHandler).writeMessage("Message");
    }

    @Test
    public void BookListMustBeDisplayedForTheUser() {
        doNothing().when(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");

        libraryView.displayBooks(books);

        verify(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");
    }

    @Test
    public void MainMenuMustBeDisplayed()  {
        libraryView.mainMenu();

        verify(inputOutputHandler).writeMessage("/n Main Menu");
        verify(inputOutputHandler).writeMessage("1. List Books");
    }

    @Test
    public void MustBeAbleToHandleNonNumericEntryForMainMenuInput() {
        when(inputOutputHandler.input("Enter your choice!")).thenReturn(Integer.valueOf("a"));


    }

}
