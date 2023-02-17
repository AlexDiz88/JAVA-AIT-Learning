public class Utilities {

    // 1. Написать метод, который принимает параметр типа int и возвращает третью степень этого числа.
    public static int intToThirdDegree(int num) {
        return num * num * num;
    }

    // 2. Написать метод, который возвращает значение последнего разряда числа.
    // Например: getLastDigit(175) -> 5, getLastDigit(17) -> 7, getLastDigit(1529) -> 9
    public static int getLastDigit(int num) {
        return num % 10;
    }

    // 3. Написать метод, который создает массив из n целых четных чисел больше или равных заданному числу a
    // Например: getEven(n=7, a=4) -> {4,6,8,10,12,14,16}

    public static int[] getEvenArray(int n, int a) {
        int[] array = new int[n];
        if (a % 2 == 1) a += 1;
        for (int i = 0; i < n; i++) {
            array[i] = a;
            a += 2;
        }
        return array;
    }

    // 4. Написать метод, который принимает массив целых чисел и возвращает индекс наибольшего числа в этом массиве.
    // Например: {5, 9, -1, 6, 10, 1, 8} -> 4
    public static int getMaxNumberIndexInArray(int[] array) {
        if (array != null) {
            int maxIndex = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
        return -1;
    }

    // 5. Написать метод, который принимает массив строк и возвращает самую длинную строку в этом массиве.
    // Например: {“John”, “Nicolaus”, “Ann”} -> “Nicolaus”
    public static String getLongestString(String[] array) {
        String res = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].length() > res.length()) {
                res = array[i];
            }
        }
        return res;
    }

    // 6. Написать метод, который принимает массив Person(String name, int age) и возвращает самого взрослого человека в этом массиве.
    // Например: {John 23, Nicolaus 45, Ann 21} -> Nicolaus 45
    public static Person getMostOldestPerson(Person[] people) {
        if (people != null) {
            Person oldestPerson = people[0];
            for (int i = 0; i < people.length; i++) {
                if (people[i].age > oldestPerson.age) {
                    oldestPerson = people[i];
                }
            }
            return oldestPerson;
        } else {
            return null;
        }
    }

    // 7. Написать метод, который принимает массив строк вида “Иван Иванов”, т.е. имя и фамилия,
    // а в качестве результата возвращает массив строк вида «И.Иванов».
    // Например: {“Иван Иванов”, “Николай Николаев”, “Петр Петров”} -> {“И.Иванов”, “Н.Николаев”, “П.Петров”}
    public static String[] shortFirstNames(String[] array) {
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            String temp = "";
            temp += array[i].trim().charAt(0) + ".";
            int spaceIndex = array[i].indexOf(" ");
            temp += array[i].substring(spaceIndex + 1);
            result[i] = temp;
        }
        return result;
    }

    // 9. Дано целое число num. Необходимо написать метод, который посчитает сумму разрядов этого числа.
    // Например: 3459 -> 21
    public static int sumOfDigits(int num) {
        int result = 0;
        if (num > 0) {
            while (num > 0) {
                int remainder = num;
                remainder %= 10;
                result += remainder;
                num /= 10;
            }
            return result;
        }
        if (num < 0) {
            while (num < 0) {
                int remainder = num;
                remainder %= 10;
                result += remainder;
                num /= 10;
            }
        }
        return result * -1;
    }

    // 10. Число называется простым, если делиться без остатка только на единицу или на само себя.
    // Реализовать метод, который выводит n простых чисел. Например:
    // getPrimeNumbers(10) -> 1   2   3   5   7   11   13   17    19	23
    public static int[] getPrimeNumbers(int n) {
        int[] result = new int[n];
        if (n > 0) {
            int primeNumbersCounter = 0;
            int counter;
            for (int potentialPrimeNumber = 1; primeNumbersCounter < n; potentialPrimeNumber++) {
                counter = 0;
                for (int delimeter = 1; delimeter <= potentialPrimeNumber; delimeter++) {
                    if (potentialPrimeNumber % delimeter != 0) {
                        counter++;
                    }
                }
                if (potentialPrimeNumber - 2 == counter || potentialPrimeNumber == 1) {
                    result[primeNumbersCounter++] = potentialPrimeNumber;
                }
            }
            return result;
        }
        return null;
    }

    // 11. Дан массив строк. Написать метод, который принимает данный массив и параметр boolean flag.
    // Метод должен возвращать новый массив строк, но, в зависимости от значения flag,
    // метод должен возвращать либо массив, содержащий все элементы исходного массива с четными индексами, либо, наоборот, с нечетными индексами.
    //Например:
    //{“John”, “Nicolaus”, “Ann”}, true -> {“John”, “Ann”}
    //{“John”, “Nicolaus”, “Ann”}, false -> {“Nicolaus”}
    public static String[] getStringsByFlagValue(String[] array, boolean flag) {
        if (array == null ) {
            return null;
        }
        int newLength;
        if (array.length % 2 != 0 && flag) {
            newLength = array.length / 2 + 1;
        } else {
            newLength = array.length / 2;
        }
        String[] result = new String[newLength];
        int index = 0;
        if (!flag) {
            index = 1;
        }
        for (int i = 0; i < newLength; i++) {
            result[i] = array[index];
            index += 2;
        }
        return result;
    }


    //12. Дан массив целых чисел. Написать метод, который сортирует данный массив в порядке возрастания.
    // Использовать любой известный вам алгоритм сортировки.
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[minIndex] = temp;
        }
    }

    // 13. Дан массив строк. Написать метод, который сортирует данный массив в порядке возрастания длин строк,
    // от самой короткой до самой длинной. Использовать любой известный вам алгоритм сортировки.
    // (Для решения данной задаче нельзя использовать встроенные методы сортировки Java)
    public static void stringsLengthSort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int minLength = array[i].length();
            String shortest = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].length() < minLength) {
                    shortest = array[j];
                    minLength = array[j].length();
                    minIndex = j;
                }
            }
            String temp = array[i];
            array[i] = shortest;
            array[minIndex] = temp;
        }
    }

    // 14. Дан массив объектов Person(String name, int age).
    // Написать метод, который сортирует данный массив по старшинству, от самого юного Person до самого взрослого.
    // Использовать любой известный вам алгоритм сортировки.
    // (Для решения данной задаче нельзя использовать встроенные методы сортировки Java )
    public static void peopleSortByAge(Person[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int minAge = array[i].getAge();
            Person youngest = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].getAge() < minAge) {
                    youngest = array[j];
                    minAge = array[j].getAge();
                    minIndex = j;
                }
            }
            Person temp = array[i];
            array[i] = youngest;
            array[minIndex] = temp;
        }
    }

    // 15. Дан массив объектов MyDate(int day, int month, int year).
    // Написать метод, который сортирует данный массив от самой ранней даты до самой поздней.
    // Использовать любой известный вам алгоритм сортировки.
    // Подсказка: естественно вам придется написать метод сравнения двух дат.
    // (Для решения данной задаче нельзя использовать встроенные методы сортировки Java, и встроенные способы сравнения объектов)
    public static boolean dateComparison(Date date1, Date date2) {
        if (date1.getYear() < date2.getYear()) {
            return true;
        } else if (date1.getYear() > date2.getYear()) {
            return false;
        }
        if (date1.getMonth() < date2.getMonth()) {
            return true;
        } else if (date1.getMonth() > date2.getMonth()) {
            return false;
        }
        if (date1.getDay() < date2.getDay()) {
            return true;
        } else if (date1.getDay() > date2.getDay()) {
            return false;
        }
        return true;
    }


    public static void datesSort(Date[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            Date minDate = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (dateComparison(array[j], minDate)) {
                    minDate = array[j];
                    minIndex = j;
                }
            }
            Date temp = array[i];
            array[i] = minDate;
            array[minIndex] = temp;
        }
    }


}
