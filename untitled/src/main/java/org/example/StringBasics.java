package org.example;

import java.util.Locale;
import java.util.Scanner;

public class StringBasics {
    public static void main(String[] args) {

        String name = "Omar";
        String phone = "05555";
        String email = "a@gmail.com";
        String message = "Welcome to Java";

        System.out.println(name.length());
        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());
        System.out.println(phone.startsWith("05"));
        System.out.println(email.contains("@"));

        Scanner s = new Scanner(System.in);

        System.out.println("Enter new password: ");
        String password = s.nextLine();

        if (password.length() < 8) {
            System.out.println("Week Password");
        }
        else {
            int digitCount = 0;
            int upperCount = 0;

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (Character.isUpperCase(c)) {
                    upperCount++;
                } else if (Character.isDigit(c)) {
                    digitCount++;
                }
            }

            if (upperCount < 2 || digitCount < 2) {
                System.out.println("Week Password");
            }
            else  {
                System.out.println("Strong Password");
            }
        }
    }
}
