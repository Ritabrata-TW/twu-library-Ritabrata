package com.twu.biblioteca;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Controller.MenuController;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.MenuModel;
import com.twu.biblioteca.View.InputOutputHandler;
import com.twu.biblioteca.View.MenuView;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class MenuControllerTest {
    MenuView menuView;
    InputOutputHandler inputOutputHandler;
    ArrayList<Book> books;
    MenuModel menuModel;
    MenuController menuController;
    BooksController booksController;
    ArrayList<String> options;

    @Before
    public void setup() {
        menuModel = mock(MenuModel.class);
        booksController = mock(BooksController.class);
        inputOutputHandler = mock(InputOutputHandler.class);
        menuView = mock(MenuView.class);
        books = new ArrayList<Book>(5);
        books.add(new Book("Head First Design Pattern!", "Martin Fowler", 2007));
        menuController = new MenuController(menuModel, menuView);
        options = new ArrayList<String>();
        options.add("1. List Books");
    }

    @Test
    public void shouldBeAbleToDisplayBookListForTheUserWhenHeChoosesOneOnMainMenu() {
        when(menuModel.getOptions()).thenReturn(options);
        when(menuView.displayMenuOptions(options)).thenReturn(1);
        doNothing().when(booksController).displayBooks();

        menuController.mainMenu();

        verify(booksController).displayBooks();
    }


    @Test
    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNumericInvalidMenuOptionInMainMenuOption() {
        when(menuView.displayMenuOptions(options)).thenReturn(2);

        menuController.mainMenu();

        verify(menuView).displayMessage("Select a valid option!");
    }

    @Test
    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNonNumericInvalidMenuOptionInMainMenuOption() {
        when(menuView.displayMenuOptions(options)).thenReturn(0);

        menuController.mainMenu();

        verify(menuView).displayMessage("Select a valid option!");
    }
}
