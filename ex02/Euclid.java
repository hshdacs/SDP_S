package ex02;

public class Euclid {
    public static void main(String[] args) {
        
        // We need to variables
        int a = 132342;
        int b = 252141;

        while ( a != b ) {
            if ( a > b ) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }

        System.out.println("a is " + a);
    }
}
