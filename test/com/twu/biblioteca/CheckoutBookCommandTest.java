package com.twu.biblioteca;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Model.CheckoutBookCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutBookCommandTest {

    @Test
    public void shouldGetBookNumberWhenCommandIsExecuted() {
        BooksController booksController = mock(BooksController.class);
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand(booksController);

        checkoutBookCommand.execute();

        verify(booksController).getBookNumber("Enter the number of the book that you want to checkout");
    }

    @Test
    public void shouldBeAbleToCheckoutBookWhenCommandIsExecuted() {
        BooksController booksController = mock(BooksController.class);
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand(booksController);
        when(booksController.getBookNumber("Enter the number of the book that you want to checkout")).thenReturn(1);

        checkoutBookCommand.execute();

        verify(booksController).checkoutBook(1);
    }
}
