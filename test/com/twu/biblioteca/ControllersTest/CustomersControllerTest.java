package com.twu.biblioteca.ControllersTest;

import com.twu.biblioteca.Controller.CustomersController;
import com.twu.biblioteca.Model.Exceptions.LoginDetailsInvalidException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;
import com.twu.biblioteca.Model.Customers;
import com.twu.biblioteca.Model.LoginData;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.CustomersView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CustomersControllerTest {
    Customers customersModel;
    CustomersView customersView;
    CustomersController customersController;
    AppView appView;

    @Before
    public void setup() {
        customersModel = mock(Customers.class);
        customersView = mock(CustomersView.class);
        appView = mock(AppView.class);
        customersController = new CustomersController(customersModel, customersView, appView);
    }

    @Test
    public void shouldBeAbleToAskUserForHisDetails() throws LoginDetailsInvalidException {
        customersController.logIn();

        verify(customersView).inputDetails();
    }

    @Test
    public void shouldBeAbleToLogInUserOnRecieveingDetails() throws LoginDetailsInvalidException {
        LoginData loginData = new LoginData("ritabrata1808@live.com", "abcd");
        when(customersView.inputDetails()).thenReturn(loginData);

        customersController.logIn();

        verify(customersModel).logIn(loginData);
    }

    @Test
    public void shouldBeAbleToDisplaySuccessMessageOnSuccessfulLogin() throws LoginDetailsInvalidException {
        when(customersView.inputDetails()).thenReturn(new LoginData("abcd", "abcd"));
        doNothing().when(customersModel).logIn(new LoginData("abcd", "abcd"));

        customersController.logIn();

        verify(appView).displayMessage("Login Successful!");

    }

    @Test
    public void shouldBeAbleToNotifyUserOnInvalidInputOfData() throws LoginDetailsInvalidException {
        when(customersView.inputDetails()).thenReturn(new LoginData("abcd", "abcd"));
        doThrow(LoginDetailsInvalidException.class).when(customersModel).logIn(new LoginData("abcd", "abcd"));

        customersController.logIn();

        verify(appView).displayMessage("Invalid Login details. Please try again.");
    }


    @Test
    public void shouldBeAbleToLogout() throws UserNotLoggedInException {
        customersController.logout();

        verify(customersModel).logout();
        verify(appView).displayMessage("You have been logged out! ");
    }

    @Test
    public void shouldNotBeAbleToLogoutIfNotPreviouslyLoggedIn() throws UserNotLoggedInException {
        doThrow(UserNotLoggedInException.class).when(customersModel).logout();

        customersController.logout();

        verify(appView).displayMessage("You are not currently logged in.");
    }

    @Test
    public void shouldBeAbleToGetDetailsOfACustomerAndPassItToView() {
        when(customersModel.details("1234")).thenReturn("Ritabrata Moitra rmoitra@thoughtworks.com 8013976041");

        customersController.displayDetails("1234");


        verify(customersView).displayDetails("Ritabrata Moitra rmoitra@thoughtworks.com 8013976041");
    }


}
