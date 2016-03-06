package com.twu.biblioteca.ModelsTest;

import com.twu.biblioteca.Model.Exceptions.LoginDetailsInvalidException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;
import com.twu.biblioteca.Model.Customers;
import com.twu.biblioteca.Model.LoginData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CustomersModelTest {
    Customers customersModel;

    @Before
    public void setup() {
        customersModel = new Customers();
    }

    @Test
    public void userShouldBeAbleToLoginWhenCorrectUserInformationIsEntered() throws LoginDetailsInvalidException {
        customersModel.logIn(new LoginData("123-4567", "abcd"));

        Assert.assertTrue(customersModel.checkIfLoggedIn());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void userShouldNotBeAbleToLoginWhenIncorrectUserInformationIsEntered() throws LoginDetailsInvalidException {
        expectedException.expect(LoginDetailsInvalidException.class);

        customersModel.logIn(new LoginData("someone@thoughtworks.com", "abcd"));
    }

    @Test
    public void shouldBeAbleToKeepRecordOfThePresentLoggedInUser() throws LoginDetailsInvalidException {
        customersModel.logIn(new LoginData("123-4567", "abcd"));

        Assert.assertTrue(customersModel.checkIfLoggedIn());
        assertEquals("123-4567", customersModel.loggedInUserId());
    }

    @Test
    public void shouldBeAbleToLogout() throws LoginDetailsInvalidException, UserNotLoggedInException {
        customersModel.logIn(new LoginData("123-4567", "abcd"));

        customersModel.logout();

        Assert.assertFalse(customersModel.checkIfLoggedIn());
        assertEquals(null, customersModel.loggedInUserId());
    }

    @Test
    public void shouldNotBeAbleToLogoutIfNotPreviouslyLoggedIn() throws UserNotLoggedInException {
        expectedException.expect(UserNotLoggedInException.class);

        customersModel.logout();
    }

    @Test
    public void shouldBeAbleToProvideDetailsForAParticlarCustoemr() throws LoginDetailsInvalidException {
        customersModel.logIn(new LoginData("123-4567","abcd"));
        assertEquals("Ritabrata Moitra rmoitra@thoughtworks.com 8013976041", customersModel.details());
    }
}
