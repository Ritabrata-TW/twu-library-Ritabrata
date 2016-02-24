package com.twu.biblioteca;

public class BibliotecaApp {
    Writer inputOutputStream;
    String welcomeMessage = "**** Welcome Customer! We are glad to have you at Biblioteca! ****";

    BibliotecaApp(Writer inputOutputStream) {
        this.inputOutputStream = inputOutputStream;
    }

    public static void main(String[] args) {
        //welcome("Welcome To Biblioteca!");
    }

    public void welcome(){
        inputOutputStream.write(welcomeMessage);
    }
}
