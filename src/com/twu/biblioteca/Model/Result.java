package com.twu.biblioteca.Model;

public class Result {
    boolean shouldTerminateLoop;

    public Result(boolean shouldTerminateLoop) {
        this.shouldTerminateLoop = shouldTerminateLoop;
    }

    public boolean ShouldTerminateLoop() {
        return shouldTerminateLoop;
    }
}
