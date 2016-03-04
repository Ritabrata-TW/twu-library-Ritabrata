package com.twu.biblioteca;

import com.twu.biblioteca.View.InputOutputHandler;
import com.twu.biblioteca.View.MenuView;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenusViewTest {
    InputOutputHandler inputOutputHandler;
    MenuView menuView;
    ArrayList<String> options;

    @Before
    public void setup() {
        inputOutputHandler = mock(InputOutputHandler.class);
        menuView = new MenuView(inputOutputHandler);
        options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Books");
    }

    @Test
    public void WelcomeMessageMustBeDisplayedForTheUser() {
        menuView.welcome();

        verify(inputOutputHandler).writeMessage("**** Welcome Customer! We are glad to have you at Books! ****");
    }

    @Test
    public void MainMenuMustBeDisplayed() {
        menuView.displayMenuOptions(options);


        verify(inputOutputHandler).writeMessage("1. List Books");
        verify(inputOutputHandler).writeMessage("2. Quit");
        verify(inputOutputHandler).writeMessage("3. Checkout Books");
    }
}
