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

    @Before
    public void setup() {
        books = new ArrayList<Book>(5);
        books.add(new Book("Head First Design Pattern!", "Martin Fowler", 2007));

        inputOutputHandler = mock(InputOutputHandler.class);
        booksView = new BooksView(inputOutputHandler);
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




}
