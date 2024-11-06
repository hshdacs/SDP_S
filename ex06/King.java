package ex06;

public class King extends Resident {

    public King(String name, int income) {
        super(name, income);
    }

    @Override
    public int getIncome() {
        return 0;
    }
}
