package com.twu.biblioteca;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Books;
import com.twu.biblioteca.Model.InvalidInputException;
import com.twu.biblioteca.Model.NotFoundException;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.BooksView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class BooksControllerTest {
    ArrayList<Book> books;
    Books booksModel;
    BooksView booksView;
    BooksController booksController;
    Book book;
    AppView appView;


    @Before
    public void setup() {
        book = new Book(101, "Head First Design Pattern!", "Martin Fowler", 2007, false);
        books = new ArrayList<Book>(5);
        books.add(book);
        booksModel = mock(Books.class);
        booksView = mock(BooksView.class);
        appView = mock(AppView.class);
        booksController = new BooksController(booksModel, booksView, appView);
    }

    @Test
    public void shouldBeAbleToDisplayBooks() {
        doNothing().when(booksView).displayBooks(books);
        when(booksModel.getBooks()).thenReturn(books);

        booksController.displayBooks();

        verify(booksView).displayBooks(books);
    }

    @Test
    public void shouldBeAbleToDisplaySuccesMessageToUserOnSuccessfulCheckout() {

        booksController.checkoutBook(101);

        verify(appView).displayMessage("Thank you! Enjoy the book! ");
    }

    @Test
    public void shouldBeAbleToDisplaySuccessMessageToUserOnSuccessfulReturn() {
        booksController.checkoutBook(101);
        booksController.returnBook(101);

        verify(appView).displayMessage("Thank you! Enjoy the book! ");
    }

    @Test
    public void shouldBeAbleToWarnUserIfInputIsInvalid() throws NotFoundException, InvalidInputException {
        when(booksModel.checkoutBook(1)).thenThrow(new InvalidInputException());

        booksController.checkoutBook(1);

        verify(appView).displayMessage("Please select a valid option! ");
    }

    @Test
    public void shouldBeAbleToWarnUserIfBookDoesNotExist() throws NotFoundException, InvalidInputException {
        when(booksModel.checkoutBook(1)).thenThrow(new NotFoundException("Book not found!"));

        booksController.checkoutBook(1);

        verify(appView).displayMessage("That book is not available.");

    }

    @Test
    public void shouldBeAbleToGetBookNumber() {
        when(booksView.getBookNumber("Enter the number of the book. ")).thenReturn(1);

        Assert.assertEquals(1,booksController.getBookNumber("Enter the number of the book. "),0);
    }
}
