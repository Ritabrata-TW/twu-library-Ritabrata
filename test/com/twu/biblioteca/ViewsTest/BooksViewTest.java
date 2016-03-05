package com.twu.biblioteca.ViewsTest;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.View.InputOutputHandler;
import com.twu.biblioteca.View.ItemsView;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BooksViewTest {
    InputOutputHandler inputOutputHandler;
    ItemsView itemsView;
    List<Item> books;
    Book headFirstDesignPattern;
    Book headFirstJava;
    Book ImperialC;


    @Before
    public void setup() {
        books = new ArrayList<Item>(5);
        headFirstDesignPattern = new Book(100, "Head First Design Pattern!", "Martin Fowler", 2007);
        headFirstJava = new Book(101, "Head First Java", "Martin Fowler", 2010);
        books.add(headFirstDesignPattern);
        books.add(headFirstJava);
        inputOutputHandler = mock(InputOutputHandler.class);
        itemsView = new ItemsView(inputOutputHandler);
    }

    @Test
    public void PresentBookListMustBeDisplayedForTheUser() {
        doNothing().when(inputOutputHandler).writeMessage("Head First Design Pattern! Martin Fowler 2007");

        itemsView.displayItems(books);

        verify(inputOutputHandler).writeMessage("100 Head First Design Pattern! Martin Fowler 2007");
    }

//    @Test
//    public void checkedOutBooksShouldNotBeDisplayedToTheUser() {
//        ImperialC = new Book(102, "Imperial C", "Dennis Ritchie", 1945);
//        books.add(ImperialC);
//
//        itemsView.displayItems(books);
//
//        verify(inputOutputHandler, times(0)).writeMessage("102 Imperial C Dennis Ritchie 1945");
//    }
}
