/* It is difficult to make a budget that spans several years, because prices are not stable. If your company needs 200
pencils per year, you cannot simply use this year's price as the cost of pencils two years from now. Because of
inflation, the cost is likely to be higher than it is today. Write a program to gauge the expected cost of an item in a
specified number of years. The program asks for the cost of the item, the number of years from now that the item will
be purchased, and the rate of inflation. The program then outputs the estimated cost of the item after the specified
period. Have the user enter the inflation rate as a percentage, such as 5.6 (percent). Your program should then convert
the percent to a fraction, such as 0.056, and should use a loop to estimate the price adjusted for inflation.
 */

import java.util.*;

public class Inflation {
  public static void main (String[]args){

     int numYears = 0;
     double inflationRate, initialCost, expectedCost;

     Scanner keyboard = new Scanner(System.in);

     System.out.println("Enter your item's cost:");
     initialCost = keyboard.nextDouble();

     System.out.println("Enter years from now to be purchased:");
     numYears = keyboard.nextInt();

     System.out.println("Enter inflation rate (as percent value):");
     inflationRate = keyboard.nextDouble() / 100 ;

     // preserves initial cost and expected cost is calculated in for-loop
     expectedCost = initialCost;

     for (int i = 0; i < numYears; i++){
        expectedCost *= (1 + inflationRate);
     }

     System.out.printf("Estimated cost of the item in %d years: $%.2f", numYears, expectedCost);

  }
}
