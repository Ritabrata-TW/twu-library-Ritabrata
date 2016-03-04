package com.twu.biblioteca.CommandsTest;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Model.Commands.CheckoutBookCommand;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutBookCommandTest {

    @Test
    public void shouldBeAbleToCheckoutBookWhenCommandIsExecuted() {
        ItemController booksController = mock(ItemController.class);
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand(booksController);
        when(booksController.getItemNumber("Enter the number of the book that you want to checkout")).thenReturn(1);

        checkoutBookCommand.execute();

        verify(booksController).checkoutItem();
    }
}
