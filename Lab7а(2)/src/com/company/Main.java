package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Notepad> notepads = new ArrayList<Notepad>();
            notepads.add(new Notepad(19,5,2021, "Контольная по английскому."));
            Notepad notepad = new Notepad(24,5,2021,"") {
                boolean importance = true;
                @Override
                public void setNotes (String string) {
                    if (importance) {
                        super.setNotes("!ВАЖНО! " + string);
                    }
                }
            };
            notepad.setNotes("Зачет по методам программирования!");
            notepads.add(notepad);
            notepads.add(new Notepad(30,7,2021, "Купить корм коту."));
            char choice = '0', ch = '0';
            int day=0, month=0, year=0;
            int[] array;
            while (choice == '0') {
                System.out.print("\nВведите 1, если желаете добавить добавить запись на имеющуюся дату"
                        + "\nВведите 2, если желаете вывести все записи на определенную дату"
                        + "\nВведите 3, если желаете вывести все записи"
                        + "\nВведите 4, если желаете выйти"
                        + "\nВводите здесь: ");
                char choice1 = scanner.next().charAt(0);
                switch (choice1) {
                    case '1':
                        System.out.print("Введите дату, на которую вы желаете добавить запись.\n");
                        array = Input(scanner);
                        while (ch == '0') {
                            for (Notepad notepad1 : notepads) {
                                if (notepad1.getDay()==(array[0]) && notepad1.getMonth() == (array[1]) && notepad1.getYear() == (array[2])) {
                                    notepad1.addNotes(scanner);
                                }
                            }
                            System.out.print("\nЕсли желаете добавить еще одну запись, введите 0"
                                    + "\nесли нет, нажмите любую клавишу: ");
                            ch = scanner.next().charAt(0);
                        }
                        break;
                    case '2': {
                        System.out.print("Введите дату, записи на которую вы желаете вывести: \n");
                        array= Input(scanner);
                        for (Notepad notepad1 : notepads) {
                            if (notepad1.getDay()==(array[0]) && notepad1.getMonth() == (array[1]) && notepad1.getYear() == (array[2])) {
                                notepad1.ShowNotes();
                            }
                        }
                        break;
                    }
                    case '3':
                        for (Notepad notepad1 : notepads)
                            notepad1.Show();
                        break;
                    case '4':
                        choice='1';
                        break;
                    default:
                        throw new IllegalArgumentException("\nОшибка! Вы ввели неверное число!");
                }
            }
        } catch (Exception e) {
            System.out.print("Исключение! " + e.getMessage());
        }
    }

    public static int[] Input(Scanner scanner) throws MyException {
        int day=0, month=0, year=0;
        System.out.print("Введите день: ");
        if(scanner.hasNextInt()) {
            day = scanner.nextInt();
            if (day < 1 || day > 31 ) System.out.print("Введен неверный формат даты!");
        }
        System.out.print("Введите месяц: ");
        if(scanner.hasNextInt()) {
            month = scanner.nextInt();
            if (month < 1 || month > 12 || (month==2 && day>29)) System.out.print("Введен неверный формат даты!");
        }
        System.out.print("Введите год: ");
        if(scanner.hasNextInt())
            year = scanner.nextInt();
        int[] array= new int[]{day, month, year};
        return array;
    }
}
