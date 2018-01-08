/* Write a program that determines the change to be dispensed from a vending machine. An item in the machine can cost
between 25 cents and a dollar, in 5-cent increments(25, 30, 35,...90,95 or 100), and the machine accepts only a single
dollar bill to pay for the item.


 */

import java.util.*;

public class VendingMachine {

  public static void main (String [] args){

    int cost, totalChange, quarters, dimes, nickels;

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter in the price of the item (from 25 cents to a dollar, in 5-cent increments):");
    cost = keyboard.nextInt();

    totalChange = 100 - cost;

    quarters = totalChange / 25;
    dimes = (totalChange % 25) / 10;
    nickels = ( (totalChange % 25) % 10 ) / 5;

    System.out.printf("You bought an item for %d cents, and gave me a dollar, so your change is %d quarters," +
             " %d dimes, and %d nickels", cost, quarters, dimes, nickels);

  }

}
