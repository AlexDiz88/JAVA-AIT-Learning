import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----------------Задача 1.------------------");
        System.out.println(Utilities.intToThirdDegree(4));


        System.out.println("-----------------Задача 2.------------------");
        System.out.println(Utilities.getLastDigit(175));
        System.out.println(Utilities.getLastDigit(17));
        System.out.println(Utilities.getLastDigit(1529));


        System.out.println("-----------------Задача 3.------------------");
        System.out.println(Arrays.toString(Utilities.getEvenArray(7, 4)));


        System.out.println("-----------------Задача 4.------------------");
        System.out.println(Utilities.getMaxNumberIndexInArray(new int[]{5, 9, -1, 6, 10, 1, 8}));


        System.out.println("-----------------Задача 5.------------------");
        System.out.println(Utilities.getLongestString(new String[]{"John", "Nicolaus", "Ann"}));


        System.out.println("-----------------Задача 6.------------------");
        System.out.println(Utilities.getMostOldestPerson(new Person[]{new Person("John", 23), new Person("Nicolaus", 45), new Person("Ann", 21)}));


        System.out.println("-----------------Задача 7.------------------");
        String[] names = new String[]{"Иван Иванов", "Николай Николаев", "Петр Петров"};
        System.out.println(Arrays.toString(Utilities.shortFirstNames(names)));


        System.out.println("-----------------Задача 8.------------------");
        ArrayStudents groupA1 = new ArrayStudents();
        groupA1.addStudent(new Student("Max", "Meyers"));
        groupA1.addStudent(new Student("Anna", "Summer"));
        groupA1.addStudent(new Student("George", "Kox"));
        System.out.println("Состав группы студентов:\n" + groupA1);
        System.out.println("Найденные студенты по имени:");
        ArrayStudents res = groupA1.getStudentsByNames(new String[]{"Max Meyyers", "Anna Summer", "GeorgeKox"});
        System.out.println(res);


        System.out.println("-----------------Задача 9.------------------");
        System.out.println(Utilities.sumOfDigits(3459));


        System.out.println("-----------------Задача 10.------------------");
        System.out.println(Arrays.toString(Utilities.getPrimeNumbers(10)));


        System.out.println("-----------------Задача 11.------------------");
        System.out.println(Arrays.toString(Utilities.getStringsByFlagValue(new String[]{"John", "Nicolaus", "Ann"}, true)));
        System.out.println(Arrays.toString(Utilities.getStringsByFlagValue(new String[]{"John", "Nicolaus", "Ann"}, false)));


        System.out.println("-----------------Задача 12.------------------");
        int[] arr = new int[]{5, 16, 43, 8, 3, 0, 76, 32};
        Utilities.selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("-----------------Задача 13.------------------");
        String[] strings = new String[]{"Just do it", "Be yourself", "Sunshine", "Low", "Never be the same again", "Hi"};
        Utilities.stringsLengthSort(strings);
        System.out.println(Arrays.toString(strings));

        System.out.println("-----------------Задача 14.------------------");
        Person[] people = new Person[]{new Person("John", 23), new Person("Nicolaus", 45), new Person("Ann", 21)};
        Utilities.peopleSortByAge(people);
        System.out.println(Arrays.toString(people));

        System.out.println("-----------------Задача 15.------------------");
        Date d1 = new Date(11, 3, 1985);
        Date d2 = new Date(29, 6, 2003);
        Date d3 = new Date(15, 11, 1985);
        Date d4 = new Date(4, 11, 1989);
        Date[] dates = new Date[]{d1, d2, d3, d4};
        Utilities.datesSort(dates);
        System.out.println(Arrays.toString(dates));
    }

}




