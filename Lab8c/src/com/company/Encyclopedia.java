package com.company;

public class Encyclopedia extends Book{
    private int numberOfAuthors;

    public Encyclopedia(String name, int pages, int numberOfAuthors) {
        super(name, pages);
        this.numberOfAuthors = numberOfAuthors;
    }

    @Override
    public void getInformation() {
        super.getInformation();
        System.out.println("Number of authors " + numberOfAuthors);
    }
}
