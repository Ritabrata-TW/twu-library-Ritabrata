package com.twu.biblioteca;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.BookAlreadyPresentException;
import com.twu.biblioteca.Model.BookNotFoundException;
import com.twu.biblioteca.Model.BooksModel;
import com.twu.biblioteca.View.InputOutputHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;


//Test for BooksModel App
public class BooksModelTest {
    InputOutputHandler inputOutputHandler;
    BooksModel booksModel;
    Book headFirstDesignPattern;
    Book headFirstJava;

    List<Book> books;

    @Before
    public void setup () {
        books = new ArrayList<Book>(5);
        headFirstDesignPattern = new Book("Head First Design Pattern!", "Martin Fowler", 2007, false);
        headFirstJava = new Book("Head First Java", "Martin Fowler", 2000, false);
        books.add(headFirstDesignPattern);
        books.add(headFirstJava);

        inputOutputHandler = mock(InputOutputHandler.class);
        booksModel = new BooksModel(books);
    }

    @Test
    public void shouldBeAbleToAddBooksToTheLibrary() {
        Assert.assertEquals(Arrays.asList(headFirstDesignPattern,headFirstJava), booksModel.getBooks());
    }

    @Test
    public void shouldBeAbleToCheckoutABook() throws BookNotFoundException {
        booksModel.checkoutBook("Head First Design Pattern!");

        Assert.assertTrue(headFirstDesignPattern.checkoutStatus());

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

    @Test
    public void shouldBeAbleToReturnABookThatWasPreviouslyCheckedOut() throws BookNotFoundException, BookAlreadyPresentException {
        booksModel.checkoutBook("Head First Design Pattern!");

        Assert.assertTrue(headFirstDesignPattern.checkoutStatus());

        booksModel.returnBook("Head First Design Pattern!");

        Assert.assertFalse(headFirstDesignPattern.checkoutStatus());
    }

    @Test
    public void shouldNotBeAbleToReturnABookThatWasNotPreviouslyCheckedOut() throws BookAlreadyPresentException {
        expectedException.expect(BookAlreadyPresentException.class);
        expectedException.expectMessage("That is not a valid book to return.");

        booksModel.returnBook("Head First Design Pattern!");
    }
}




