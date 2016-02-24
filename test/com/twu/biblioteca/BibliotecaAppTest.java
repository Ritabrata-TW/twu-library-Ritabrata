package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {
    @Test
    public void welcometest() {
        Writer writer = mock(Writer.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(writer);

        bibliotecaApp.welcome();
        verify(writer).write("**** Welcome Customer! We are glad to have you at Biblioteca! ****");
    }
}

