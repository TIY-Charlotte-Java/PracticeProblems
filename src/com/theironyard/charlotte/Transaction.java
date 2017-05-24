package com.theironyard.charlotte;

public class Transaction {
    private static int STATIC_ID_THING = 0;
    private double value;
    private TransactionType type;
    private int id;

    public Transaction(double value, TransactionType type) {
        id = STATIC_ID_THING++;
        this.value = value;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public enum TransactionType {
        GROCERY,
        SHOES,
        WEB,
        BILLS
    }
}
