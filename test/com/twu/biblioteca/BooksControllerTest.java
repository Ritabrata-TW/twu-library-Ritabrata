package com.twu.biblioteca;

import com.twu.biblioteca.Controller.BooksController;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Books;
import com.twu.biblioteca.View.AppView;
import com.twu.biblioteca.View.BooksView;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class BooksControllerTest {
    ArrayList<Book> books;
    Books booksModel;
    BooksView booksView;
    BooksController booksController;
    Book book;
    AppView appView;


    @Before
    public void setup() {
        book = new Book(101, "Head First Design Pattern!", "Martin Fowler", 2007, false);
        books = new ArrayList<Book>(5);
        books.add(book);
        booksModel = new Books(books);
        booksView = mock(BooksView.class);
        appView = mock(AppView.class);
        booksController = new BooksController(booksModel, booksView, appView);
    }

    @Test
    public void shouldBeAbleToDisplayBooks() {
        doNothing().when(booksView).displayBooks(books);

        booksController.displayBooks();

        verify(booksView).displayBooks(books);
    }

    @Test
    public void shouldBeAbleToDisplaySuccesMessageToUserOnSuccessfulCheckout() {

        booksController.checkoutBook(101);

        verify(appView).displayMessage("Thank you! Enjoy the book! ");
    }

    @Test
    public void shouldBeAbleToDisplaySuccessMessageToUserOnSuccessfulReturn() {
        booksController.checkoutBook(101);
        booksController.returnBook(101);

        verify(appView).displayMessage("Thank you! Enjoy the book! ");
    }



}
