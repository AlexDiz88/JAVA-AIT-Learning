public class Test1 {
    public static void main(String[] args) {
        //Driver[] array1 = {new Driver(), new Driver()};
        Employee[] array2 = {new Driver(), new Driver(), new Teacher(), new Doctor()};
        //Help_able[] array3 = {new Driver(), new Driver(), new Teacher(), new Doctor()};

        Employee emp1 = new Teacher();
        Employee emp2 = new Driver();
        Employee emp3 = new Doctor();
        Help_able h = new Teacher();
        String s1 = "";


        Employee[] array4 = {emp1, emp2, emp3};
        System.out.println(array2 instanceof Object);

//        for (Employee emp : array4) {
//            emp.work();
//        }


//        h.help();
//        emp1.work();
//        emp2.work();
//        emp3.work();
    }
}

abstract class Employee{
    void sleep () {System.out.println("Employee sleeps");}
    abstract void work();
}

class Teacher extends Employee implements Help_able{
    public void help() {System.out.println("Teacher helps");}
    @Override
    void work(){System.out.println("Teacher works");}
}
class Driver extends Employee implements Help_able{
    public void help() {System.out.println("Driver helps");}
    @Override
    void work(){System.out.println("Driver works");}
}
class Doctor extends Employee implements Help_able{
    public void help() {System.out.println("Doctor helps");}
    @Override
    void work(){System.out.println("Doctor works");}
}

interface Help_able{
    void help();
}


