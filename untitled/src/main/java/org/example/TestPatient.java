package org.example;

public class TestPatient {

    public static void main(String[] args) {

        Patient p1 = new Patient("Amal", 65, 167);
        Patient p2 = new Patient("Hmd", 75, 175);

        System.out.println(p1.calcBMI());
        System.out.println(p1.getStatus());
        System.out.println(p1.name);

    }
}
