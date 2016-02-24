package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {
    @Test
    public void WelcomeMessageMustBeDisplayedForTheUser() {
        Writer writer = mock(Writer.class);
        Biblioteca bibliotecaApp = new Biblioteca(writer);

        bibliotecaApp.welcome();
        verify(writer).writeMessage("**** Welcome Customer! We are glad to have you at Biblioteca! ****");
    }

    @Test
    public void BookListMustBeDisplayedForTheUser() {
        Writer writer = mock(Writer.class);
        Biblioteca bibliotecaApp = new Biblioteca(writer);

        bibliotecaApp.displayBooks();
        verify(writer).writeMessage("Head First Design Pattern! Martin Fowler 2007");
    }
}

