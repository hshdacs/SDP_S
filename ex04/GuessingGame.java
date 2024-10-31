package ex04;

import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int someNumber = (int)(100*Math.random());

        System.out.print("Please enter a number: ");
        int value = input.nextInt();

        System.out.println("You entered " + value);
        System.out.println("I draw " + someNumber);
    }
}
