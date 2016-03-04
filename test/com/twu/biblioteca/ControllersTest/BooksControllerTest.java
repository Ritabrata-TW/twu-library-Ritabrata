package com.twu.biblioteca.ControllersTest;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Model.Books;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
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


    @Before
    public void setup() {
        book = new Book(101, "Head First Design Pattern!", "Martin Fowler", 2007, false);
        books = new ArrayList<Item>(5);
        books.add(book);
        booksModel = mock(Books.class);
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

        itemController.checkoutItem();

        verify(appView).displayMessage("Thank you! Enjoy! ");
    }

    @Test
    public void shouldBeAbleToDisplaySuccessMessageToUserOnSuccessfulReturn() {
        itemController.checkoutItem();
        itemController.returnItem();

        verify(appView).displayMessage("Thank you! Enjoy! ");
    }

    @Test
    public void shouldBeAbleToWarnUserIfInputIsInvalidDuringCheckout() throws NotFoundException, InvalidInputException {
        when(itemsView.getItemNumber("Enter the number of the item that you want to checkout")).thenReturn(1);
        when(booksModel.checkoutItem(1)).thenThrow(new InvalidInputException());

        itemController.checkoutItem();

        verify(appView).displayMessage("Please select a valid option! ");
    }

    @Test
    public void shouldBeAbleToWarnUserIfBookDoesNotExistDuringCheckout() throws NotFoundException, InvalidInputException {
        when(itemsView.getItemNumber("Enter the number of the item that you want to checkout")).thenReturn(1);
        when(booksModel.checkoutItem(1)).thenThrow(new NotFoundException("Book not found!"));

        itemController.checkoutItem();

        verify(appView).displayMessage("That item is not available.");

    }

    @Test
    public void shouldBeAbleToGetBookNumber() {
        when(itemsView.getItemNumber("Enter the number of the book. ")).thenReturn(1);

        Assert.assertEquals(1, itemController.getItemNumber("Enter the number of the book. "), 0);
    }
}
