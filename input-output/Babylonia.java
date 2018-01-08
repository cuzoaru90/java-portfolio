/** The Babylonian algorithm to compute the square root of a number n is as follows:
 * 1. Make a guess at the answer (you can pick n/2 as initial guess)
 * 2. Compute r = n/guess
 * 3. Set guess = (guess+r)/2
 * 4. Go back to step 2 for as many iterations as necessary. The more you repeat steps 2 and 3, the closer guess will
 * become to the square root of n.
 *
 * Write a program that inputs an integer for n, iterates through the Babylonian algorithm five times, and outputs the
 * answer as double to two decimal places. Your answer will be most accurate for small values of n.
 *
 */

/* I use Chapter 2 tools to solve this problem. Flow of control is not covered at this point, so solution is messy. */

import java.util.*;

public class Babylonia {
  public static void main (String[] args){

    int n;
    double r, guess;

    System.out.println("Enter an integer value for n");

    Scanner keyboard = new Scanner(System.in);

    n = keyboard.nextInt();

    guess = n/2.0;

    r = n / guess;

    guess = (guess + r) / 2;

    // Repeats steps 2 and 3 five more times.
    r = n / guess;

    guess = (guess + r) / 2;

    r = n / guess;

    guess = (guess + r) / 2;

    r = n / guess;

    guess = (guess + r) / 2;

    r = n / guess;

    guess = (guess + r) / 2;

    r = n / guess;

    guess = (guess + r) / 2;

    System.out.printf("%.2f", r);

  }

}
