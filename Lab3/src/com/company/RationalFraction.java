package com.company;

import java.util.Scanner;

public class RationalFraction {
    //рациональная дробь, представленная парой чисел (числитель и знаменатель)
    private int numerator;
    private int denominator;

    public RationalFraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public RationalFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void setRationalFraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите числитель: ");
        int numerator = scanner.nextInt();
        this.numerator = numerator;
        System.out.print("\nВведите знаменатель: ");
        int denominator = scanner.nextInt();
        this.denominator = denominator;
        scanner.close();
    }

    public void getRationalFraction() {
        System.out.print("\nЧислитель: " + this.numerator +
                "\nЗнаменатель: " + this.denominator);
    }

    public void Show() {
        System.out.println();
        System.out.printf("%15d", this.numerator);
        System.out.printf("%15d", this.denominator);
    }

    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public RationalFraction[] objectArray(int number) {
        RationalFraction[] Array = new RationalFraction[number];
        for (int i = 0; i < number; i++) {
            Array[i] = new RationalFraction();
        }
        return Array;
    }

    public String ToString() {
        return "Числитель: " + this.numerator +
                "\nЗнаменатель: " + this.denominator;
    }

    public RationalFraction Addition(RationalFraction Number) {
        RationalFraction Result = new RationalFraction();
        Result.numerator = this.numerator * Number.denominator +
                Number.numerator * this.denominator;
        Result.denominator = this.denominator * Number.denominator;
        return Result;
    }

    public RationalFraction Subtraction(RationalFraction Number) {
        RationalFraction Result = new RationalFraction();
        Result.numerator = this.numerator * Number.denominator -
                Number.numerator * this.denominator;
        Result.denominator = this.denominator * Number.denominator;
        return Result;
    }

    public RationalFraction Multiplication(RationalFraction Number) {
        RationalFraction Result = new RationalFraction();
        Result.numerator = this.numerator * Number.numerator;
        Result.denominator = this.denominator * Number.denominator;
        return Result;
    }

    public RationalFraction Division(RationalFraction Number) {
        RationalFraction Result = new RationalFraction();
        Result.numerator = this.numerator * Number.denominator;
        Result.denominator = this.denominator * Number.numerator;
        return Result;
    }

    public RationalFraction Reduction() {
        RationalFraction Result = new RationalFraction();
        for (int i = this.denominator; i > 0; ) {
            if (this.numerator % i == 0) this.numerator /= i;
            else i--;
        }
        return Result;
    }

    //modifies each element of the array with an even index
    // by adding the next element after it
    public void Change(RationalFraction[] Array) {
        for (int i = 0; i < Array.length; i++) {
            if (i % 2 == 0) Array[i].Addition(Array[i + 1]);
        }
    }
}
