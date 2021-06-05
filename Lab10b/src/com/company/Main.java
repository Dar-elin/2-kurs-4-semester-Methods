package com.company;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
            arrayList.add(i);

        long endTime = System.currentTimeMillis();
        System.out.println("Array List Creation: "+(float)(endTime - startTime)/1000);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
            linkedList.add(i);

        endTime = System.currentTimeMillis();
        System.out.println("Linked List Creation: "+(float)(endTime - startTime)/1000);

        startTime = System.currentTimeMillis();
        Linked(linkedList);
        endTime = System.currentTimeMillis();
        System.out.println("Linked List: "+(float)(endTime - startTime)/1000);

        startTime = System.currentTimeMillis();
        Arr(arrayList);
        endTime = System.currentTimeMillis();
        System.out.println("Array List: "+(float)(endTime - startTime)/1000);

        /* LinkedList с данной задачей справляется быстрей,
        т.к. для удаления элемента достаточно поменять ссылки его соседей,
        а для ArrayList необходимо \"пробежать\" весь список целиком */
    }

    static void Linked(LinkedList<Integer> l) {
        int i = 0;
        do {
            if ((i % 2 == 0) && (i != 0) && i < l.size()) {
                l.remove(i);
            }
            if(l.size() == 2) {
                l.remove(1);
                return;
            }
            i++;
        } while (i <= l.size());
        Linked(l);
    }

    static void Arr(ArrayList<Integer> l) {
        int i = 0;
        do {
            if ((i % 2 == 0) && (i != 0) && i < l.size()) {
                l.remove(i);
            }
            if(l.size() == 2) {
                l.remove(1);
                return;
            }
            i++;
        } while (i <= l.size());
        Arr(l);
    }
}

