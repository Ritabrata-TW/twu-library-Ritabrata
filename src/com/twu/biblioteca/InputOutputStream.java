package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputOutputStream {
    private final Scanner scanner;
    private final PrintStream out;

    public InputOutputStream(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public void printLine(String message){
        out.print(message);
    }
}
