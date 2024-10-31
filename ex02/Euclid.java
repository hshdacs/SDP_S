package ex02;

public class Euclid {
    public static void main(String[] args) {
        
        // We need to variables
        int a = 132342;
        int b = 344354;

        while ( a != b ) {
            if ( a > b ) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }

        byte x = 5;
        while ( x > 0 ) {
            a = x * b;
            x++;
        }

        System.out.println("a is " + a);
    }
}
