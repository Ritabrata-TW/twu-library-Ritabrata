package com.twu.biblioteca;

import com.twu.biblioteca.Model.Dependencies;
import com.twu.biblioteca.Model.Router;

// Run the biblioteca application
public class Application {
    public static void main(String[] args)  {
        Dependencies dependencies = Dependencies.init();
        Router router = new Router(dependencies);
        router.startApp();
    }


}

