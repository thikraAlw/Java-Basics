package org.example;

public class TestEmployee {

    public static void main(String[] args) {

        Employee e1 = new Employee("Amal", 7000, 2018);

        System.out.println(e1.name);
        System.out.println(e1.calcAs());
        System.out.println(e1.calcSP());

    }
}
