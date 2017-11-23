/** The Babylonian algorithm to compute the square root of a number n is as follows:
 * 1. Make a guess at the answer (you can pick n/2 as initial guess)
 * 2. Compute r = n/guess
 * 3. Set guess = (guess+r)/2
 * 4. Go back to step 2 until the last two guess values are the same.
 *
 * Write a program that inputs an integer for n, iterates through the Babylonian algorithm until the guess is with 1%
 * of the previous guess, and outputs the answer as double to two decimal places. Your answer should be accurate
 * even for large values of n.
 *
 */

import java.util.*;

public class Babylonia2 {

    public static void main (String[] args){

        int n;
        double r, guess;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter an integer value for n");

        n = keyboard.nextInt();

        guess = n / 2.0;

        r = n / guess;

        // Checks difference between current guess and guess generated from formula
        while ( guess - ((guess + r) / 2) > 0.01 ) {
            guess = (guess + r) / 2;
            r = n / guess;
            // System.out.println("guess: " + guess);
        }

        System.out.printf("%.2f", r);
    }

}

