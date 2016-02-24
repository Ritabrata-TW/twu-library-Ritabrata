package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BibliotecaApp {
    InputOutputStream inputOutputStream;

    BibliotecaApp(InputOutputStream inputOutputStream) {
        this.inputOutputStream = inputOutputStream;
    }

    public static void main(String[] args) {
        //welcome("Welcome To Biblioteca!");
    }

    public void welcome(String message){
        inputOutputStream.printLine(message);
    }
}
