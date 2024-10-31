package ex03;

// long
// 2**64 => 36.893.488.147.419.103.232
public class Collatz {

    final static int MAX_COLLATZ_NUMBER = 100_000_000;
    final static int ARRAY_SIZE = 3 * MAX_COLLATZ_NUMBER + 1;

    public static void main(String[] args) {

        int[] memory = new int[ ARRAY_SIZE ];
        int best_n = 0;
        int longest_length = 0;

        for (int i = 2; i < MAX_COLLATZ_NUMBER; i++ )  {
            long n = i;

            int counter = 0;
            while (n != 1) {
                counter++;
                if (n % 2 == 0) {
                    n = n / 2;
                    if (n < ARRAY_SIZE && memory[(int)n] > 0) {
                        counter = memory[(int)n] + counter;
                        break;
                    }
                }
                else {
                    n = 3 * n + 1;
                    if (n < ARRAY_SIZE && memory[(int)n] > 0) {
                        counter = memory[(int)n] + counter;
                        break;
                    }  
                }
            }
            memory[i] = counter;

            if (counter > longest_length) {
                longest_length = counter;
                best_n = i;
            }
        }

        System.out.println(best_n + 
        " has a Collatz Sequence of length "
        + longest_length);
    }
}
