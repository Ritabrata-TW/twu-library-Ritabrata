package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;


//Test for LibraryModel App
public class LibraryModelTest {
    InputOutputHandler inputOutputHandler;
    LibraryModel libraryModel;
    Book book;

    @Before
    public void setup () {
        List<Book> books = new ArrayList<Book>(5);
        book = new Book("Head First Design Pattern!", "Martin Fowler", 2007);
        books.add(book);

        inputOutputHandler = mock(InputOutputHandler.class);
        libraryModel = new LibraryModel(books);
    }

    @Test
    public void shouldBeAbleToAddBooksToTheLibrary() {
        Assert.assertEquals(Arrays.asList(book),libraryModel.getBooks());
    }
}




