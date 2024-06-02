package org.example;

import java.util.Scanner;

public class CheckEvenOdd {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int x = s.nextInt();

        System.out.println(x % 2 == 0 ? "Even " : "odd");
    }
}
