package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> listOfStrings = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("D:\\Мехмат\\___ПРОГА\\Lab10a\\src\\com\\company\\Input.txt"));
             FileWriter writer = new FileWriter(new File("D:\\Мехмат\\___ПРОГА\\Lab10a\\src\\com\\company\\Output.txt"))) {
            System.out.print("Чтение данных из файла.");
            while (scanner.hasNextLine()) {
                listOfStrings.add(scanner.nextLine());
            }
            int sizeOfStack = listOfStrings.size();
            Collections.reverse(listOfStrings);
            System.out.print("\nЗапись данных в файл.");
            for (int i = 0; i < sizeOfStack; i++) {
                writer.write(listOfStrings.remove(0) + "\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
