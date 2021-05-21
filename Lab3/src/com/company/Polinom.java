package com.company;

import java.util.Scanner;

//public class Polinom extends RationalFraction {
public class Polinom {
    // полином, представленный набором чисел (его степенью и коэффициентами при каждой степени (члене)
    private int degree; //степень полинома
    private int Coefficients[][];
    //public RationalFraction[] Coefficients;

    public Polinom() {
        this.degree = 0;
        this.Coefficients = new int [this.degree + 1][2];
        for (int i = 0; i <= this.degree; i++) {
            this.Coefficients[i][0] = 0; //числитель
            this.Coefficients[i][1] = 1; //знаменатель
        }
    }

    public void setDegree(int degree) {
        this.degree=degree;
    }


    /*public Polinom(int degree) {
        this.degree = degree;
        this.Coefficients = new RationalFraction[degree + 1]; /////////////
        for (int i = 0; i <= degree; i++) {
            this.Coefficients[i] = new RationalFraction();
            this.Coefficients[i].setRationalFraction();
        }
    }*/

    public Polinom(int degree) {
        this.degree = degree;
        this.Coefficients = new int [this.degree + 1][2];
        for (int i = 0; i <= this.degree; i++) {
            this.Coefficients[i][0] = 0; //числитель
            this.Coefficients[i][1] = 1; //знаменатель
        }
    }

    public int getDegree() {
        return this.degree;
    }

    /*public void setPolinom(int degree) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("Введите степень полинома: ");
        //int degree = scanner.nextInt();
        this.degree = degree;
        this.Coefficients = new RationalFraction[degree + 1];
        System.out.print("Введите коэффициенты в виде рациональной дроби для каждого члена полинома");
        for (int i = 0; i <= degree; i++) {
            System.out.print("\n"+i+"-ый коэффициент");
            this.Coefficients[i] = new RationalFraction();
            this.Coefficients[i].setRationalFraction();
        }
        scanner.close();
    }*/

    public void setPolinom(Scanner scanner, int degree) {
        this.degree = degree;
        this.Coefficients = new int [degree + 1][2];
        for (int i = 0; i <= degree; i++) {
            System.out.print("\n"+i+"-ый коэффициент");
            System.out.print("\nВведите числитель: ");
            int numerator = scanner.nextInt();
            this.Coefficients[i][0] = numerator; //числитель
            System.out.print("Введите знаменатель: ");
            int denominator = scanner.nextInt();
            this.Coefficients[i][1] = denominator; //знаменатель
        }
    }

    public void getPolinom() {
        System.out.print("\nСтепень полинома: " + this.degree);
        for (int i = 0; i <= degree; i++) {
            System.out.print("\nКоэффициент " + i + "-го члена полинома: ");
            if (this.Coefficients[i][0] == 0) System.out.print("0");
            else System.out.print(this.Coefficients[i][0] + "/"
                    + this.Coefficients[i][1]);
        }
    }

    /*public void Show() {
        System.out.println();
        if (this.Coefficients[0].getNumerator() != 0) System.out.print(+this.Coefficients[0].getNumerator() + "/"
                + this.Coefficients[0].getDenominator());
        if (this.degree != 0) for (int i = 1; i <= degree; i++) {
            System.out.print(" + ");
            if (this.Coefficients[i].getNumerator() == 0) System.out.print("0*x^" + i);
            else System.out.print("(" + this.Coefficients[i].getNumerator() + "/"
                    + this.Coefficients[i].getDenominator() + ")*x^" + i);
        }
    }*/

    public void Show() {
        System.out.println();
        if (this.Coefficients[0][0] != 0) System.out.print(+this.Coefficients[0][0] + "/"
                + this.Coefficients[0][1]);
        if (this.degree != 0) for (int i = 1; i <= degree; i++) {
            System.out.print(" + ");
            if (this.Coefficients[i][0] == this.Coefficients[i][1])
                System.out.print(this.Coefficients[i][0] + "*x^" + i);
            else System.out.print("(" + this.Coefficients[i][0] + "/"
                    + this.Coefficients[i][1] + ")*x^" + i);
        }
    }

    public Polinom[] objectArray(int n) {
        Polinom[] Array = new Polinom[n];
        for (int i = 0; i < n; i++) {
            Array[i] = new Polinom();
        }
        return Array;
    }

    /*public Polinom Addition(Polinom P1) {
        Polinom Result = new Polinom();
        int degree = (this.degree > P1.getDegree()) ? this.degree : P1.getDegree();
        for (int i = 0; i <= degree; i++) {
            Result.Coefficients[i] = this.Coefficients[i].Addition(P1.Coefficients[i]);
        }
        return Result;
    }*/

    public Polinom Addition(Polinom P0) {
        Polinom Result;
        if (this.degree > P0.getDegree()) {
            Result = new Polinom(this.degree);
            for (int i = 0; i <= P0.getDegree(); i++) {
                Result.Coefficients[i][0] = this.Coefficients[i][0] * P0.Coefficients[i][1] +
                        P0.Coefficients[i][0] * this.Coefficients[i][1];
                Result.Coefficients[i][1] = this.Coefficients[i][1] * P0.Coefficients[i][1];
                for (int j = Result.Coefficients[i][1]; j > 0; j--) {
                    if (Result.Coefficients[i][0] % j == 0 && Result.Coefficients[i][1] % j == 0) {
                        Result.Coefficients[i][0] /= j;
                        Result.Coefficients[i][1] /= j;
                    }
                }
            }
            for (int i = P0.getDegree() + 1; i <= this.degree; i++) {
                Result.Coefficients[i][0] = this.Coefficients[i][0];
                Result.Coefficients[i][1] = this.Coefficients[i][1];
            }
        }
        else{
            Result = new Polinom(P0.getDegree());
            for (int i = 0; i <= this.degree; i++) {
                Result.Coefficients[i][0] = this.Coefficients[i][0] * P0.Coefficients[i][1] +
                        P0.Coefficients[i][0] * this.Coefficients[i][1];
                Result.Coefficients[i][1] = this.Coefficients[i][1] * P0.Coefficients[i][1];
                for (int j = Result.Coefficients[i][1]; j > 0; j--) {
                    if (Result.Coefficients[i][0] % j == 0 && Result.Coefficients[i][1] % j == 0) {
                        Result.Coefficients[i][0] /= j;
                        Result.Coefficients[i][1] /= j;
                    }
                }
            }
            for (int i = this.degree + 1; i <= P0.getDegree(); i++) {
                Result.Coefficients[i][0] = P0.Coefficients[i][0];
                Result.Coefficients[i][1] = P0.Coefficients[i][1];
            }
        }
        return Result;
    }
}
