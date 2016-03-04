package com.twu.biblioteca;

import com.twu.biblioteca.Controller.Router;
import com.twu.biblioteca.Model.Dependencies;

// Run the biblioteca application
public class Application {
    public static void main(String[] args) {
        Dependencies dependencies = Dependencies.init();
        Router router = new Router(dependencies);
        router.startApp();
    }
}

