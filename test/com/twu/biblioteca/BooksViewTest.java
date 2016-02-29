package com.twu.biblioteca;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.View.BooksView;
import com.twu.biblioteca.View.InputOutputHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BooksViewTest {
    InputOutputHandler inputOutputHandler;
    BooksView booksView;
    List<Book> books;
    Book headFirstDesignPattern;
    Book headFirstJava;
    Book ImperialC;


    @Before
    public void setup() {
        books = new ArrayList<Book>(5);
        headFirstDesignPattern = new Book("Head First Design Pattern!", "Martin Fowler", 2007, false);
        headFirstJava = new Book("Head First Java","Martin Fowler",2010, false);
        ImperialC = new Book("Imperial C","Dennis Ritchie",1945, true);
        books.add(headFirstDesignPattern);
        books.add(headFirstJava);
        books.add(ImperialC);
        inputOutputHandler = mock(InputOutputHandler.class);
        booksView = new BooksView(inputOutputHandler);
    }



    @Test
    public void ShouldBeAbleToDisplayMessage() {
        booksView.displayMessage("Message");

        verify(inputOutputHandler).writeMessage("Message");
    }

    @Test
    public void PresentBookListMustBeDisplayedForTheUser() {
        doNothing().when(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");

        booksView.displayBooks(books);

        verify(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");
    }

    @Test
    public void checkedOutBooksShouldNotBeDisplayedToTheUser() {
        booksView.displayBooks(books);

        verify(inputOutputHandler,times(0)).writeMessage("Imperial C Dennis Ritchie 1945");
    }
}
