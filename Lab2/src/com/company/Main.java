package com.company;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 * @author Elinskaya D.O.
 */
public class Main {

    /**
     * @param args arguments of main().
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 1, если желаете выполнить задание А"
                + "\nВведите 2, если желаете выполнить задание С: ");
        int variant = scanner.nextInt();
        switch (variant) {
                case 1:
                    VariantA();
                    break;
                case 2:
                    VariantB();
                    break;
                default:
                    System.out.println("\nОшибка! Введите 1 или 2! ");
                        variant = scanner.nextInt();
                    break;
        }
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E dd.MM.yyyy HH:mm:ss");
        System.out.println("\nЕлинская Д.О.\nДата получения задания: сб 13.02.2021 9:45:00"
                + "\nДата сдачи задания: " + formatForDateNow.format(dateNow));
        scanner.close();
    }

    /**
     * Enter n numbers from the console.
     * Find the shortest and longest number.
     * Output the found numbers and their length.
     */
    public static void VariantA() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество целых  чисел: ");
        int n = scanner.nextInt();
        String[] Numbers = new String[n];
        System.out.print("Введите целые числа через пробел "
                + "и нажмите <Enter>: ");
        for (int i = 0; i < n; i++) {
            Numbers[i] = scanner.next();
            // Считаывание в Numbers[i] введенного с консоли числа
            // до первого пробела
        }
        findShortAndLongNumbers(Numbers);
        scanner.close();
    }

    /**
     * Finding the shortest and longest number of
     * @param Numbers String array of numbers
     */
    public static void findShortAndLongNumbers(String[] Numbers) {
        String min = Numbers[0];
        String max = "";
        for (int i = 0; i < Numbers.length; i++) {
            int length=Numbers[i].length();
            if (length > max.length()) max = Numbers[i];
            else if (length < min.length()) min = Numbers[i];
        }
        System.out.println("Самое короткое число:" + min
                + "\nЕго длина: " + min.length());
        System.out.println("Самое длинное число:" + max
                + "\nЕго длина: " + max.length());
    }

    /**
     * Enter the n-dimension of the matrix from the console.
     * Set the values of the matrix elements in the range of values from -n to n using a random number generator.
     * Sort the matrix according to the order of the values of the elements of the k-th column (row)
     */
    public static void VariantB() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность квадратной матрицы: ");
        int n = scanner.nextInt();
        System.out.print("Исходная матрица: \n");
        int[][] A = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = getRandom(-n, n);
                System.out.print(A[i][j] + "\t");
			}
            System.out.println();
		}
        System.out.print("Введите 1, если желаете выполнить сортировку по k-му столбцу"
                    + "\nВведите 2, если желаете выполнить сортировку по k-ой строке: ");
            int variant = scanner.nextInt();
        scanner.nextLine();
            switch (variant) {
                case 1:
                    SortColumn(A, n);
                    break;
                case 2:
                    SortRow(A, n);
                    break;
                default:
                    System.out.println("\nОшибка! Введите 1 или 2! ");
                    variant = scanner.nextInt();
                    break;
            }
		System.out.println("Упорядоченная матрица:\n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(A[i][j] + "\t");
			}
			System.out.println();
		}
        scanner.close();
    }

    /**
     * The function returns a random number from the specified range
     * @param min - included. min can be negative
     * @param max - included. max can be negative
     * @return random integer
     */
    public static int getRandom(int min, int max) {
        Random ran = new Random();
        int diapason = max - min + 1;
        int i = ran.nextInt() % diapason;
        if (i < 0)
            i = -i;
        return min + i;
    }

    /**
     * The function sorts the matrix according to the order of the values of the elements of the k-th column.
     * @param A  - the original square matrix
     * @param n - dimension of the matrix
     */
    public static void SortColumn(int[][] A, int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер столбца: ");
        int k = scanner.nextInt();
        for(int i=0; i<n-1; i++)
            for(int j=0; j<n-i-1; j++)
                if(A[j][k-1]>A[j+1][k-1])
                    for(int j1=0; j1<n; j1++)
                    {
                        int temp=A[j][j1];
                        A[j][j1]=A[j+1][j1];
                        A[j+1][j1]=temp;
                    }
        scanner.close();
    }

    /**
     * The function sorts the matrix according to the order of the values of the elements of the k-th row.
     * @param A  - the original square matrix
     * @param n - dimension of the matrix
     */
    public static void SortRow(int[][] A, int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер строки: ");
        int k = scanner.nextInt();
        for(int i=0; i<n-1; i++)
            for(int j=0; j<n-i-1; j++)
                if(A[k-1][j]>A[k-1][j+1])
                    for(int j1=0; j1<n; j1++)
                    {
                        int temp=A[j1][j];
                        A[j1][j]=A[j1][j+1];
                        A[j1][j+1]=temp;
                    }
        scanner.close();
    }
}