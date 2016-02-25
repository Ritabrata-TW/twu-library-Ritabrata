package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class LibraryControllerTest {
    ArrayList<Book> books;
    BooksModel booksModel;
    BooksView booksView;
    BooksController booksController;


    @Before
    public void setup() {
        books = new ArrayList<Book>(5);
        books.add(new Book("Head First Design Pattern!", "Martin Fowler", 2007));
        booksModel = new BooksModel(books);
        booksView = mock(BooksView.class);
        booksController = new BooksController(booksModel, booksView);

    }

    @Test
    public void shouldBeAbleToDisplayBookListForTheUserWhenHeChoosesOneOnMainMenu()  {
        when(booksView.mainMenu()).thenReturn(1);

        booksController.mainMenu();

        verify(booksView).displayBooks(books);
    }


    @Test
    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNumericInvalidMenuOptionInMainMenuOption() {
        when(booksView.mainMenu()).thenReturn(2);

        booksController.mainMenu();

        verify(booksView).displayMessage("Select a valid option!");
    }

    @Test
    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNonNumericInvalidMenuOptionInMainMenuOption() {
        when(booksView.mainMenu()).thenReturn(0);

        booksController.mainMenu();

        verify(booksView).displayMessage("Select a valid option!");
    }
}
