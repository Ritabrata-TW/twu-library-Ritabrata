package com.twu.biblioteca.ViewsTest;

import com.twu.biblioteca.Model.LoginData;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.InputOutputHandler;
import com.twu.biblioteca.View.CustomersView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CustomersViewTest {
    InputOutputHandler inputOutputHandler;
    AppView appView;
    CustomersView customersView;

    @Before
    public void setup() {
        inputOutputHandler = mock(InputOutputHandler.class);
        appView = mock(AppView.class);
        customersView = new CustomersView(inputOutputHandler, appView);
    }

    @Test
    public void shouldBeAbleToAskUserforUsername() {
        customersView.inputDetails();

        verify(inputOutputHandler).writeMessage("Please enter your library number.");
        verify(inputOutputHandler, times(2)).getString();
    }

    @Test
    public void shouldBeAbleToAskUserForPassword() {
        customersView.inputDetails();

        verify(inputOutputHandler).writeMessage("Please enter your password.");
        verify(inputOutputHandler, times(2)).getString();
    }

    @Test
    public void shouldBeAbleToTakeInputDetailsAndReturnCorrectLoginData() {
        when(inputOutputHandler.getString()).thenReturn("abcd").thenReturn("bacd");

        Assert.assertEquals(new LoginData("abcd", "bacd"), customersView.inputDetails());
    }

    @Test
    public void shouldBeAbleToDisplayCustomerDetailsForAParticularCustomer() {
        customersView.displayDetails("Ritabrata Moitra rmoitra@thoughtworks.com 8013976041");

        verify(inputOutputHandler).writeMessage("Ritabrata Moitra rmoitra@thoughtworks.com 8013976041");
    }

    @Test
    public void shouldBeAbleToDisplayMessageViaAppview() {
        customersView.displayMessage("This is a test message.");

        verify(appView).displayMessage("This is a test message.");
    }




}
