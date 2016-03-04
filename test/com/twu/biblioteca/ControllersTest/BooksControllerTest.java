package com.twu.biblioteca.ControllersTest;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Model.Books;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.BooksView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        when(booksModel.getItems()).thenReturn(books);

        booksController.displayBooks();

        verify(booksView).displayBooks(books);
    }

    @Test
    public void shouldBeAbleToDisplaySuccesMessageToUserOnSuccessfulCheckout() {

        booksController.checkoutBook();

        verify(appView).displayMessage("Thank you! Enjoy the book! ");
    }

    @Test
    public void shouldBeAbleToDisplaySuccessMessageToUserOnSuccessfulReturn() {
        booksController.checkoutBook();
        booksController.returnBook();

        verify(appView).displayMessage("Thank you! Enjoy the book! ");
    }

    @Test
    public void shouldBeAbleToWarnUserIfInputIsInvalidDuringCheckout() throws NotFoundException, InvalidInputException {
        when(booksView.getBookNumber("Enter the number of the book that you want to checkout")).thenReturn(1);
        when(booksModel.checkoutItem(1)).thenThrow(new InvalidInputException());

        booksController.checkoutBook();

        verify(appView).displayMessage("Please select a valid option! ");
    }

    @Test
    public void shouldBeAbleToWarnUserIfBookDoesNotExistDuringCheckout() throws NotFoundException, InvalidInputException {
        when(booksView.getBookNumber("Enter the number of the book that you want to checkout")).thenReturn(1);
        when(booksModel.checkoutItem(1)).thenThrow(new NotFoundException("Book not found!"));

        booksController.checkoutBook();

        verify(appView).displayMessage("That book is not available.");

    }

    @Test
    public void shouldBeAbleToGetBookNumber() {
        when(booksView.getBookNumber("Enter the number of the book. ")).thenReturn(1);

        Assert.assertEquals(1, booksController.getBookNumber("Enter the number of the book. "), 0);
    }
}
