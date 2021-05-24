package com.company;
import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<String> numbers = getRandomStringListOfNum(10,100);
        System.out.print("\nИсходные числа:\n" + numbers);
        Path FilePath1 = Paths.get("D:\\Мехмат\\___ПРОГА\\Lab6c\\src\\com\\company\\Source.txt");
        fileWrite(numbers,FilePath1);
        System.out.print("\nИсходные числа записаны в файл");
        Path FilePath2 = Paths.get("D:\\Мехмат\\___ПРОГА\\Lab6c\\src\\com\\company\\result.txt");
        //getSortedNum(FilePath1, FilePath2);
        System.out.print("\nОтсортированные по возрастанию числа:\n" + getSortedNum(numbers));
        fileWrite(getSortedNum(numbers),FilePath2);
        System.out.print("\nОтсортированные числа записаны в файл");
    }

    public static void fileWrite(List<String> numbers, Path randomNumPath) {
        try {
            Files.write(randomNumPath, numbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getRandomStringListOfNum(int amountOfNumbers, int boundOfRandomizing) {
        Random random = new Random();
        List<String> randomNum = new ArrayList<>(amountOfNumbers);
        for (int i = 0; i < amountOfNumbers; i++) {
            randomNum.add(String.valueOf(random.nextInt(boundOfRandomizing)));
        }
        return randomNum;
    }

    public static List<String> getSortedNum(List<String> randomNum) {
        randomNum.sort(Comparator.comparing(Integer::valueOf));
        return randomNum;
    }
}
