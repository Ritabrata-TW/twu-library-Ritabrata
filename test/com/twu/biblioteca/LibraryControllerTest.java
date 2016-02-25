package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class LibraryControllerTest {
    ArrayList<Book> books;
    LibraryModel libraryModel;
    BooksView libraryView;
    LibraryController libraryController;


    @Before
    public void setup() {
        books = new ArrayList<Book>(5);
        books.add(new Book("Head First Design Pattern!", "Martin Fowler", 2007));
        libraryModel = new LibraryModel(books);
        libraryView = mock(BooksView.class);
        libraryController = new LibraryController(libraryModel, libraryView);

    }

    @Test
    public void shouldBeAbleToDisplayBookListForTheUserWhenHeChoosesOneOnMainMenu()  {
        when(libraryView.mainMenu()).thenReturn(1);

        libraryController.mainMenu();

        verify(libraryView).displayBooks(books);
    }


    @Test
    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNumericInvalidMenuOptionInMainMenuOption() {
        when(libraryView.mainMenu()).thenReturn(2);

        libraryController.mainMenu();

        verify(libraryView).displayMessage("Select a valid option!");
    }

    @Test
    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNonNumericInvalidMenuOptionInMainMenuOption() {
        when(libraryView.mainMenu()).thenReturn(0);

        libraryController.mainMenu();

        verify(libraryView).displayMessage("Select a valid option!");
    }
}
