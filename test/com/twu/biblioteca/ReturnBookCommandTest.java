package com.twu.biblioteca;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Model.ReturnBookCommand;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        verify(booksController).returnBook(1);
    }
}
