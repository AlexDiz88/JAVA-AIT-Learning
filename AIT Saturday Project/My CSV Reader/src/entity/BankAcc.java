package entity;

import java.util.Objects;

public class BankAcc {

    private String iban;
    private long accountNumber;
    private long blz;
    private Double balance;
    private long orderId;
    private long userId;
    private Type typeEnum;

    public BankAcc(String iban, long accountNumber, long blz, Double balance, long orderId, long userId, Type typeEnum) {
        this.iban = iban;
        this.accountNumber = accountNumber;
        this.blz = blz;
        this.balance = balance;
        this.orderId = orderId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAcc bankAcc = (BankAcc) o;
        return accountNumber == bankAcc.accountNumber && blz == bankAcc.blz && orderId == bankAcc.orderId && userId == bankAcc.userId && Objects.equals(iban, bankAcc.iban) && Objects.equals(balance, bankAcc.balance) && typeEnum == bankAcc.typeEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, accountNumber, blz, balance, orderId, userId, typeEnum);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getBlz() {
        return blz;
    }

    public void setBlz(long blz) {
        this.blz = blz;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
