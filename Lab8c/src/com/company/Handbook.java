package com.company;

public class Handbook extends Book{
    private String nameOfSubject;

    public Handbook(String name, int pages, String nameOfSubject) {
        super(name, pages);
        this.nameOfSubject = nameOfSubject;
    }


    @Override
    public void getInformation() {
        super.getInformation();
        System.out.println("Name of subject " + nameOfSubject);
    }

}
