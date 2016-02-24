package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {
    @Test
    public void welcometest() {
        InputOutputStream inputOutputStream = mock(InputOutputStream.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(inputOutputStream);

        bibliotecaApp.welcome("**** Welcome Customer! We are glad to have you at Biblioteca! ****");
        verify(inputOutputStream).printLine("**** Welcome Customer! We are glad to have you at Biblioteca! ****");
    }
}

