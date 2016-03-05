package com.twu.biblioteca.ModelsTest;

import com.twu.biblioteca.Controller.LoginController;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Model.Books;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;
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
    LoginController loginController;

    List<Item> books;

    @Before
    public void setup() {
        books = new ArrayList<Item>(5);
        headFirstDesignPattern = new Book(100, "Head First Design Pattern!", "Martin Fowler", 2007, false);
        headFirstJava = new Book(101, "Head First Java", "Martin Fowler", 2000, false);
        books.add(headFirstDesignPattern);
        books.add(headFirstJava);

        loginController = mock(LoginController.class);
        inputOutputHandler = mock(InputOutputHandler.class);
        booksModel = new Books(books);
    }

    @Test
    public void shouldBeAbleToAddBooksToTheLibrary() {
        Assert.assertEquals(Arrays.asList(headFirstDesignPattern, headFirstJava), booksModel.getItems());
    }

    @Test
    public void shouldBeAbleToCheckoutABook() throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        when(loginController.checkIfLoggedIn()).thenReturn(true);
        booksModel.checkoutItem(100, loginController);

        Assert.assertTrue(headFirstDesignPattern.checkoutStatus());

    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldNotBeAbleToCheckoutSameBookTwice() throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        when(loginController.checkIfLoggedIn()).thenReturn(true);

        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("This book doesn't exist in the records");

        booksModel.checkoutItem(100, loginController);
        booksModel.checkoutItem(100, loginController);
    }

    @Test
    public void shouldThrowExceptionIfBookNameEnteredIsNotPresentInLibrary() throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        when(loginController.checkIfLoggedIn()).thenReturn(true);
        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("This book doesn't exist in the records");

        booksModel.checkoutItem(109, loginController);
    }

    @Test
    public void shouldBeAbleToReturnABookThatWasPreviouslyCheckedOut() throws NotFoundException, BookAlreadyPresentException, InvalidInputException, UserNotLoggedInException {
        when(loginController.checkIfLoggedIn()).thenReturn(true);
        booksModel.checkoutItem(100, loginController);

        Assert.assertTrue(headFirstDesignPattern.checkoutStatus());

        booksModel.returnItem(100, loginController);

        Assert.assertFalse(headFirstDesignPattern.checkoutStatus());
    }

    @Test
    public void shouldNotBeAbleToReturnABookThatWasNotPreviouslyCheckedOut() throws BookAlreadyPresentException, InvalidInputException, NotFoundException, UserNotLoggedInException {
        expectedException.expect(BookAlreadyPresentException.class);
        expectedException.expectMessage("That is not a valid book to return.");
        when(loginController.checkIfLoggedIn()).thenReturn(true);

        booksModel.returnItem(100, loginController);
    }

    @Test
    public void shouldNotBeAbleToCheckoutOrReturnBookIfUserIsNotLoggedIn() throws UserNotLoggedInException {
        expectedException.expect(UserNotLoggedInException.class);

        booksModel.checkIfLoggedIn(mock(LoginController.class));
    }
}




