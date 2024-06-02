package org.example;

import java.util.Scanner;

public class Quis {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int correct = 0;

        for (int z = 1; z <= 5; z++) {

            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);

            for (int j = 1; j <=3; j++){
                System.out.printf("What's %d * %d ?", x, y);
                int answer = s.nextInt();

                if (answer == x * y) {
                    System.out.println("Correct");
                    correct++;
                    break;
                } else {
                    System.out.println("Wrong");
                }
            }
            System.out.println("---------------------");

//        System.out.println("What's " + x + " * " + y + " ? ");

        }
        System.out.println("Your score is: "+ correct + " out of 5");


        

//            int x = (int) (Math.random() * 10);
//            int y = (int) (Math.random() * 10);
//
//            System.out.printf("What's %d * %d ?", x, y);
//            int answer = s.nextInt();
//
//            if (answer == x * y) {
//                System.out.println("Correct");
//            } else {
//                System.out.println("Wrong");
//            }


    }
}
