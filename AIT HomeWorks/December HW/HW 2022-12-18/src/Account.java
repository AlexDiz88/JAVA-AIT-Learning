public class Account {
    private String IBAN;
    private double balance;
    private Person client;

    public Account(String IBAN, double balance, Person client) {
        this.IBAN = IBAN;
        this.balance = balance;
        this.client = client;
    }

    @Override
    public String toString() {
        return String.format("%s %15s (%d) %10.2f", IBAN, client, client.getAge(), balance);
    }


    public Person getClient() {
        return client;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getBalance() {
        return balance;
    }
}
