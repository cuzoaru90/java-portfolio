import java.util.*;
/**
 * Write a recursive method definition for a static method that has one parameter n of type int and that returns the nth
 * Fibonacci number. The Fibonacci numbers are F(0) is 1, F(1) is 1, F(2) is 2, F(3) is 3, F(4) is 5, and in general
 *
 * F(i+2) = F(i) + F(i+1) for i = 0, 1, 2, ...
 *
 * Place the method in a class that has a main that tests the method.
 *
 *
 */
public class Fibonacci {

  public static void main (String[] args){
    System.out.println("Enter an integer value for n");

    Scanner keyboard = new Scanner(System.in);
    int input = 0;
    int fibonacciResult = 0;

    try{
      input = keyboard.nextInt();
      fibonacciResult = getNumber(input);
    }
    catch (InputMismatchException e){
      System.out.println("Please enter an integer value");
      System.exit(0);
    }

    System.out.printf("F(%d) = %d", input, fibonacciResult);


  }

  public static int getNumber(int n){

    if (n == 0){
      return 1;
    }
    else if (n == 1){
      return 1;
    }
    else{
      return getNumber(n-1) + getNumber(n - 2); // multiplies 1 by suspended calculations
    }

  }

}
