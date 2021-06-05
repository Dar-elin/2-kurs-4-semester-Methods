package com.company;

public class Main {

    public static void main(String[] args) {
        Book encyclopedia=new Encyclopedia("Frogs",345,3);
        Book handbook=new Handbook("Flowers",456,"Biology");
        encyclopedia.getInformation();
        System.out.print("\n");
        handbook.getInformation();
        handbook.publish();
    }
}
