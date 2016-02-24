package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {
    Writer writer;
    Biblioteca bibliotecaApp;

    @Before
    public void setup () {
        writer = mock(Writer.class);
        bibliotecaApp = new Biblioteca(writer);
    }

    @Test
    public void WelcomeMessageMustBeDisplayedForTheUser() {
        bibliotecaApp.welcome();

        verify(writer).writeMessage("**** Welcome Customer! We are glad to have you at Biblioteca! ****");
    }

    @Test
    public void BookListMustBeDisplayedForTheUser() {
        bibliotecaApp.addBooks();
        doNothing().when(writer).writeMessage("Head First Design Pattern! Martin Fowler 2007");

        bibliotecaApp.displayBooks();

        verify(writer).writeMessage("Head First Design Pattern! Martin Fowler 2007");
    }

    @Test
    public void MainMenuMustBeDisplayed() {
        bibliotecaApp.mainMenu();

        verify(writer).writeMessage("/n Main Menu");
        verify(writer).writeMessage("1. List Books");
    }
}




