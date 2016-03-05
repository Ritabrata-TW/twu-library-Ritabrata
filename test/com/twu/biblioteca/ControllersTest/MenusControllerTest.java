package com.twu.biblioteca.ControllersTest;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Controller.ItemController;
import com.twu.biblioteca.Controller.MenusController;
import com.twu.biblioteca.Model.Menus;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.InputOutputHandler;
import com.twu.biblioteca.View.MenuView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class MenusControllerTest {
    MenuView menuView;
    InputOutputHandler inputOutputHandler;
    ArrayList<Book> books;
    Menus menuModel;
    MenusController menuController;
    ItemController itemController;
    ArrayList<String> options;
    AppView appView;

    @Before
    public void setup() {
        menuModel = mock(Menus.class);
        itemController = mock(ItemController.class);
        inputOutputHandler = mock(InputOutputHandler.class);

        menuView = mock(MenuView.class);
        books = new ArrayList<Book>(5);
        books.add(new Book(101, "Head First Design Pattern!", "Martin Fowler", 2007, false, null));

        appView = mock(AppView.class);
        menuController = new MenusController(menuModel, menuView, appView);
        options = new ArrayList<String>();
        options.add("1. List Books");
    }


    @Test
    public void shouldBeAbleToWelcomeUser() {
        doNothing().when(menuView).welcome();

        menuController.welcome();

        verify(menuView).welcome();
    }

    @Test
    public void shouldBeAbleToDisplayGenericMessageThroughAppView() {
        menuController.displayMessage("Hi there");

        verify(appView).displayMessage("Hi there");
    }

    @Test
    public void shouldBeAbleToTakeInputFromMainMenu() {
        when(menuModel.getOptions()).thenReturn(options);
        when(menuView.displayMenuOptions(options)).thenReturn(1);
        when(menuModel.validateChoice(1)).thenReturn(1);

        int input = menuController.mainMenu();

        Assert.assertEquals(1, input);
    }


}
