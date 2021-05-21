package com.company;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Student {
    //ФИО, дата рождения, адрес, телефон, факультет, курс, группа
    private String surname;
    private String name;
    private String midName;
    private int day;
    private int month;
    private int year;
    private String address;
    private String tel;
    private String faculty;
    private int kurs;
    private int group;

    public Student() {
        this.surname = "";
        this.name = "";
        this.midName = "";
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.address = "";
        this.tel = "";
        this.faculty = "";
        this.kurs = 0;
        this.group = 0;
    }

    public Student(String surname, String name, String midName,
                   int day, int month, int year, String address,
                   String tel, String faculty, int kurs, int group) {
        this.surname = surname;
        this.name = name;
        this.midName = midName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.address = address;
        this.tel = tel;
        this.faculty = faculty;
        this.kurs = kurs;
        this.group = group;
    }

    public void setStudent() {
        try {
            boolean b = true;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите ФИО\n");
            String surname = scanner.next();
            this.surname = surname;
            String name = scanner.next();
            this.name = name;
            String midName = scanner.next();
            this.midName = midName;
            System.out.print("Введите дату рождения (дд мм гггг)\n");
            int day=0;
            while (b) {
                day = scanner.nextInt();
                if (day > 31 || day < 1) {
                    throw new InputMismatchException("Ошибка! Введите день рождения!");
                } else b = false;
            }
            this.day = day;
            int month = 0;
            b = true;
            while (b) {
                month = scanner.nextInt();
                if (month > 12) {
                    throw new InputMismatchException("Ошибка! Введите месяц рождения!");
                } else b = false;
            }
            this.month = month;
            int year = 0;
            b = true;
            while (b) {
                year = scanner.nextInt();
                if (year > 2015 || year < 1920) {
                    throw new InputMismatchException("Ошибка! Введите год рождения!");
                } else b = false;
            }
            this.year = year;
            System.out.print("Введите адрес\n");
            String address = scanner.next();
            this.address = address;
            System.out.print("Введите телефон\n");
            String tel = scanner.next();
            this.tel = tel;
            System.out.print("Введите факультет\n");
            String faculty = scanner.next();
            this.faculty = faculty;
            System.out.print("Введите курс\n");
            int kurs = 0;
            b = true;
            while (b) {
                kurs = scanner.nextInt();
                if (kurs > 6 || kurs <= 0) {
                    throw new InputMismatchException("Ошибка! Введите верный курс!");
                } else b = false;
            }
            this.kurs = kurs;
            System.out.print("Введите номер группы\n");
            int group = 0;
            b = true;
            while (b) {
                group = scanner.nextInt();
                if (group <= 0 || group >= 20) {
                    throw new InputMismatchException("Ошибка! Введите верный номер группы!");
                } else b = false;
            }
            this.group = group;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getStudent() {
        System.out.print("\nФамилия: "+this.surname+
                "\nИмя: "+this.name+"\nОтчество: "+this.midName+
                "\nДень рождения: "+this.day+"\nМесяц: "+this.month+
                "\nГод: "+this.year+"\nАдрес: "+this.address+
                "\nНомер телефона: "+this.tel+"\nФакультет: "+this.faculty+
                "\nКурс: "+this.kurs+"\nГруппа: "+this.group);
    }

    public void Show() {
        System.out.println();
        System.out.printf("%15s",this.surname);
        System.out.printf("%15s",this.name);
        System.out.printf("%15s",this.midName);
        System.out.printf("%15d",this.day);
        System.out.printf("%15d",this.month);
        System.out.printf("%15d",this.year);
        System.out.printf("%15s",this.address);
        System.out.printf("%15s",this.tel);
        System.out.printf("%15s",this.faculty);
        System.out.printf("%15d",this.kurs);
        System.out.printf("%15d",this.group);
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMidName() {
        return this.midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getKurs() {
        return this.kurs;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }

    public int getGroup() {
        return this.group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Student[] objectArray(int number){
        Student [] Array = new Student[number];
        for (int i = 0; i < number; i++) {
            Array[i] = new Student();
        }
        return Array;
    }

    public String ToString(){
        return "Фамилия: "+this.surname+
                "\nИмя: "+this.name+"\nОтчество: "+this.midName+
                "\nДень рождения: "+this.day+"\nМесяц: "+this.month+
                "\nГод: "+this.year+"\nАдрес: "+this.address+
                "\nНомер телефона: "+this.tel+"\nФакультет: "+this.faculty+
                "\nКурс: "+this.kurs+"\nГруппа: "+this.group;
    }
}
