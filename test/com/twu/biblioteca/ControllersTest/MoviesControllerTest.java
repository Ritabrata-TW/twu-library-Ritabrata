package com.twu.biblioteca.ControllersTest;

import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Model.Exceptions.InvalidInputException;
import com.twu.biblioteca.Model.Exceptions.NotFoundException;
import com.twu.biblioteca.Model.Movies;
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
    AppView appView;


    @Before
    public void setup() {
        movie = new Movie(1, "The Schindler's List", 1994, "Steven Spielberg", 10, false);
        movies = new ArrayList<Item>();
        movies.add(movie);
        moviesModel = mock(Movies.class);
        itemsView = mock(ItemsView.class);
        appView = mock(AppView.class);
        itemController = new ItemController(moviesModel, itemsView, appView);
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
        itemController.checkoutItem();

        verify(appView).displayMessage("Thank you! Enjoy! ");
    }

    @Test
    public void shouldBeAbleToWarnInvalidInputToUser() throws NotFoundException, InvalidInputException {
        when(itemsView.getItemNumber("Enter the number of the item that you want to checkout")).thenReturn(100);
        when(moviesModel.checkoutItem(100)).thenThrow(new InvalidInputException());

        itemController.checkoutItem();

        verify(appView).displayMessage("Please select a valid option! ");
    }

    @Test
    public void shouldBeAbleToWarnInvalidInputToUserIfMovieIsNotFound() throws NotFoundException, InvalidInputException {
        when(itemsView.getItemNumber("Enter the number of the item that you want to checkout")).thenReturn(100);
        when(moviesModel.checkoutItem(100)).thenThrow(new NotFoundException("Movie not found"));

        itemController.checkoutItem();

        verify(appView).displayMessage("That item is not available.");
    }

    @Test
    public void shouldBeAbleToGetMovieNumberForCheckoutAndReturn() {
        when(itemsView.getItemNumber("Enter the number of the book you want to checkout. ")).thenReturn(1);

        int choice = itemController.getItemNumber("Enter the number of the book you want to checkout. ");

        Assert.assertEquals(1, choice);


    }

}