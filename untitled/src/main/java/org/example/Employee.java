package org.example;

public class Employee {

    String name;
    double salary;
    int hireYear;

    public Employee(String n, double s, int hY){
        name = n;
        salary = s;
        hireYear = hY;
    }

    public double calcAs(){
        return salary * 12;
    }

    public double calcSP(){
        return 2024 - hireYear;

    }
}
