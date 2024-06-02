package org.example;

import java.util.Scanner;

public class AnalyzeMarks {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter number of students: ");
        int n = s.nextInt();

        double best = 0;

        double[] marks = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter student mark: ");
            marks[i] = s.nextDouble();
            if (marks[i] > best) {
                best = marks[i];
            }
        }

//        for (int i = 0; i < n; i++) {
//            if (marks[i] >= best - 10) {
//                System.out.println(marks[i] + " => A");
//            }
//            else if (marks[i] >= best - 20) {
//                System.out.println(marks[i] + " => B");
//            } else if (marks[i] >= best - 30) {
//                System.out.println(marks[i] + " => C");
//            } else if (marks[i] >= best - 40) {
//                System.out.println(marks[i] + " => D");
//            }


//        for each loop
        for (double m : marks){
            if (m >= best - 10) {
                System.out.println(m + " => A");
            }
            else if (m >= best - 20) {
                System.out.println(m + " => B");
            } else if (m >= best - 30) {
                System.out.println(m + " => C");
            } else if (m >= best - 40) {
                System.out.println(m + " => D");
            }
        }
    }

}
