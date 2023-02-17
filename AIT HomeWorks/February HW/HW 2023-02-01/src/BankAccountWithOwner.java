import java.util.Objects;

public class BankAccountWithOwner {

    private String iban;
    private Person owner;

    public BankAccountWithOwner(String iban, Person owner) {
        this.iban = iban;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return iban + " " + owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountWithOwner that = (BankAccountWithOwner) o;
        return Objects.equals(iban, that.iban);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban);
    }

    public String getIban() {
        return iban;
    }

    public Person getOwner() {
        return owner;
    }
}
