package Test4;

public class Test4 {
    public static void main(String[] args) {
        //Heal_able h = new Doctor();

        Employee emp1 = new Doctor();
        Employee emp2 = new Teacher();
        Employee emp3 = new Driver();
        Employee emp4 = new Employee();
        Employee emp5 = new SuperDriver();
        Employee[] array = {emp1, emp2, emp3, emp4, emp5};
        for (Employee e : array) {
            if (e instanceof Driver) {
                System.out.println(((Driver) e).carName);
                ((Driver) e).drive();
            }
        }


        Car c1 = new Car();
//        System.out.println(((Teacher) emp2).numberOfPupils);
//        ((Teacher) emp2).learn();
//        System.out.println(((Doctor) emp1).specialisation);
//        ((Doctor) emp1).heal();
        //System.out.println(d1.specialisation);
//        h.help();
//        ((Doctor) h).heal();

    }
}

class Employee extends java.lang.Object{
    double salary=100;
    String name = "Kolya";
    int age;
    int experience;
    void eat(){System.out.println("Eat");}
    void sleep(){System.out.println("Sleep");}
}

class Doctor extends Employee implements Heal_able{
    @Override
    public void help(){
        System.out.println("Doc is helping");
    }

    String specialisation="Chirurg";
    void heal(){System.out.println("Heal");}
}

class Teacher extends Employee{
    int numberOfPupils;
    void learn(){System.out.println("Learn");}
}

class Driver extends Employee{
    String carName="BMW";
    void drive(){System.out.println("Drive");}
}
class SuperDriver extends Driver{
    void speedUp(){System.out.println("speed up");}
    @Override
    void drive(){System.out.println("SuperDrive");}
}

interface Heal_able{
    void help();
}

class Car{
    String color="white";
}
