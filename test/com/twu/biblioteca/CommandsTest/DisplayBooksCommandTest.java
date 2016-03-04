package com.twu.biblioteca.CommandsTest;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Model.Commands.DisplayBooksCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DisplayBooksCommandTest {
    @Test
    public void shouldBeAbleToDisplayBooksWhenCommandIsExecuted() {
        ItemController booksController = mock(ItemController.class);
        DisplayBooksCommand displayBooksCommand = new DisplayBooksCommand(booksController);

        displayBooksCommand.execute();

        verify(booksController).displayItems();
    }
}
