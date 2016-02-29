package com.twu.biblioteca;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.BookNotFoundException;
import com.twu.biblioteca.Model.BooksModel;
import com.twu.biblioteca.View.InputOutputHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collections;
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
        book = new Book("Head First Design Pattern!", "Martin Fowler", 2007, false);
        books.add(book);

        inputOutputHandler = mock(InputOutputHandler.class);
        booksModel = new BooksModel(books);
    }

    @Test
    public void shouldBeAbleToAddBooksToTheLibrary() {
        Assert.assertEquals(Collections.singletonList(book), booksModel.getBooks());
    }

    @Test
    public void shouldBeAbleToCheckoutABook() throws BookNotFoundException {
        booksModel.checkoutBook("Head First Design Pattern!");

        Assert.assertTrue(book.checkoutStatus());

    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldNotBeAbleToCheckoutSameBookTwice() throws BookNotFoundException {
        expectedException.expect(BookNotFoundException.class);
        expectedException.expectMessage("This book doesn't exist in the records");

        booksModel.checkoutBook("Head First Design Pattern!");
        booksModel.checkoutBook("Head First Design Pattern!");
    }

    @Test
    public void shouldThrowExceptionIfBookNameEnteredIsNotPresentInLibrary() throws BookNotFoundException {
        expectedException.expect(BookNotFoundException.class);
        expectedException.expectMessage("This book doesn't exist in the records");

        booksModel.checkoutBook("The Pragmatic Programmer");
    }
}




