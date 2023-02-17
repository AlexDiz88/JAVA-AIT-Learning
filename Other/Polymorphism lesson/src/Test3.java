public class Test3 {
    public static void main(String[] args) {
        Jumpable j = new Man();
        Man m = new Man();
        Human h = new Human();
        Student s = new Student();
        Object o = new Object();
        if (s instanceof Jumpable){System.out.println("j is Jumpable");}
        if (h instanceof Human){System.out.println("h is Human");}
        if (h instanceof Man){System.out.println("h is Man");}
//        if (j instanceof Jumpable){System.out.println("j is Jumpable");}
    }
}

interface Jumpable{}
class Human implements Jumpable{}
class Man extends Human{}
class Student{}