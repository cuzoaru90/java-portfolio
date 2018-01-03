/* Write a program that takes as input the distance of the commute in miles, the automobile's fuel consumption rate
in miles per gallon, and the price of a gallon of gas. The program should then output the cost of the commute.
 */

import java.util.*;

public class Commute {
  public static void main (String [] args){

      double commuteDistance, fuelRate, gasPrice, cost;
      Scanner keyboard = new Scanner(System.in);

      System.out.println("Enter your commute distance in miles:");
      commuteDistance = keyboard.nextDouble();

      System.out.println("Enter your automobile's fuel consumption in miles/gallon:");
      fuelRate = keyboard.nextDouble();

      System.out.println("Enter the price per gallon of gas:");
      gasPrice = keyboard.nextDouble();

      cost = (commuteDistance / fuelRate) * gasPrice;

      System.out.printf("$%.2f", cost);

  }

}
