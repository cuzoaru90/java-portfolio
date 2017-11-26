/* The value e^x can be approximated by the sum:

1 + x + (x^2)/2! + (x^3)/3! + ... + (x^n)/n!

Write a program that takes a value x as input and outputs this sum for n taken to be each of the values 1 to 10, 50,
and 100. Your program should repeat the calculation for new values of x until the user says she or he is through. The
expression n! is called the factorial of n and is defined as

n! = 1 * 2 * 3 * ... * n

Use variables of type double to store the factorials (or arrange your calculation to avoid any direct calculation of
factorials); otherwise, you are likely to produce integer overflow, that is, integers larger than Java allows.

*/

/** Math class will not be used */

import java.util.*;

  public class EToTheX {
    public static void main(String[] args) {

      int nInput = 0;
      double xInput = 0;
      boolean programAlive = true;
      String choice = "";

      Scanner keyboard = new Scanner(System.in);

      do {

        double sum = 0;
        System.out.println("Enter a value for x and n");

        xInput = keyboard.nextDouble();
        nInput = keyboard.nextInt();

          // For input value of x, do n iterations of the Taylor series
        for (int i = 0; i <= nInput; i++) {

          // calculated values for x^0 and 0!
          double nthFactorial = 1;
          double nthPower = 1;

          // inner loop for x^n and n!; calculates for n = 1 and higher
          for (int j = 1; j <= i; j++) {
            nthPower *= xInput;
            nthFactorial = nthFactorial * j;
          }

          sum += (nthPower/nthFactorial);

        }

        System.out.printf("Approximated sum of e^%.2f is %.2f\n", xInput, sum);
        System.out.println("Would you like to do another calculation with new values for x and n (q to quit)?");
        choice = keyboard.next();

        if ( choice.equals("q") )
          programAlive = false;

      } while (programAlive);

    }
  }
