package com.twu.biblioteca;

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

        menuController.mainMenu();

        verify(menuView).displayBooks(books);
    }

//
//    @Test
//    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNumericInvalidMenuOptionInMainMenuOption() {
//        when(booksView.mainMenu()).thenReturn(2);
//
//        booksController.mainMenu();
//
//        verify(booksView).displayMessage("Select a valid option!");
//    }
//
//    @Test
//    public void ShouldBeAbleToDisplayInvalidOptionWhenUserEntersNonNumericInvalidMenuOptionInMainMenuOption() {
//        when(booksView.mainMenu()).thenReturn(0);
//
//        booksController.mainMenu();
//
//        verify(booksView).displayMessage("Select a valid option!");
//    }
}
