package com.twu.biblioteca.Model;

import java.util.List;

//Welcome User, Display Main menu
public class BooksModel {
    String welcomeMessage;
    List<Book> books;

    public BooksModel(List<Book> books) {
        welcomeMessage = "**** Welcome Customer! We are glad to have you at BooksModel! ****";
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book checkoutBook(String bookName) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getName().equals(bookName) && !book.checkoutStatus()) {
                book.checkout();
                return book;
            }

        }
        throw new BookNotFoundException("This book doesn't exist in the records");
    }

    public void returnBook(String bookName) throws BookAlreadyPresentException {
        for (Book book : books) {
            if (book.getName().equals(bookName) && book.checkoutStatus()) {
                book.returnBook();
                return;
            }

        }
        throw new BookAlreadyPresentException("That is not a valid book to return.");
    }
}
