package com.twu.biblioteca.CommandsTest;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Model.Commands.ReturnBookCommand;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ReturnBookCommandTest {

    BooksController booksController;
    ReturnBookCommand returnBookCommand;

    @Before
    public void setup() {
        booksController = mock(BooksController.class);
        returnBookCommand = new ReturnBookCommand(booksController);
    }

    @Test
    public void shouldBeAbleReturnBookWhenCommandIsExecuted() {
        when(booksController.getBookNumber("Enter the name of the book that you want to return")).thenReturn(1);

        returnBookCommand.execute();

        verify(booksController).returnBook();
    }
}
