package org.example;

import java.util.Scanner;

public class QuizV2 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);

        System.out.printf("What's %d * %d ?",x,y);

        int answer = s.nextInt();

//        while (answer == x*y) {
//            x = (int) (Math.random() * 10);
//            y = (int) (Math.random() * 10);
//            System.out.printf("What's %d * %d ?",x,y);
//            answer = s.nextInt();
//        }
//        System.out.printf("Game Over!!");

//        while (answer != x*y) {
//            System.out.println("Try Again");
//            System.out.printf("What's %d * %d ?",x,y);
//            answer = s.nextInt();
//        }
//        System.out.println("Correct");



    }

}
