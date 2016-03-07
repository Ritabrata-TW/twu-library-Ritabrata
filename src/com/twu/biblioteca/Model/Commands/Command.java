package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Model.Result;

public interface Command {
    Result execute();

    Integer code();
}
