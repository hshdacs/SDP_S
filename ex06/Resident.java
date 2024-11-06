package ex06;

public class Resident {
    private String name;
    private int income;

    public Resident(String name, int income) {
        this.name = name;
        this.income = income;
    }

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
