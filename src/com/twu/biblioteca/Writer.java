package com.twu.biblioteca;

import java.io.PrintStream;


//taking input and output from and to the user
public class Writer {
    private PrintStream stream;

    Writer(PrintStream stream) {
        this.stream = stream;
    }

    public void writeMessage(String message) {
        this.stream.println(message);
    }


}
