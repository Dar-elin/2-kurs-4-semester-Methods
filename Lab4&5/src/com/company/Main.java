package com.company;
import TEXT.Sentence;
import TEXT.Text;
import FLOWERS.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws MyException
    {
        try {
            Scanner scanner = new Scanner(System.in);
            char choice;
            char ch = '0';
            while (ch == '0') {
                System.out.print("Введите 1, если желаете выполнить задание А"
                        + "\nВведите 2, если желаете выполнить задание В: ");
                choice = scanner.next().charAt(0);
                switch (choice) {
                    case '1':
                        VariantA();
                        break;
                    case '2':
                        VariantB();
                        break;
                    default:
                        throw new IllegalArgumentException("\nОшибка! Введите 1 или 2! ");
                }
                System.out.print("\nЕсли вы желаете выполнить другое задание, нажмите 0, если нет, нажмите любую клавишу: ");
                ch = scanner.next().charAt(0);
            }
        } catch (IllegalArgumentException e){
            new MyException("Исключение! " + e.getMessage());
        }
    }

    private static void VariantA() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("D:\\Мехмат\\___ПРОГА\\Lab4&5\\src\\com\\company\\text.txt"))) {
            System.out.println("\nУспешное открытие файла.");
            Scanner scanner = new Scanner(System.in);
            String file = buffer.readLine(); // считываем первую строку = заголовок
            String title1=file;
            String text1="";
            file = buffer.readLine();
            while (file != null) {
                text1+=file;
                file = buffer.readLine(); // считываем остальные строки в цикле
            }
            Text text = new Text(title1,text1);
            char choice = '0';
            while (choice == '0') {
                System.out.print("\nВведите 1, если желаете дополнить текст"
                        + "\nВведите 2, если желаете изменить заголовок текста"
                        + "\nВведите 3, если желаете вывести на консоль заголовок текста"
                        + "\nВведите 4, если желаете вывести на консоль текст"
                        + "\nВведите 5, если желаете записать текст в файл"
                        + "\nВведите 6, если желаете выйти"
                        + "\nВводите здесь: ");
                char choice1 = scanner.next().charAt(0);
                switch (choice1) {
                    case '1':
                        System.out.print("\nВведите дополнение: ");
                        String add= scanner.next();
                        text.addText(add);
                        scanner.nextLine();
                        break;
                    case '2': //+
                        System.out.print("\nВведите новый заголовок: ");
                        String newTitle=scanner.next();
                        text.setTitle(newTitle);
                        break;
                    case '3': //+
                        System.out.print("Заголовок: " + text.getTitleString());
                        break;
                    case '4':
                        System.out.print(text.toString());
                        break;
                    case '5':
                        FileOutputStream fos = new FileOutputStream("D:\\Мехмат\\___ПРОГА\\Lab4&5\\src\\com\\company\\text1.txt");
                        PrintStream printStream = new PrintStream(fos);
                        printStream.println(text.toString());
                        System.out.println("Файл text1.txt создан. Файл записан.");
                        fos.close();
                        break;
                    case '6':
                        choice='1';
                        break;
                    default:
                        System.out.println("\nОшибка! Вы ввели неверное число!");
                        break;
                }
            }
        } catch (Exception e) {
            new MyException("Исключение! " + e.getMessage());
        }
    }

    private static void VariantB() {
        try {
            Scanner scanner = new Scanner(System.in);
            Bouquet bouquet = new Bouquet();
            char choice = '0';
            while (choice == '0') {
                System.out.print("\nВведите 1, если желаете собрать букет из цветов"
                        + "\nВведите 2, если желаете добавить аксессуары к букету"
                        + "\nВведите 3, если желаете добавить новый цветок к букету"
                        + "\nВведите 4, если желаете добавить новый аксессуар к букету"
                        + "\nВведите 5, если желаете вывести на консоль состав букета"
                        + "\nВведите 6, если желаете вывести на консоль стоимость букета"
                        + "\nВведите 7, если желаете найти цветы в букете, соответствующие заданному диапазону длин стеблей."
                        + "\nВведите 8, если желаете провести сортировку цветов в букете на основе уровня свежести"
                        + "\nВведите 9, если желаете выйти"
                        + "\nВводите здесь: ");
                char choice1 = scanner.next().charAt(0);
                switch (choice1) {
                    case '1':
                        for (Flower flower1 : setFlower("D:\\Мехмат\\___ПРОГА\\Lab4&5\\flowers.txt")){
                            bouquet.addFlower(flower1);
                        }
                        break;
                    case '2':
                        /*for (Flower flower1 : setFlower("D:\\Мехмат\\___ПРОГА\\Lab4&5(2)\\flowers.txt")){
                            bouquet.addFlower(flower1);
                        }*/
                        for (Аccessory accessory1 : setАccessory("D:\\Мехмат\\___ПРОГА\\Lab4&5\\accessories.txt")){
                            bouquet.addАccessory(accessory1);
                        }
                        break;
                    case '3':
                        Аccessory accessory = new Аccessory();
                        accessory.SetАccessory();
                        bouquet.addАccessory(accessory);
                        break;
                    case '4':
                        Flower flower = new Flower();
                        flower.SetFlower();
                        bouquet.addFlower(flower);
                        break;
                    case '5':
                        bouquet.Show();
                        break;
                    case '6':
                        System.out.print("\nСтоимость букета: " + bouquet.getPrice());
                        break;
                    case '7':
                        System.out.print("\nВведите нижнюю грань диапазона: ");
                        double from = scanner.nextDouble();
                        System.out.print("\nВведите верхнюю грань диапазона: ");
                        double to = scanner.nextDouble();
                        bouquet.findLengthOfStems(from,to).Show();
                        break;
                    case '8':
                        bouquet.sortFreshness();
                        System.out.print("\nОтсортированный букет: ");
                        bouquet.Show();
                        break;
                    case '9':
                        choice='1';
                        break;
                    default:
                        throw new IllegalArgumentException("\nОшибка! Вы ввели неверное число!");
                        //System.out.println("\nОшибка! Вы ввели неверное число!");
                }
            }
        } catch (Exception e) {
            new MyException("Исключение! " + e.getMessage());
        }
    }

    public static List<Flower> setFlower(String filename) {
        List<Flower> flowers = new ArrayList<Flower>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(filename))) {
            System.out.println("\nУспешное открытие файла.");
            String nameOfFlower = "",nameOfColor = "";
            int freshness = 0, i = 1;
            double priceOfFlower = 0, lengthOfFlowerStems = 0;
            Scanner scanner = new Scanner(System.in);
            String line = buffer.readLine();
            while (line != null) {
                nameOfFlower = line;
                line = buffer.readLine();
                try {
                    priceOfFlower = Double.parseDouble(line.trim());
                } catch (NumberFormatException exception) {
                    System.out.println("Неверный формат числа!" + exception.getMessage());
                }
                line = buffer.readLine();
                nameOfColor = line;
                line = buffer.readLine();
                try {
                    freshness = Integer.parseInt(line.trim());
                } catch (NumberFormatException exception) {
                    System.out.println("Неверный формат числа!" + exception.getMessage());
                }
                line = buffer.readLine();
                try {
                    lengthOfFlowerStems = Double.parseDouble(line.trim());
                } catch (NumberFormatException exception) {
                    System.out.println("Неверный формат числа!" + exception.getMessage());
                }
                line = buffer.readLine();
                line = buffer.readLine();
                Flower flower = new Flower(nameOfFlower,priceOfFlower, nameOfColor, freshness, lengthOfFlowerStems);
                flowers.add(flower);
            }
        } catch (FileNotFoundException e) {
            new MyException("Исключение! " + e.getMessage());
        } catch (IOException e) {
            new MyException("Исключение! " + e.getMessage());
        }
        return flowers;
    }
    public static List<Аccessory> setАccessory (String filename) {
        List<Аccessory> accessories = new ArrayList<Аccessory>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(filename))) {
            System.out.println("\nУспешное открытие файла.");
            String nameOfАccessory = "";
            double priceOfАccessory = 0;
            Scanner scanner = new Scanner(System.in);
            String line = buffer.readLine();
            while (line != null) {
                nameOfАccessory = line;
                line = buffer.readLine();
                try {
                    priceOfАccessory = Double.parseDouble(line.trim());
                } catch (NumberFormatException exception) {
                    System.out.println("Неверный формат числа!" + exception.getMessage());
                }
                line = buffer.readLine();
                line = buffer.readLine();
                Аccessory accessory = new Аccessory(nameOfАccessory,priceOfАccessory);
                accessories.add(accessory);
            }
        } catch (FileNotFoundException e) {
            new MyException("Исключение! " + e.getMessage());
        } catch (IOException e) {
            new MyException("Исключение! " + e.getMessage());
        }
        return accessories;
    }
}