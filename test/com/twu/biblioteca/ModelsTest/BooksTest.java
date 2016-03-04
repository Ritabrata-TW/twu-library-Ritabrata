package com.twu.biblioteca.ModelsTest;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.Model.Books;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
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


//Test for Books App
public class BooksTest {
    InputOutputHandler inputOutputHandler;
    Books booksModel;
    Book headFirstDesignPattern;
    Book headFirstJava;

    List<Item> books;

    @Before
    public void setup() {
        books = new ArrayList<Item>(5);
        headFirstDesignPattern = new Book(100, "Head First Design Pattern!", "Martin Fowler", 2007, false);
        headFirstJava = new Book(101, "Head First Java", "Martin Fowler", 2000, false);
        books.add(headFirstDesignPattern);
        books.add(headFirstJava);

        inputOutputHandler = mock(InputOutputHandler.class);
        booksModel = new Books(books);
    }

    @Test
    public void shouldBeAbleToAddBooksToTheLibrary() {
        Assert.assertEquals(Arrays.asList(headFirstDesignPattern, headFirstJava), booksModel.getItems());
    }

    @Test
    public void shouldBeAbleToCheckoutABook() throws NotFoundException, InvalidInputException {
        booksModel.checkoutItem(100);

        Assert.assertTrue(headFirstDesignPattern.checkoutStatus());

    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldNotBeAbleToCheckoutSameBookTwice() throws NotFoundException, InvalidInputException {
        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("This book doesn't exist in the records");

        booksModel.checkoutItem(100);
        booksModel.checkoutItem(100);
    }

    @Test
    public void shouldThrowExceptionIfBookNameEnteredIsNotPresentInLibrary() throws NotFoundException, InvalidInputException {
        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("This book doesn't exist in the records");

        booksModel.checkoutItem(109);
    }

    @Test
    public void shouldBeAbleToReturnABookThatWasPreviouslyCheckedOut() throws NotFoundException, BookAlreadyPresentException, InvalidInputException {
        booksModel.checkoutItem(100);

        Assert.assertTrue(headFirstDesignPattern.checkoutStatus());

        booksModel.returnItem(100);

        Assert.assertFalse(headFirstDesignPattern.checkoutStatus());
    }

    @Test
    public void shouldNotBeAbleToReturnABookThatWasNotPreviouslyCheckedOut() throws BookAlreadyPresentException, InvalidInputException, NotFoundException {
        expectedException.expect(BookAlreadyPresentException.class);
        expectedException.expectMessage("That is not a valid book to return.");

        booksModel.returnItem(100);
    }
}




