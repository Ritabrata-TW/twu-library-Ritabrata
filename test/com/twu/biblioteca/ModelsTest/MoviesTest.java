package com.twu.biblioteca.ModelsTest;

import com.twu.biblioteca.Controller.LoginController;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Movies;
import com.twu.biblioteca.View.InputOutputHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MoviesTest {
    InputOutputHandler inputOutputHandler;
    Movies moviesModel;
    Movie schindlersList;
    LoginController loginController;
    Movie swades;
    List<Item> movies;

    @Before
    public void setup() {
        movies = new ArrayList<Item>(5);
        schindlersList = new Movie(1, "The Schindler's List", 1994, "Steven Spielberg", 10, false, null);
        swades = new Movie(2, "Swades", 2000, "Rakesh Roshan", 8, false, null);
        movies.add(schindlersList);
        movies.add(swades);
        inputOutputHandler = mock(InputOutputHandler.class);
        loginController = mock(LoginController.class);
        moviesModel = new Movies(movies);
    }

    @Test
    public void shouldBeAbleToAddMoviesToTheLibrary() {
        Assert.assertEquals(Arrays.asList(schindlersList, swades), moviesModel.getItems());
    }

    @Test
    public void shouldBeAbleToCheckoutAMovie() throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        when(loginController.checkIfLoggedIn()).thenReturn(true);
        moviesModel.checkoutItem(1, loginController);

        Assert.assertTrue(schindlersList.checkoutStatus());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldNotBeAbleToCheckoutSameMovieTwice() throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        when(loginController.checkIfLoggedIn()).thenReturn(true);

        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("This movie doesn't exist in the records");

        moviesModel.checkoutItem(100, loginController);
        moviesModel.checkoutItem(100, loginController);
    }

    @Test
    public void shouldThrowExceptionIfMovieNumberEnteredIsNotPresentInLibrary() throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        when(loginController.checkIfLoggedIn()).thenReturn(true);

        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("This movie doesn't exist in the records");

        moviesModel.checkoutItem(109, loginController);
    }

    @Test
    public void shouldNotBeAbleToCheckoutOrReturnMoviesIfUserIsNotLoggedIn() throws UserNotLoggedInException {
        expectedException.expect(UserNotLoggedInException.class);

        moviesModel.checkIfLoggedIn(mock(LoginController.class));
    }

}
