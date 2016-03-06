package com.twu.biblioteca.CommandsTest;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.CustomersController;
import com.twu.biblioteca.Model.Commands.ReturnBookCommand;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ReturnBookCommandTest {

    ItemController itemController;
    CustomersController customersController;
    ReturnBookCommand returnBookCommand;

    @Before
    public void setup() {
        itemController = mock(ItemController.class);
        customersController = mock(CustomersController.class);
        returnBookCommand = new ReturnBookCommand(itemController);
    }

    @Test
    public void shouldBeAbleReturnBookWhenCommandIsExecuted() {
        when(itemController.getItemNumber("Enter the name of the book that you want to return")).thenReturn(1);

        returnBookCommand.execute();

        verify(itemController).returnItem();
    }
}
