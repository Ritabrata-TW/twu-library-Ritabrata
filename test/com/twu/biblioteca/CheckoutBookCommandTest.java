package com.twu.biblioteca;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Model.Commands.CheckoutBookCommand;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutBookCommandTest {

    @Test
    public void shouldBeAbleToCheckoutBookWhenCommandIsExecuted() {
        BooksController booksController = mock(BooksController.class);
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand(booksController);
        when(booksController.getBookNumber("Enter the number of the book that you want to checkout")).thenReturn(1);

        checkoutBookCommand.execute();

        verify(booksController).checkoutBook();
    }
}
