package com.company;

import java.util.Scanner;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Pattern pattern0 = Pattern.compile("(\\w+)");
        System.out.print("Введите пароль: ");
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();

        if (pattern0.matcher(password).matches()) {
            if (password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{10,}$"))
                    System.out.println("Сильный пароль!");
            else
                System.out.println("Слабый пароль!");
        }
        else System.out.println("Ошибка! Пароль может содержать только латинские буквы и/или цифры, а также символ «_»!");
    }
}
