package com.twu.biblioteca;

import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.InputOutputHandler;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AppViewTest {
    @Test
    public void ShouldBeAbleToDisplayMessage() {
        InputOutputHandler inputOutputHandler = mock(InputOutputHandler.class);
        AppView appView = new AppView(inputOutputHandler);
        appView.displayMessage("Message");

        verify(inputOutputHandler).writeMessage("Message");
    }
}
