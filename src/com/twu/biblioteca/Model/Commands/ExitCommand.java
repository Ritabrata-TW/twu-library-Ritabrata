package com.twu.biblioteca.Model.Commands;

import com.twu.biblioteca.Model.Result;

public class ExitCommand implements Command {

    @Override
    public Result execute() {
        return new Result(true);
    }

    @Override
    public Integer code() {
        return 0;
    }
}
