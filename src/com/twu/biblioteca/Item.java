package com.twu.biblioteca;

public interface Item {
    boolean checkoutStatus();

    void checkout(String libraryNumber);

    Integer getNumber();

    void returnItem();

    String getCheckedOutBy();
}
