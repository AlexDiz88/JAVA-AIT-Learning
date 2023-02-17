import java.util.Objects;

public class Account {
    private final String iban;

    public Account(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return iban;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(iban, account.iban);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban);
    }
}
