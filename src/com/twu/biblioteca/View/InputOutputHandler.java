package com.twu.biblioteca.View;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


//taking input and output from and to the user
public class InputOutputHandler {
    private PrintStream printStream;
    private final Scanner scanner;


    public InputOutputHandler(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        scanner = new Scanner(inputStream);
    }

    public void writeMessage(String message) {
        printStream.println(message);
    }

    public Integer input(String message) {
        printStream.println(message);
        return Integer.parseInt(scanner.nextLine());
    }
}
