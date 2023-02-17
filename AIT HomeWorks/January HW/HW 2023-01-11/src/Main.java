import java.util.ArrayList;
import java.util.List;

/*
Дан List строк. Написать метод, который возвращает строку, которая есть результат объединения всех строк исходного листа через пробел.
Например: {“I”, “do”, “my”, ”homework”} -> “I do my homework”. Написать тесты.

Пусть дан список List объектов типа User{String fName, String lName, int age }. Предположим, при чтение User-ов из базы данных случилась ошибка
 и у всех пользователей из списка поменялись местами fName и lName.
Необходимо написать метод, который исправит данную ситуацию. Написать тесты
 */
public class Main {
    public static void main(String[] args) {

        String s1 = "I";
        String s2 = "do";
        String s3 = "";
        String s4 = "homework";

        List<String> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        System.out.println(addStrings(list));

        User u1 = new User("Sakic", "Joe", 33);
        User u2 = new User("Vasya", "Pupkin", 23);
        changeNames(u1);
        changeNames(u2);
        System.out.println(u1);
        System.out.println(u2);
    }

    public static String addStrings(List<String> list) {
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && !list.get(i).equals("")) {
                res += list.get(i) + " ";
            }
        }
        return res.trim();
    }

    public static User changeNames(User user) {
        //User renewedUser = new User(user.getLastName(), user.getFirstName(), user.getAge());
        String temp = user.getFirstName();
        user.setFirstName(user.getLastName());
        user.setLastName(temp);
        return user;
        //return renewedUser;
    }



}