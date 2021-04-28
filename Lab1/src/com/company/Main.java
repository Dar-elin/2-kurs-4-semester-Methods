package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество целых  чисел: ");
        int n = scanner.nextInt();
        int[] Numbers = new int[n];
        System.out.print("Введите целые числа через пробел "
                + "и нажмите <Enter>: ");
        for (int i = 0; i < n; i++) {
            Numbers[i] = scanner.nextInt();
        }
        findEvenAndOddNumbers(Numbers);
        scanner.close();
    }

    private static void findEvenAndOddNumbers(int[] Numbers) {
        int[] Evens = new int[Numbers.length];
        int[] Odds = new int[Numbers.length];
        for (int i = 0; i < Numbers.length; i++) {
            if (Numbers[i] % 2 == 0) {
                Evens[i] = Numbers[i];
            }
            else {
                Odds[i] = Numbers[i];
            }
        }
        System.out.println("Чётные числа:");
        for (int i = 0; i < Numbers.length; i++) {
            if (Evens[i] != 0)
            System.out.print(Evens[i] + " ");
        }
        System.out.println("\nНечётные числа:");
        for (int i = 0; i < Numbers.length; i++) {
            if (Odds[i] != 0)
            System.out.print(Odds[i] + " ");
        }
    }
}
