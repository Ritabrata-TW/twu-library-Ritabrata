package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class LibraryViewTest {
    InputOutputHandler inputOutputHandler;
    BooksView booksView;
    List<Book> books;

    @Before
    public void setup() {
        books = new ArrayList<Book>(5);
        books.add(new Book("Head First Design Pattern!", "Martin Fowler", 2007));

        inputOutputHandler = mock(InputOutputHandler.class);
        booksView = new BooksView(inputOutputHandler);
    }

    @Test
    public void WelcomeMessageMustBeDisplayedForTheUser() {
        booksView.welcome();

        verify(inputOutputHandler).writeMessage("**** Welcome Customer! We are glad to have you at BooksModel! ****");
    }

    @Test
    public void ShouldBeAbleToDisplayMessage() {
        booksView.displayMessage("Message");

        verify(inputOutputHandler).writeMessage("Message");
    }

    @Test
    public void BookListMustBeDisplayedForTheUser() {
        doNothing().when(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");

        booksView.displayBooks(books);

        verify(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");
    }

    @Test
    public void MainMenuMustBeDisplayed()  {
        booksView.mainMenu();

        verify(inputOutputHandler).writeMessage("/n Main Menu");
        verify(inputOutputHandler).writeMessage("1. List Books");
    }


}
