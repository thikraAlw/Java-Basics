package org.example;

import java.util.Scanner;

public class CheckDayV2 {
    public static void main(String[] args) {

        var s = new Scanner(System.in);

        System.out.println("Enter a day number: ");

        int day = s.nextInt();

        if(day == 7 || day >= 1 && day <= 4)
            System.out.println("Work day ");
        else if (day == 5 || day == 6)
            System.out.println("Weekend day ");
        else
            System.out.println("Not day ");

    }
}
