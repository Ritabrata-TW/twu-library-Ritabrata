package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ExampleTest {

    @Test
    public void test() {
        @Test
        public void welcometest() {
            BibliotecaApp test = mock(BibliotecaApp.class);
            BibliotecaApp.IntegerAsker asker = mock(BibliotecaApp.IntegerAsker.class);
            test.welcome(asker);
            verify(asker).printLine("**** Welcome Customer! We are glad to have you at Biblioteca! ****");
        }
    }
}
