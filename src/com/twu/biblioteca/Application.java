package com.twu.biblioteca;

public class Application {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(new Writer(System.out));
        biblioteca.addBooks();
        biblioteca.welcome();
        biblioteca.mainMenu();
        biblioteca.displayBooks();
    }
}
