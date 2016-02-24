package com.twu.biblioteca;

// Run the biblioteca application
public class Application {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(new InputOutputHandler(System.out, System.in));
        biblioteca.addBooks();
        biblioteca.welcome();
        biblioteca.mainMenu();
    }
}
