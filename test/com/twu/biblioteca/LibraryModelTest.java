package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


//Test for LibraryModel App
public class LibraryModelTest {
    InputOutputHandler inputOutputHandler;
    LibraryView libraryView;
    LibraryModel libraryModel;
    LibraryController libraryController;

    @Before
    public void setup () {
        inputOutputHandler = mock(InputOutputHandler.class);
        libraryModel = new LibraryModel();
        libraryView = new LibraryView(libraryModel, inputOutputHandler);
        libraryController = new LibraryController(libraryModel, libraryView, inputOutputHandler);
    }

    @Test
    public void WelcomeMessageMustBeDisplayedForTheUser() {
        libraryView.welcome();

        verify(inputOutputHandler).writeMessage("**** Welcome Customer! We are glad to have you at LibraryModel! ****");
    }

    @Test
    public void BookListMustBeDisplayedForTheUser() {
        libraryModel.addBooks();
        doNothing().when(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");

        libraryView.displayBooks();

        verify(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");
    }

    @Test
    public void MainMenuMustBeDisplayed() {
        libraryView.mainMenu();

        verify(inputOutputHandler).writeMessage("/n Main Menu");
        verify(inputOutputHandler).writeMessage("1. List Books");
    }

    @Test
    public void shouldBeAbleToTakeInputFromAMainMenu() {
        libraryView.mainMenu();

        verify(inputOutputHandler).input("Enter your choice!");
    }

    @Test
    public void shouldBeAbleToDisplayBookListForTheUserWhenHeChoosesOneOnMainMenu() {
        libraryModel.addBooks();
        doNothing().when(inputOutputHandler).writeMessage("/n Main Menu");
        doNothing().when(inputOutputHandler).writeMessage("1. List Books");
        when(inputOutputHandler.input("Enter your choice!")).thenReturn(1);

        libraryView.mainMenu();


        verify(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");
    }


}




