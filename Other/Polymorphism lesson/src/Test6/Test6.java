package Test6;

class Employee{
    void sleep(){System.out.println("Employee sleeps");}
}

class Doctor extends Employee{
    void sleep(){System.out.println("Doctor sleeps");}
}

public class Test6 {
    public static void main(String[] args) {
        //Employee x = new Employee(); // Employee sleeps
        Employee x = new Doctor(); // Doctor sleeps
        //Doctor x = new Doctor(); // Doctor sleeps
        //Doctor x = new Employee(); // compile ERROR. Not all Employers are Doctors
        //Employee x = (Doctor) new Employee(); // runtime ERROR. Employee cannot be cast to class Doctor
        //Doctor x = (Doctor)new Employee(); // runtime ERROR. Employee cannot be cast to class Doctor

        x.sleep();

    }
}


