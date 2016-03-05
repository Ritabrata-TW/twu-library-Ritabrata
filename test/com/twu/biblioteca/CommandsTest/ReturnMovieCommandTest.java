package com.twu.biblioteca.CommandsTest;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.LoginController;
import com.twu.biblioteca.Model.Commands.ReturnMovieCommand;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ReturnMovieCommandTest {

    ItemController itemController;
    ReturnMovieCommand returnMovieCommand;
    LoginController loginController;

    @Before
    public void setup() {
        itemController = mock(ItemController.class);
        loginController = mock(LoginController.class);
        returnMovieCommand = new ReturnMovieCommand(itemController, loginController);
    }

    @Test
    public void shouldBeAbleReturnBookWhenCommandIsExecuted() {
        when(itemController.getItemNumber("Enter the name of the item that you want to return")).thenReturn(1);

        returnMovieCommand.execute();

        verify(itemController).returnItem(loginController);
    }
}
