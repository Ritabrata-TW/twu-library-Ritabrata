package com.twu.biblioteca;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Model.DisplayBooksCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DisplayBooksCommandTest {
    @Test
    public void shouldBeAbleToDisplayBooksWhenCommandIsExecuted() {
        BooksController booksController = mock(BooksController.class);
        DisplayBooksCommand displayBooksCommand = new DisplayBooksCommand(booksController);

        displayBooksCommand.execute();

        verify(booksController).displayBooks();
    }
}
