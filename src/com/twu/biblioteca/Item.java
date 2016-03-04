package com.twu.biblioteca;

public interface Item {
    boolean checkoutStatus();
    void checkout();
    Integer getNumber();
}
