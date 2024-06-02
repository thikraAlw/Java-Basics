package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter a day number: ");

        int day = s.nextInt();

        if(day >= 1 && day <= 5)
            System.out.println("Work day ");
        else if (day == 6 || day == 7)
            System.out.println("Weekend day ");
         else
            System.out.println("Not day ");



        switch (day){
            case 1 ->
                    System.out.println("Saturday ");
            case 2 ->
                    System.out.println("Sunday ");
            case 3 ->
                    System.out.println("Monday ");
            case 4 ->
                    System.out.println("Tuesday ");
            case 5 ->
                    System.out.println("Wednesday ");
            case 6 ->
                    System.out.println("Thursday");
            case 7 ->
                    System.out.println("Friday ");
        }

//        String dayName = switch (day){
//            case 1 ->
//                    yield ("Saturday ");
//            case 2 ->
//                    ("Sunday ");
//            case 3 ->
//                    ("Monday ");
//            case 4 ->
//                    ("Tuesday ");
//            case 5 ->
//                    ("Wednesday ");
//            case 6 ->
//                    ("Thursday");
//            case 7 ->
//                    ("Friday ");
//            default -> "Not a day";
//        }




    }
}