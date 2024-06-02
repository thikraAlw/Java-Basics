package org.example;

public class MyMethods {

//    public static double calcDMI(double weight, double height) {
//        return weight / Math.pow(height/100, 2);
//    }
//
//    public static String getStatus (double bmi) {
//        if (bmi < 18.5) return "Underweight";
//        else if (bmi < 25) return "Normal";
//        else if (bmi < 30) return "Overweight";
//        else return "obese";
//    }

//        public static String[] getStatus (double... bmis) {
//        var statuses = new  String[bmis.length];
//
//        for (int i = 0, i < bmis.length, i++) {
//            var bmi = bmis[i];
//            }
//    }

    public static double calcPCT(double mark, double fullMark) {
        return (mark / fullMark) * 100;
    }

    public static String getGrade (double pct) {
        if (pct > 85) return "Excellent";
        else if (pct > 75) return "Very Good";
        else if (pct > 65) return "Good";
        else if (pct >= 50) return "Pass";
        else return "Failed";
    }
}
