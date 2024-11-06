package ex05;

public class Ratio /* Java Magic: extends Object */ {

    // attributes
    private int enumarator;
    private int denominator;

    // methods
    /* this is our standard ctor */
    public Ratio(int enumarator, int denominator) {
        this.enumarator = enumarator;
        this.denominator = denominator;
    }

    public Ratio(int enumarator) {
        /* DONT DO THIS:
        this.enumarator = enumarator;
        this.denominator = 1;
         */
        /* DO THIS */
        this(enumarator, 1);
    }

    /* overwrite a method in class Object */
    @Override
    public String toString() {
        return this.enumarator + "/" + this.denominator;
    }

    // reducing the ratio, e.g. 4/4 = 1/1, 2/4 = 1/2
    public Ratio reduce() {
        int divider = findDivider(this.enumarator, this.denominator);
        return new Ratio(this.enumarator / divider, this.denominator / divider);
    }
        
    private int findDivider(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        while (a != b) {
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }
        return a;
    }
            
    
    // we want to add to ratio numbers, e.g.
    // Ratio a = new Ratio(1, 2);
    // Ratio b = new Ratio(1, 4);
    // Ratio c = a + b; <-- possible in C++, not in Java
    // Ratio c = a.add(b);
    public Ratio add(Ratio that) {
        int newDenominator = this.denominator * that.denominator;
        int newEnumerator = this.enumarator * that.denominator 
                               + that.enumarator * this.denominator;
        return new Ratio(newEnumerator, newDenominator).reduce();
    }

    public Ratio sub(Ratio that) {
        return this.add( that.negate() );
    }

    public Ratio negate() {
        int newEnumerator = -this.enumarator;
        int newDenominator = this.denominator; 
        if (newEnumerator < 0 && newDenominator < 0) {
            newEnumerator = -newEnumerator;
            newDenominator = -newDenominator;
        }
        return new Ratio(newEnumerator, newDenominator);
    }
    
}
