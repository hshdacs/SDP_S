package ex04;

import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int secretNumber = (int)(9000*Math.random()) + 1000;
        // check for double digits

        int numberOfTries = 0;
        while (true) {
            System.out.print("Please enter a number: ");
            int tipp = input.nextInt();
            
            if (tipp == 0) {
                System.out.println("Oh, we're sorry.");
                System.out.println("The secret number was " + secretNumber);
                break;
            }

            numberOfTries++;
            if (tipp == secretNumber) {
                System.out.println("Yeah, congratulation. You got it.");
                break;
            }

            int numberOfCorrectDigits = determineCorrectDigits(tipp, secretNumber);
            int numberOfPresentDigits = determinePresentDigits(tipp, secretNumber);
            numberOfPresentDigits = numberOfPresentDigits - numberOfCorrectDigits;
            System.out.println("There are " + numberOfCorrectDigits + " correct digits");
            System.out.println("There are " + numberOfPresentDigits + " present digit");
        }
        System.out.println("You needed " + numberOfTries + " turns.");
        System.out.println("Thank you for playing. Good bye.");
    }

    private static int determinePresentDigits(int tipp, int secretNumber) {
        int numberOfPresentDigits = 0;
        while (tipp > 0) {
            int digitOfTipp = tipp % 10;
            if ( isDigitInNumber(digitOfTipp, secretNumber) ) {
                numberOfPresentDigits++;
            }
            tipp /= 10;
        }
        return numberOfPresentDigits;
    }

    private static boolean isDigitInNumber(int digit, int number) {
        while (number > 0) {
            int digitOfNumber = number % 10;
            if (digit == digitOfNumber) {
                return true;
            }
            number /= 10;
        }
        return false;
    }

    private static int determineCorrectDigits(int tipp, int secretNumber) {
        int numberOfCorrectDigits = 0;
        while (secretNumber > 0) {
            int digitOfSecretNumber = secretNumber % 10;
            int digitOfTipp = tipp % 10;
            if (digitOfSecretNumber == digitOfTipp) {
                numberOfCorrectDigits++;
            }
            secretNumber /= 10;
            tipp /= 10;
        }
        return numberOfCorrectDigits;
    }        
}
