package com.twu.biblioteca;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.BooksModel;
import com.twu.biblioteca.View.BooksView;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BooksControllerTest {
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
    public void shouldBeAbleToDisplayBooks() {
        doNothing().when(booksView).displayBooks(books);

        booksController.displayBooks();

        verify(booksView).displayBooks(books);
    }

}
