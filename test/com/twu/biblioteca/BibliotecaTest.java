package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


//Test for Biblioteca App
public class BibliotecaTest {
    InputOutputHandler inputOutputHandler;
    Biblioteca bibliotecaApp;

    @Before
    public void setup () {
        inputOutputHandler = mock(InputOutputHandler.class);
        bibliotecaApp = new Biblioteca(inputOutputHandler);
    }

    @Test
    public void WelcomeMessageMustBeDisplayedForTheUser() {
        bibliotecaApp.welcome();

        verify(inputOutputHandler).writeMessage("**** Welcome Customer! We are glad to have you at Biblioteca! ****");
    }

    @Test
    public void BookListMustBeDisplayedForTheUser() {
        bibliotecaApp.addBooks();
        doNothing().when(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");

        bibliotecaApp.displayBooks();

        verify(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");
    }

    @Test
    public void MainMenuMustBeDisplayed() {
        bibliotecaApp.mainMenu();

        verify(inputOutputHandler).writeMessage("/n Main Menu");
        verify(inputOutputHandler).writeMessage("1. List Books");
    }

    @Test
    public void shouldBeAbleToTakeInputFromAMainMenu() {
        bibliotecaApp.mainMenu();

        verify(inputOutputHandler).input("Enter your choice!");
    }

    @Test
    public void shouldBeAbleToDisplayBookListForTheUserWhenHeChoosesOneOnMainMenu() {
        bibliotecaApp.addBooks();
        doNothing().when(inputOutputHandler).writeMessage("/n Main Menu");
        doNothing().when(inputOutputHandler).writeMessage("1. List Books");
        when(inputOutputHandler.input("Enter your choice!")).thenReturn(1);

        bibliotecaApp.mainMenu();


        verify(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");
    }


}




