/* Write a program that reads in two integers typed on the keyboard and outputs their sum, difference, and product. */

import java.util.*;

public class TwoIntegers {

  public static void main (String [] args){

    int num1, num2;
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter two integers for the input:");
    num1 = keyboard.nextInt();
    num2 = keyboard.nextInt();

    int sum = num1 + num2, difference = num1 - num2, product = num1 * num2;

    System.out.println("Sum: " + sum);
    System.out.println("Difference: " + difference);
    System.out.println("Product: " + product);

  }
}
