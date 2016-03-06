package com.twu.biblioteca.ControllersTest;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.CustomersController;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Model.Books;
import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.ItemsView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class BooksControllerTest {
    ArrayList<Item> books;
    Books booksModel;
    ItemsView itemsView;
    ItemController itemController;
    Book book;
    AppView appView;
    CustomersController customersController;


    @Before
    public void setup() {
        book = new Book(101, "Head First Design Pattern!", "Martin Fowler", 2007);
        books = new ArrayList<>(5);
        books.add(book);
        booksModel = mock(Books.class);
        customersController = mock(CustomersController.class);

        itemsView = mock(ItemsView.class);
        appView = mock(AppView.class);
        itemController = new ItemController(booksModel, itemsView, appView);
    }

    @Test
    public void shouldBeAbleToDisplayBooks() {
        doNothing().when(itemsView).displayItems(books);
        when(booksModel.getItems()).thenReturn(books);

        itemController.displayItems();

        verify(itemsView).displayItems(books);
    }

    @Test
    public void shouldBeAbleToDisplaySuccesMessageToUserOnSuccessfulCheckout() {
        itemController.checkoutItem("book");

        verify(appView).displayMessage("Thank you! Enjoy the book! ");
    }

    @Test
    public void shouldBeAbleToDisplaySuccessMessageToUserOnSuccessfulReturn() {
        itemController.checkoutItem("book");
        itemController.returnItem("book");

        verify(appView).displayMessage("Thank you! Enjoy the book! ");
    }

    @Test
    public void shouldBeAbleToWarnUserIfInputIsInvalidDuringCheckout() throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        when(itemsView.getItemNumber("Enter the number of the book that you want to checkout")).thenReturn(1);
        when(booksModel.checkoutItem(1)).thenThrow(new InvalidInputException());

        itemController.checkoutItem("book");

        verify(appView).displayMessage("Please select a valid option! ");
    }

    @Test
    public void shouldBeAbleToWarnUserIfBookDoesNotExistDuringCheckout() throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        when(itemsView.getItemNumber("Enter the number of the book that you want to checkout")).thenReturn(1);
        when(booksModel.checkoutItem(1)).thenThrow(new NotFoundException("Book not found!"));

        itemController.checkoutItem("book");

        verify(appView).displayMessage("That book is not available.");

    }

    @Test
    public void shouldBeAbleToGetBookNumber() {
        when(itemsView.getItemNumber("Enter the number of the book. ")).thenReturn(1);

        Assert.assertEquals(1, itemController.getItemNumber("Enter the number of the book. "), 0);
    }

    @Test
    public void shouldBeAbleToNotifyUserIfHeTriesToCheckoutWithoutLoggingIn() throws InvalidInputException, UserNotLoggedInException, NotFoundException {
        when(itemsView.getItemNumber("Enter the number of the book that you want to checkout")).thenReturn(1);
        when(booksModel.checkoutItem(1)).thenThrow(UserNotLoggedInException.class);

        itemController.checkoutItem("book");

        verify(appView).displayMessage("You need to be logged in to checkout a book");
    }

    @Test
    public void shouldBeAbleToWarnUserIfInputIsInvalidDuringReturn() throws NotFoundException, InvalidInputException, UserNotLoggedInException, BookAlreadyPresentException {
        when(itemsView.getItemNumber("Enter the number of the book that you want to return")).thenReturn(1);
        doThrow(new InvalidInputException()).when(booksModel).returnItem(1);


        itemController.returnItem("book");

        verify(appView).displayMessage("Please select a valid option! ");
    }

    @Test
    public void shouldBeAbleToWarnUserIfBookWasNotCheckedOutPreviouslyDuringReturn() throws NotFoundException, InvalidInputException, UserNotLoggedInException, BookAlreadyPresentException {
        when(itemsView.getItemNumber("Enter the number of the book that you want to return")).thenReturn(1);
        doThrow(new BookAlreadyPresentException("Book not checked out previusly. ")).when(booksModel).returnItem(1);

        itemController.returnItem("book");

        verify(appView).displayMessage("That is not a valid book to return.");

    }

    @Test
    public void shouldBeAbleToNotifyUserIfHeTriesToReturnWithoutLoggingIn() throws InvalidInputException, UserNotLoggedInException, NotFoundException, BookAlreadyPresentException {
        when(itemsView.getItemNumber("Enter the number of the book that you want to return")).thenReturn(1);
        doThrow(UserNotLoggedInException.class).when(booksModel).returnItem(1);

        itemController.returnItem("book");

        verify(appView).displayMessage("You need to be logged in to return a book");
    }


}
