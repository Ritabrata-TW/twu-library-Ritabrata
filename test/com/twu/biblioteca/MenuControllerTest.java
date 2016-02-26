package com.twu.biblioteca;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Controller.MenuController;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.BooksModel;
import com.twu.biblioteca.View.InputOutputHandler;
import com.twu.biblioteca.View.MenuView;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuControllerTest {
    MenuView menuView;
    InputOutputHandler inputOutputHandler;
    ArrayList<Book> books;
    MenuController menuController;
    BooksModel booksModel;


    @Before
    public void setup() {
        booksModel = mock(BooksModel.class);
        inputOutputHandler = mock(InputOutputHandler.class);
        menuView = mock(MenuView.class);
        menuController = new MenuController(menuView,booksModel);
        books = new ArrayList<Book>(5);
        books.add(new Book("Head First Design Pattern!", "Martin Fowler", 2007));
    }

    @Test
    public void shouldBeAbleToDisplayBookListForTheUserWhenHeChoosesOneOnMainMenu()  {
        when(menuView.mainMenu()).thenReturn(1);
        when(booksModel.getBooks()).thenReturn(books);

        menuController.mainMenu();

        verify(menuView).displayBooks(books);
    }


    @Test
    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNumericInvalidMenuOptionInMainMenuOption() {
        when(menuView.mainMenu()).thenReturn(2);

        menuController.mainMenu();

        verify(menuView).displayMessage("Select a valid option!");
    }

    @Test
    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNonNumericInvalidMenuOptionInMainMenuOption() {
        when(menuView.mainMenu()).thenReturn(0);

        menuController.mainMenu();

        verify(menuView).displayMessage("Select a valid option!");
    }
}
