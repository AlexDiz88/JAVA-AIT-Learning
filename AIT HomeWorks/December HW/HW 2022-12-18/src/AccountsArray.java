public class AccountsArray {

    private Account[] accounts;
    private int capacity;
    private int size;

    public AccountsArray() {
        capacity = 10;
        accounts = new Account[capacity];
    }

    public void sortByBalance() {
        boolean isNeedIteration = true;
        while (isNeedIteration) {
            isNeedIteration = false;
            for (int i = 1; i < size; i++) {
                if (isSwapNeeded(accounts[i].getBalance(), accounts[i-1].getBalance()))  {
                    swap(i, i-1);
                    isNeedIteration = true;
                }
            }
        }
    }

    public void sortByAge() {
        boolean isNeedIteration = true;
        while (isNeedIteration) {
            isNeedIteration = false;
            for (int i = 1; i < size; i++) {
                if (isSwapNeeded(accounts[i].getClient().getAge(), accounts[i-1].getClient().getAge())) {
                    swap(i, i-1);
                    isNeedIteration = true;
                }
            }
        }
    }

    private boolean isSwapNeeded(double a, double b) {
        return (a < b);
    }

    private void swap(int indexA, int indexB) {
        Account temp = accounts[indexA];
        accounts[indexA] = accounts[indexB];
        accounts[indexB] = temp;
    }

    public void addAccount(Account account) {
        if (size == capacity) {
            enlarge();
        }
        if (account != null) {
            accounts[size++] = account;
        }
    }

    private void enlarge() {
        Account[] enlargedArray = new Account[capacity*2];
        for (int i = 0; i < size; i++) {
            enlargedArray[i] = accounts[i];
        }
        accounts = enlargedArray;
    }

    public String[] findAccountsByPerson(Person person) {
        String[] tempArray = new String[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (accounts[i].getClient().equals(person)) {
                System.out.println(accounts[i]);
                tempArray[counter] = accounts[i].getIBAN();
                counter++;
            }
        }
        String[] ibanArray = new String[counter];
        for (int i = 0; i < counter; i++) {
            ibanArray[i] = tempArray[i];
        }
        return ibanArray;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += accounts[i] + "\n";
        }
        return result;
    }
}
