package ex05;

public class Main {

    public static void main(String[] args) {
        Ratio r1 = new Ratio(1, 2);
        Ratio r2 = new Ratio(2);

        System.out.println(r1);
        System.out.println(r2);

        Ratio a = new Ratio(1, 2);
        Ratio b = new Ratio(1, 3);
        Ratio c = a.add(b);
        System.out.println(a + " + " + b + " = " + c);

        Ratio d = a.add(a);
        System.out.println(a + " + " + a + " = " + d);

        System.out.println(a + " - " + b + " = " + a.sub(b));
        System.out.println(a + " - " + a + " = " + a.sub(a));
    }
}
