package ex06;

public abstract class Resident {
    private String name;
    private int income;

    public Resident(String name, int income) {
        this.name = name;
        this.income = income;
    }

    // just an example
//    public abstract int getSomething();

    public int getIncome() {
        return this.income;
    }

    public int taxes() {
        int currentIncome = this.getIncome();
        int currentTax = currentIncome / 10;
        if (currentTax <= 0) {
            currentTax = 1; 
        }
        return currentTax;
    }
}
