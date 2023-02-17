package entity;

public enum Type {
    CREDIT('C'), DEBIT('D');

    private char code;

    Type(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }
}
