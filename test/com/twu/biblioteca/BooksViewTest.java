package com.twu.biblioteca;

import com.twu.biblioteca.Model.DTO.Book;
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
        headFirstDesignPattern = new Book(100, "Head First Design Pattern!", "Martin Fowler", 2007, false);
        headFirstJava = new Book(101, "Head First Java", "Martin Fowler", 2010, false);
        books.add(headFirstDesignPattern);
        books.add(headFirstJava);
        inputOutputHandler = mock(InputOutputHandler.class);
        booksView = new BooksView(inputOutputHandler);
    }

    @Test
    public void PresentBookListMustBeDisplayedForTheUser() {
        doNothing().when(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");

        booksView.displayBooks(books);

        verify(inputOutputHandler).writeMessage("100 Head First Design Pattern! Martin Fowler 2007");
    }

    @Test
    public void checkedOutBooksShouldNotBeDisplayedToTheUser() {
        ImperialC = new Book(102, "Imperial C", "Dennis Ritchie", 1945, true);
        books.add(ImperialC);

        booksView.displayBooks(books);

        verify(inputOutputHandler, times(0)).writeMessage("102 Imperial C Dennis Ritchie 1945");
    }
}
