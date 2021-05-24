package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Notepad {
    private Date date = new Date();
    private String notes;

    static class Date{
        int day;
        int month;
        int year;

        public Date(){}
        public Date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public int getDay() {
            return this.day;
        }
        public int getMonth() {
            return this.month;
        }
        public double getYear() {
            return this.year;
        }

        public void setDay( int day) {
            this.day = day;
        }
        public void setMonth( int month) {
            this.month = month;
        }
        public void setYear( int year) {
            this.year = year;
        }

        public String toString() {
            return this.day + "." + this.month + "." + this.year;
        }
    }

    Notepad(){}
    Notepad(int day, int month, int year, String notes){
        this.notes = notes + "\n";
        this.date.day=day;
        this.date.month=month;
        this.date.year=year;
    }
    public void setNotepad(){
        try {
            Scanner scanner = new Scanner(System.in);
            int day=0, month=0, year=0, importance;
            System.out.print("Введите день: ");
            if(scanner.hasNextInt()) {
                day = scanner.nextInt();
                if (day < 1 || day > 31 ) throw new MyException("Введен неверный формат даты!");
            }
            this.date.setDay(day);
            System.out.print("Введите месяц: ");
            if(scanner.hasNextInt()) {
                month = scanner.nextInt();
                if (month < 1 || month > 12 || (month==2 && day>29)) throw new MyException("Введен неверный формат даты!");
            }
            this.date.month = month;
            System.out.print("Введите год: ");
            if(scanner.hasNextInt())
                year = scanner.nextInt();
            this.date.year = year;
            System.out.print("Введите запись: ");
            scanner.nextLine();
            String note = scanner.nextLine() + "\n";
            this.notes = note;
            /*System.out.print("Введите 1, если запись приоритетная и 0, если нет: ");
            if(scanner.hasNextInt()) {
                importance = scanner.nextInt();
                if (importance == 1) this.importance = true;
                else if (importance == 0) this.importance = false;
                else throw new IllegalArgumentException("Ошибка! Введите 0 или 1!");
            }*/
        } catch (IllegalArgumentException | MyException e) {
            System.out.print("Исключение! " + e.getMessage() + "\n");
        }
    }
    public void addNotes(Scanner scanner){
        try {
            System.out.print("Введите запись: ");
            scanner.nextLine();
            String note = scanner.nextLine();
            this.notes+=note;
            this.notes+="\n";
        } catch (Exception e) {
            System.out.print("Исключение! " + e.getMessage() + "\n");
        }
    }

    public int getDay() {
        return this.date.day;
    }
    public int getMonth() {
        return this.date.month;
    }
    public int getYear() {
        return this.date.year;
    }
    public String getNotes(){ return this.notes;}
    public void setNotes(String notes){ this.notes = notes;}


    public void Show(){
        if (this.notes.isEmpty()) System.out.print("\nЗаписи отсутствуют!\n");
        else {
            System.out.print("\n\nДата (дд.мм.гг): " + this.date.toString());
            String allnotes[] = this.notes.split("\n", 0);
            for (int i=0; i<allnotes.length ;i++){
                System.out.print("\nЗапись: " + allnotes[i]);
            }
        }
    }
    public void ShowNotes(){
        String allnotes[] = this.notes.split("\n", 0);
        for (int i=0; i<allnotes.length ;i++){
            System.out.print("\nЗапись: " + allnotes[i]);
        }
    }

    public Notepad[] objectArray(int n) {
        Notepad[] Array = new Notepad[n];
        for (int i = 0; i < n; i++) {
            Array[i] = new Notepad();
        }
        return Array;
    }
}
