package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class CallMethods {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

//        System.out.print("Enter weight and height: ");
//        double w = sc.nextDouble();
//        double h = sc.nextDouble();
//
//        double bmi = MyMethods.calcDMI(w, h);
//        String status = MyMethods.getStatus(bmi);
//
//        System.out.println("Your BMI: " + bmi + " , " + status);

//        var statuses MyMethods.getStatus(new double[] {23, 20, 22});
//        var statuses MyMethods.getStatus(23, 20, 35, 15);
//        System.out.println(Arrays.);


        System.out.print("Enter mark and full mark: ");
        double m = sc.nextDouble();
        double fm = sc.nextDouble();

        double pct = MyMethods.calcPCT(m, fm);
        String grade = MyMethods.getGrade(pct);

        System.out.println("Your PCT: " + pct + " , " + grade );
    }
}
