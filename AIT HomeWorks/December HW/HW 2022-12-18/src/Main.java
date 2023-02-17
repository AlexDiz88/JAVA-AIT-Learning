import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        AccountsArray accountsArray = new AccountsArray();

        Person p1 = new Person("Mike", "Donovan", 28);
        Person p2 = new Person("Olga", "Smirnova", 25);
        Person p3 = new Person("John", "Bergman", 37);
        Person p4 = new Person("Mike", "Black", 18);

        accountsArray.addAccount(new Account("DE123456789011", 1245, p1));
        accountsArray.addAccount(new Account("DE123456789012", 4521, p2));
        accountsArray.addAccount(new Account("DE123456789013", 789, p3));
        accountsArray.addAccount(new Account("DE123456789014", 264, p4));
        accountsArray.addAccount(new Account("DE123456789014", 10264, p1));
        accountsArray.addAccount(new Account("DE123456789016", 7236, p3));

        accountsArray.findAccountsByPerson(new Person("Olga", "Smirnova", 23));
        System.out.println("-".repeat(42));

        String[] IBANsByPerson = accountsArray.findAccountsByPerson(p1);
        System.out.println("-".repeat(42));
        System.out.println(Arrays.toString(IBANsByPerson));

        System.out.println("-------Sort by balance-------");
        accountsArray.sortByBalance();
        System.out.println(accountsArray);
        System.out.println("-------Sort by age-------");
        accountsArray.sortByAge();
        System.out.println(accountsArray);
    }
}
