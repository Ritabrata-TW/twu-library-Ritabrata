package com.twu.biblioteca.ModelsTest;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Model.Books;
import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;
import com.twu.biblioteca.Model.Customers;
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
import static org.mockito.Mockito.when;


//Test for Books App
public class BooksTest {
    InputOutputHandler inputOutputHandler;
    Books booksModel;
    Book headFirstDesignPattern;
    Book headFirstJava;
    Customers loginModel;

    List<Item> books;

    @Before
    public void setup() {
        books = new ArrayList<>(5);
        headFirstDesignPattern = new Book(100, "Head First Design Pattern!", "Martin Fowler", 2007);
        headFirstJava = new Book(101, "Head First Java", "Martin Fowler", 2000);
        books.add(headFirstDesignPattern);
        books.add(headFirstJava);

        loginModel = mock(Customers.class);
        inputOutputHandler = mock(InputOutputHandler.class);
        booksModel = new Books(books, loginModel);
    }

    @Test
    public void shouldBeAbleToAddBooksToTheLibrary() {
        Assert.assertEquals(Arrays.asList(headFirstDesignPattern, headFirstJava), booksModel.getItems());
    }

    @Test
    public void shouldBeAbleToCheckoutABook() throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        when(loginModel.loggedInUserId()).thenReturn("abcd");
        booksModel.checkoutItem(100);

        Assert.assertTrue(headFirstDesignPattern.checkoutStatus());

    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldNotBeAbleToCheckoutSameBookTwice() throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        when(loginModel.loggedInUserId()).thenReturn("1234");

        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("This book doesn't exist in the records");

        booksModel.checkoutItem(100);
        booksModel.checkoutItem(100);
    }

    @Test
    public void shouldThrowExceptionIfBookNameEnteredIsNotPresentInLibrary() throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        when(loginModel.loggedInUserId()).thenReturn("1234");
        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("This book doesn't exist in the records");

        booksModel.checkoutItem(109);
    }

    @Test
    public void shouldBeAbleToReturnABookThatWasPreviouslyCheckedOut() throws NotFoundException, BookAlreadyPresentException, InvalidInputException, UserNotLoggedInException {
        when(loginModel.loggedInUserId()).thenReturn("1234-567").thenReturn("1234-567");
        booksModel.checkoutItem(100);

        Assert.assertTrue(headFirstDesignPattern.checkoutStatus());

        booksModel.returnItem(100);

        Assert.assertFalse(headFirstDesignPattern.checkoutStatus());
    }

    @Test
    public void shouldNotBeAbleToReturnABookThatWasNotPreviouslyCheckedOut() throws BookAlreadyPresentException, InvalidInputException, NotFoundException, UserNotLoggedInException {
        expectedException.expect(BookAlreadyPresentException.class);
        expectedException.expectMessage("That is not a valid book to return.");
        when(loginModel.loggedInUserId()).thenReturn("1234");

        booksModel.returnItem(100);
    }

    @Test
    public void shouldNotBeAbleToCheckoutOrReturnBookIfUserIsNotLoggedIn() throws UserNotLoggedInException {
        expectedException.expect(UserNotLoggedInException.class);

        booksModel.checkIfLoggedIn();
    }

    @Test
    public void shouldBeAbleToStoreLibraryNumberOfUserWhenHeChecksOutABook() throws InvalidInputException, UserNotLoggedInException, NotFoundException {
        when(loginModel.loggedInUserId()).thenReturn("123-4567").thenReturn("123-4567");
        booksModel.checkoutItem(100);

        Assert.assertEquals("123-4567",headFirstDesignPattern.getCheckedOutBy());
    }

    @Test
    public void shouldNotBeAbleToReturnABookThatWasWithdrawnBySomeoneElse() throws InvalidInputException, UserNotLoggedInException, NotFoundException, BookAlreadyPresentException {
        expectedException.expect(BookAlreadyPresentException.class);

        when(loginModel.loggedInUserId()).thenReturn("123-4567").thenReturn("123-4567").thenReturn("765-4321").thenReturn("765-4321");
        booksModel.checkoutItem(100);

        booksModel.returnItem(100);
    }
}




