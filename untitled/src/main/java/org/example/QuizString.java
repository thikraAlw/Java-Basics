package org.example;

import java.util.Scanner;

public class QuizString {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter new password: ");
        String password = s.nextLine();

        if (password.length() != 10) {
            System.out.println("Week Password");
        }
        else if (!password.startsWith("05")) {
            System.out.println("Password Not Started with 05 ");
        }
        else {
            int digitCount = 0;

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (Character.isDigit(c)) {
                    digitCount++;
                }
            }

            if (digitCount == 10) {
                System.out.println("Good Password");
            }
            else  {
                System.out.println("Wrong Password");
            }
        }
    }
}
