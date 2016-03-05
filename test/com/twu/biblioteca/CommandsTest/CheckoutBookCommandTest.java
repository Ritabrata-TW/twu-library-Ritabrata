package com.twu.biblioteca.CommandsTest;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.LoginController;
import com.twu.biblioteca.Model.Commands.CheckoutBookCommand;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutBookCommandTest {

    @Test
    public void shouldBeAbleToCheckoutBookWhenCommandIsExecuted() {
        ItemController booksController = mock(ItemController.class);
        LoginController loginController = mock(LoginController.class);
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand(booksController, loginController);
        when(booksController.getItemNumber("Enter the number of the book that you want to checkout")).thenReturn(1);

        checkoutBookCommand.execute();

        verify(booksController).checkoutItem(loginController);
    }
}
