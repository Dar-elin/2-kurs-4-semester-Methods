package com.company;

public interface Publisher {
    default void publish(){
        System.out.println("Publish book");
    }
}
