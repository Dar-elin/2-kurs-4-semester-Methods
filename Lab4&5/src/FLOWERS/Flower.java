package FLOWERS;
import com.company.MyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Flower implements Serializable {
    private String name;
    private double price;
    private String color;
    private int freshInHours; // уровень свежести измеряется в часах
    private double lengthOfStems;

    public Flower(){}
    public Flower(String name, double price, String color, int freshInHours, double lengthOfStems) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }
        this.name = name;
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной!");
        }
        this.price = price;
        if (color == null) {
            throw new NullPointerException("Цвет не может отсутсвовать!");
        }
        this.color = color;
        if (freshInHours < 0) {
            throw new IllegalArgumentException("Количество часов не может быть отрицтельным!");
        }
        this.freshInHours = freshInHours;
        if (lengthOfStems < 0) {
            throw new IllegalArgumentException("Длина не может быть отрицательной!");
        }
        this.lengthOfStems = lengthOfStems;
    }

    public void SetFlower(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите название цветка: ");
            String name = scanner.nextLine();
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Название не может быть пустым!");
            }
            this.name = name;
            System.out.print("Введите цену цветка (BYN): ");
            double price = scanner.nextDouble();
            if (price < 0) {
                throw new IllegalArgumentException("Цена не может быть отрицательной!");
            }
            this.price = price;
            System.out.print("Введите цвет цветка: ");
            String color = scanner.nextLine();
            if (color == null) {
                throw new NullPointerException("Цвет не может отсутсвовать!");
            }
            this.color = color;
            System.out.print("Введите свежесть цветка цветка (часов): ");
            int freshInHours = scanner.nextInt();
            if (freshInHours < 0) {
                throw new IllegalArgumentException("Количество часов не может быть отрицтельным!");
            }
            this.freshInHours = freshInHours;
            System.out.print("Введите длину стеблей цветка (см): ");
            double lengthOfStems = scanner.nextDouble();
            if (lengthOfStems < 0) {
                throw new IllegalArgumentException("Длина не может быть отрицательной!");
            }
            this.lengthOfStems = lengthOfStems;
        } catch (IllegalArgumentException | NullPointerException e) {
            new MyException("Исключение! " + e.getMessage());
        }
    }

    public double getPrice() { return this.price;}
    public String getName() { return this.name;}
    public String getColor() { return this.color;}
    public int getFreshInHours()  { return this.freshInHours;}
    public double getLengthOfStems() { return this.lengthOfStems;}

    public void setPrice( double price) { this.price=price; }
    public void setName( String name) { this.name=name; }
    public void setColor( String color) { this.color=color; }
    public void setFreshInHours( int freshInHours) { this.freshInHours=freshInHours; }
    public void setLengthOfStems( double lengthOfStems) { this.lengthOfStems=lengthOfStems; }
    public void Show(){
        System.out.print("\nНазвание: " + this.name + "\nЦена (BYN): " + this.price + "p." +
                "\nЦвет: " + this.color + "\nСвежесть: " + this.freshInHours +
                " час(-ов) \nДлина стебля: " + this.lengthOfStems + "см\n");
    }
}
