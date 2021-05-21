package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Введите 3 строки: " );
            Scanner sc = new Scanner(System.in);
            String s1,s2,s3,s4;
            s1 = sc.nextLine();
            s2 = sc.nextLine();
            s3 = sc.nextLine();
            s4 = s1+"\n"+s2+"\n"+s3;
            System.out.println("Исходный текст: \n" + s4);
            FileOutputStream fos = new FileOutputStream("D:\\Мехмат\\___ПРОГА\\Lab6\\src\\com\\company\\Source.txt");
            PrintStream printStream = new PrintStream(fos);
            printStream.println(s4);
            System.out.println("Файл записан");
            fos.close();
            System.out.print("Введите подстроку: ");
            String subStr = sc.nextLine();
            String replace = s4.replace(subStr, " ");
            FileOutputStream fos1 = new FileOutputStream(("D:\\Мехмат\\___ПРОГА\\Lab6\\src\\com\\company\\result.txt"));
            PrintStream printStream1 = new PrintStream(fos1);
            printStream1.println(replace);
            System.out.println("Файл перезаписан");
            System.out.println("Итоговый текст : \n" + replace);
            fos1.close();
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
