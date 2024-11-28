package ex09.model;

public class Account {
    private int number;
    private String owner;
    private double balance;

    public Account(int number, String owner, double balance) {
        this.number = number;
        this.owner = owner;
        this.balance = balance;
    }

    public Account(int number, String owner) {
        this(number, owner, 0.0);
    }

    public int getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean withdraw(double amount) {
        amount = Math.abs(amount);
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        this.balance += Math.abs(amount);
    }

    public Account clone() {
        return new Account(this.number, this.owner, this.balance);
    }

    @Override
    public String toString() {
        return "[" + number + "] " + owner + " (" + balance + ")";
    }
}
