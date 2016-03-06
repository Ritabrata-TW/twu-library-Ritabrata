package com.twu.biblioteca.ViewsTest;

import com.twu.biblioteca.Model.LoginData;
import com.twu.biblioteca.View.InputOutputHandler;
import com.twu.biblioteca.View.LoginView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CustomersViewTest {
    InputOutputHandler inputOutputHandler;
    LoginView loginView;

    @Before
    public void setup() {
        inputOutputHandler = mock(InputOutputHandler.class);
        loginView = new LoginView(inputOutputHandler);
    }

    @Test
    public void shouldBeAbleToAskUserforUsername() {
        loginView.inputDetails();

        verify(inputOutputHandler).writeMessage("Please enter your library number.");
        verify(inputOutputHandler, times(2)).getString();
    }

    @Test
    public void shouldBeAbleToAskUserForPassword() {
        loginView.inputDetails();

        verify(inputOutputHandler).writeMessage("Please enter your password.");
        verify(inputOutputHandler, times(2)).getString();
    }

    @Test
    public void shouldBeAbleToTakeInputDetailsAndReturnCorrectLoginData() {
        when(inputOutputHandler.getString()).thenReturn("abcd").thenReturn("bacd");

        Assert.assertEquals(new LoginData("abcd", "bacd"), loginView.inputDetails());
    }


}
