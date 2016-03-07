package com.twu.biblioteca.ControllersTest;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.CustomersController;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Model.Exceptions.BookAlreadyPresentException;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Exceptions.UserNotLoggedInException;
import com.twu.biblioteca.Model.Movies;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.ItemsView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class MoviesControllerTest {
    ArrayList<Item> movies;
    Movies moviesModel;
    ItemsView itemsView;
    ItemController itemController;
    Movie movie;
    CustomersController customersController;


    @Before
    public void setup() {
        movie = new Movie(1, "The Schindler's List", 1994, "Steven Spielberg", 10);
        movies = new ArrayList<Item>();
        movies.add(movie);
        moviesModel = mock(Movies.class);
        itemsView = mock(ItemsView.class);
        customersController = mock(CustomersController.class);

        itemController = new ItemController(moviesModel, itemsView);
        when(moviesModel.getItems()).thenReturn(movies);
    }

    @Test
    public void shouldBeAbleToDisplayBooks() {
        doNothing().when(itemsView).displayItems(movies);

        itemController.displayItems();

        verify(itemsView).displayItems(movies);
    }

    @Test
    public void shouldBeAbleToDisplaySuccesMessageToUserOnSuccessfulCheckoutOfAMovie() {
        itemController.checkoutItem("movie");

        verify(itemsView).displayMessage("Thank you! Enjoy the movie! ");
    }

    @Test
    public void shouldBeAbleToWarnInvalidInputToUser() throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        when(itemsView.getItemNumber("Enter the number of the movie that you want to checkout")).thenReturn(100);
        when(moviesModel.checkoutItem(100)).thenThrow(new InvalidInputException());

        itemController.checkoutItem("movie");

        verify(itemsView).displayMessage("Please select a valid option! ");
    }

    @Test
    public void shouldBeAbleToWarnInvalidInputToUserIfMovieIsNotFound() throws NotFoundException, InvalidInputException, UserNotLoggedInException {
        when(itemsView.getItemNumber("Enter the number of the movie that you want to checkout")).thenReturn(100);
        when(moviesModel.checkoutItem(100)).thenThrow(new NotFoundException("Movie not found"));

        itemController.checkoutItem("movie");

        verify(itemsView).displayMessage("That movie is not available.");
    }

    @Test
    public void shouldBeAbleToGetMovieNumberForCheckoutAndReturn() {
        when(itemsView.getItemNumber("Enter the number of the movie you want to checkout. ")).thenReturn(1);

        int choice = itemController.getItemNumber("Enter the number of the movie you want to checkout. ");

        Assert.assertEquals(1, choice);
    }

    @Test
    public void shouldBeAbleToNotifyUserIfHeTriesToCheckoutWithoutLoggingIn() throws InvalidInputException, UserNotLoggedInException, NotFoundException {
        when(itemsView.getItemNumber("Enter the number of the movie that you want to checkout")).thenReturn(1);
        when(moviesModel.checkoutItem(1)).thenThrow(UserNotLoggedInException.class);

        itemController.checkoutItem("movie");

        verify(itemsView).displayMessage("You need to be logged in to checkout a movie");
    }

    @Test
    public void shouldBeAbleToNotifyUserIfHeTriesToReturnWithoutLoggingIn() throws InvalidInputException, UserNotLoggedInException, NotFoundException, BookAlreadyPresentException {
        when(itemsView.getItemNumber("Enter the number of the movie that you want to return")).thenReturn(1);
        doThrow(UserNotLoggedInException.class).when(moviesModel).returnItem(1);

        itemController.returnItem("movie");

        verify(itemsView).displayMessage("You need to be logged in to return a movie");
    }

}
