package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;


//Test for BooksModel App
public class BooksModelTest {
    InputOutputHandler inputOutputHandler;
    BooksModel booksModel;
    Book book;

    @Before
    public void setup () {
        List<Book> books = new ArrayList<Book>(5);
        book = new Book("Head First Design Pattern!", "Martin Fowler", 2007);
        books.add(book);

        inputOutputHandler = mock(InputOutputHandler.class);
        booksModel = new BooksModel(books);
    }

    @Test
    public void shouldBeAbleToAddBooksToTheLibrary() {
        Assert.assertEquals(Arrays.asList(book), booksModel.getBooks());
    }
}




