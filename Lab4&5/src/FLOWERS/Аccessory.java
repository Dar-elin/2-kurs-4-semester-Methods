package FLOWERS;

import com.company.MyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Аccessory implements Serializable {
    private String name;
    private double price;

    public Аccessory(){}
    public Аccessory(String name, double price) {
        this.name = name;
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной!");
        }
        this.price = price;
    }

    public void SetАccessory(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите название аксессуара: ");
            String name = scanner.nextLine();
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Название не может быть пустым!");
            }
            this.name = name;
            System.out.print("Введите цену аксессуара (BYN): ");
            double price = scanner.nextDouble();
            if (price < 0) {
                throw new IllegalArgumentException("Цена не может быть отрицательной!");
            }
            this.price = price;
        } catch (IllegalArgumentException | NullPointerException e) {
            new MyException("Исключение! " + e.getMessage());
        }
    }

    public double getPrice() { return this.price;}
    public String getName() { return this.name;}

    public void setPrice( double price) { this.price=price; }
    public void setName( String name) { this.name=name; }
    public void Show(){
        System.out.print("\nНазвание: " + this.name + "\nЦена (BYN): " + this.price + "p.\n");
    }
}
