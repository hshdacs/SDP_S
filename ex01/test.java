package ex01;

public class test {
    public static void main(String[] args) {
        short b = 32767;
        b++;
        System.out.println(b);

        double f = 1.0 / 2;
        System.out.println(f);

        float x = 0.1F;
        float sum = 0;
        for (int i=0; i<1000000; i++) {
            sum += x;
        }
        System.out.println(sum);
    }
}