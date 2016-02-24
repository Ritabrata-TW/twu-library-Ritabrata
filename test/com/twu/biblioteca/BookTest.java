package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {
    @Test
    public void BookListMustBeDisplayedForTheUser() {
        Writer writer = mock(Writer.class);
        Biblioteca bibliotecaApp = new Biblioteca(writer);

        bibliotecaApp.displayBooks();
        verify(writer).writeMessage("Head First Design Pattern! Martin Fowler 2007");
    }
}
