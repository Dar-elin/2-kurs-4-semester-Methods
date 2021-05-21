package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите 1, если желаете выполнить задание А"
                    + "\nВведите 2, если желаете выполнить задание В"
                    + "\nВведите 3, если желаете выполнить задание С: ");
            int variant = scanner.nextInt();
            switch (variant) {
                case 1:
                    VariantA();
                    break;
                case 2:
                    VariantB();
                    break;
                case 3:
                    VariantC();
                    break;
                default:
                    System.out.println("\nОшибка! Введите 1 или 2! ");
                    variant = scanner.nextInt();
                    break;
            }
            scanner.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void VariantA() {
        Scanner scanner = new Scanner(System.in);
        try {
            boolean bool=true;
                System.out.print("Введите колличество студентов: ");
                int n = scanner.nextInt();
                Student[] Spis = new Student[n];
                for (int i = 0; i < n; i++) {
                    Spis[i] = new Student();
                    Spis[i].setStudent();
                }
            while (bool) {
                System.out.print("\nВведите 1, если желаете вывести список студентов факультета"
                        + "\nВведите 2, если желаете вывести список студентов факультета и курса"
                        + "\nВведите 3, если желаете вывести список студентов, родившихся после заданного года"
                        + "\nВведите 4, если желаете вывести список учебной группы"
                        + "\nЧтобы выйти, введите что-нибудь другое! "
                        + "\nВводите здесь: ");
                scanner.nextLine();
                String variant = scanner.nextLine();
                switch (variant) {
                    case "1":
                        System.out.print("Введите название факультета: ");
                        String faculty1 = scanner.next();
                        System.out.printf("%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s", "Фамилия", "Имя"
                                , "Отчество", "День", "Месяц", "Год", "Адрес", "Телефон", "Факультет", "Курс", "Группа");
                        for (int i = 0; i < n; i++) {
                            if (faculty1.equals(Spis[i].getFaculty())) {
                                Spis[i].Show();
                            }
                        }
                        break;
                    case "2":
                        System.out.print("Введите название факультета: ");
                        String faculty2 = scanner.next();
                        System.out.print("Введите номер курса: ");
                        int kurs2 = scanner.nextInt();
                        System.out.printf("%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s", "Фамилия", "Имя"
                                , "Отчество", "День", "Месяц", "Год", "Адрес", "Телефон", "Факультет", "Курс", "Группа");
                        for (int i = 0; i < n; i++) {
                            if (faculty2.equals(Spis[i].getFaculty()) && kurs2 == Spis[i].getKurs()) {
                                Spis[i].Show();
                            }
                        }
                        break;
                    case "3":
                        System.out.print("Введите год: ");
                        int year = scanner.nextInt();
                        System.out.printf("%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s", "Фамилия", "Имя"
                                , "Отчество", "День", "Месяц", "Год", "Адрес", "Телефон", "Факультет", "Курс", "Группа");
                        for (int i = 0; i < n; i++) {
                            if (Spis[i].getYear() >= year) {
                                Spis[i].Show();
                            }
                        }
                        break;
                    case "4":
                        System.out.print("Введите название факультета: ");
                        String faculty4 = scanner.next();
                        System.out.print("Введите номер курса: ");
                        int kurs4 = scanner.nextInt();
                        System.out.print("Введите номер группы: ");
                        int group4 = scanner.nextInt();
                        System.out.printf("%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s", "Фамилия", "Имя"
                                , "Отчество", "День", "Месяц", "Год", "Адрес", "Телефон", "Факультет", "Курс", "Группа");
                        for (int i = 0; i < n; i++) {
                            if (faculty4.equals(Spis[i].getFaculty()) &&
                                    kurs4 == Spis[i].getKurs() && group4 == Spis[i].getGroup()) {
                                Spis[i].Show();
                            }
                        }
                        break;
                    default:
                        System.out.println("\nВы ввели что-то другое!");
                        bool = false;
                        break;
                }
            }
            scanner.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            scanner.close();
        }
        catch (Error ex2){
            System.out.println("Ошибка!");
            scanner.close();
        }
    }

    public static void VariantB() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите колличество дробей: ");
            int n = scanner.nextInt();
            RationalFraction[] Spis = new RationalFraction[n];
            for (int i = 0; i < n; i++) {
                Spis[i] = new RationalFraction();
                Spis[i].setRationalFraction();
            }
            System.out.printf("%15s%15s", "Числитель", "Знаменатель");
            for (int i = 0; i < n; i++) {
                Spis[i].Show();
                if(i > 0) {
                    if(i%2==0)
                    Spis[i-1]=Spis[i-1].Addition(Spis[i]);
                    Spis[i-1]=Spis[i-1].Reduction();
                }
            }
            System.out.println();
            System.out.printf("%15s%15s", "Числитель", "Знаменатель");
            for (int i = 0; i < n; i++) {
                Spis[i].Show();
            }
            scanner.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            scanner.close();
        }
        catch (Error ex2){
            System.out.println("Ошибка!");
            scanner.close();
        }
    }

    public static void VariantC() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nВведите колличество полиномов: ");
            int n = scanner.nextInt();
            System.out.print("Введите степень и дробные коэффициенты для каждого члена полинома\n");
            Polinom[] Spis1 = new Polinom[n];
            for (int i = 0; i < n; i++) {
                Spis1[i] = new Polinom();
                System.out.print("Введите степень " + (i + 1) + "-го полинома: ");
                int degree = scanner.nextInt();
                Spis1[i].setPolinom(scanner, degree);
            }
            System.out.print("\nВведенные полиномы:\n");
            for (int i = 0; i < n; i++) {
                Spis1[i].Show();
            }
            System.out.println();
            System.out.print("\nСумма полиномов:\n");
            for (int i = 1; i < n; i++) {
                Spis1[0]=Spis1[0].Addition(Spis1[i]);
            }
            Spis1[0].Show();
            scanner.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
