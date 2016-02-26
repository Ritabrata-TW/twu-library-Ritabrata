package com.twu.biblioteca;

import com.twu.biblioteca.View.BooksView;
import com.twu.biblioteca.View.InputOutputHandler;
import com.twu.biblioteca.View.MenuView;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuViewTest {
    InputOutputHandler inputOutputHandler;
    MenuView menuView;
    BooksView booksView;

    @Before
    public void setup() {
        inputOutputHandler = mock(InputOutputHandler.class);
        BooksView booksView = mock(BooksView.class);
        menuView = new MenuView(inputOutputHandler, booksView);

    }
    @Test
    public void MainMenuMustBeDisplayed()  {
        menuView.mainMenu();

        verify(inputOutputHandler).writeMessage("/n Main Menu");
        verify(inputOutputHandler).writeMessage("1. List Books");
    }
}
