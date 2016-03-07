package com.twu.biblioteca.ViewsTest;

import com.twu.biblioteca.View.AppView;
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
    AppView appView;

    @Before
    public void setup() {
        inputOutputHandler = mock(InputOutputHandler.class);
        appView = mock(AppView.class);
        menuView = new MenuView(inputOutputHandler, appView);
        options = new ArrayList<>();
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

    @Test
    public void shouldBeAbleToDelegateDisplayMessageCallToAppview() {
        menuView.displayMessage("This is a test message");

        verify(appView).displayMessage("This is a test message");
    }
}
