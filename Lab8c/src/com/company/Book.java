package com.company;

public abstract class Book implements Publisher {
    private String name;
    private int pages;

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public void getInformation(){
        System.out.println("Name of the book " + name + " \nnumber of pages " + pages);
    }
}
