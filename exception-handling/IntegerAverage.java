/**
 * Write a program that calculates the average of N integers. The program should prompt the user to enter the value for
 * N and then afterward must enter all N numbers. If the user enters a non-positive value for N, then an exception should
 * be thrown (and caught) with the message "N must be positive." If there is any exception as the user is entering the
 * N numbers, an error message should be displayed and the user prompted to enter the number again.
 *
 */

import java.util.*;

public class IntegerAverage {
  public static void main (String[] args){

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter in a value for N (number of integers):");

    boolean validInput = false;
    int nIntegers = 0;

    while (!validInput) {
      try {
        nIntegers = keyboard.nextInt();

        if (nIntegers < 0) {
          throw new NegativeNumberException();
        }

        validInput = true;
      }
      catch (NegativeNumberException e) {
        System.out.println(e.getMessage());
      }
      catch (InputMismatchException e){
        System.out.println("N must be an integer");
        keyboard.next();
      }
    }

    System.out.println("Enter each integer separated by a space");

    double average = computeAverage(nIntegers);
    System.out.println(average);

  }

  public static double computeAverage(int numbers){

    double result = 0.0;
    Scanner keyboard = new Scanner(System.in);

    int counter = 0;

    while (counter < numbers){
      try{
        int input = keyboard.nextInt();
        result += input;
        counter++;
      }
      catch (InputMismatchException e){
        System.out.println("N must be an integer");
        keyboard.next();
      }
    }

    return result / numbers;
  }

}
