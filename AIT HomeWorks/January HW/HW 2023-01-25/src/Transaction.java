import java.util.Objects;

public class Transaction {
    private long id;
    private Account debit;
    private Account credit;
    private double amount;

    public Transaction(long id, Account debit, Account credit, double amount) {
        this.id = id;
        this.debit = debit;
        this.credit = credit;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return id + ". " + debit + " -> " + credit + " = " + amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && Objects.equals(debit, that.debit) && Objects.equals(credit, that.credit);
    }

    public long getId() {
        return id;
    }

    public Account getDebit() {
        return debit;
    }

    public Account getCredit() {
        return credit;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, debit, credit, amount);
    }
}
