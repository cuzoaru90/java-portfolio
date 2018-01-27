import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The formula for computing the number of ways of choosing r different things from a set of n things is the following:
 *
 * C(n, r) = n! / (r!*(n-r)!)
 *
 * The factorial method n! is defined by
 *
 * n! = n*(n-1)*(n-2)*...*1
 *
 * Discover a recursive version of the formula for C(n,r) and write a recursive method that computes the value of the
 * formula. Place the method in a class that has a main that tests the method.
 *
 */

public class SetChoices {

  public static void main (String[] args){

    Scanner keyboard = new Scanner(System.in);
    int n = 0;
    int r = 0;
    int waysToChoose = 0;

    System.out.println("Enter an integer value for set of n things and integer r for number" +
            " of different things in set.");

    try{
      n = keyboard.nextInt();
      r = keyboard.nextInt();

      if (r < 0 || n < 0){
        throw new NegativeNumberException();
      }
      else if (r > n){
        throw new SetOverflowException();
      }

      waysToChoose = numberOfChoices(n, r);
    }
    catch (InputMismatchException e){
      System.out.println("Please enter an integer value");
      System.exit(0);
    }
    catch (NegativeNumberException e){
      System.out.println(e.getMessage());
      System.exit(0);
    }
    catch (SetOverflowException e){
      System.out.println(e.getMessage());
      System.exit(0);
    }

    System.out.printf("Ways to choose %d things from set of %d things = %d", r, n, waysToChoose);

  }

  public static int factorial(int n){
    if (n == 0){
      return 1;
    }
    else if (n == 1){
      return 1;
    }
    else{
      return factorial(n - 1) * n; // another easy solution with suspended calculations and base cases
    }

  }

  public static int numberOfChoices(int n, int r){
    return factorial(n) / ( factorial(r) * factorial(n - r) );
  }



}

