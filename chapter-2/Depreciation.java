/* The straight-line method for computing the yearly depreciation in value D for an item is given by the formula

D = (P - S) / Y

where P is the purchase price, S is the salvage value, and Y is the number of years the item is used. Write a program
that takes as input the purchase price of an item, the expected number of years of service, and the expected salvage
value. The program should then output the yearly depreciation for the item.
*/

import java.util.*;

public class Depreciation {
  public static void main (String[] args){

    int yearsUsed;
    double depreciation, price, salvageValue;

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter the price of your item:");
    price = keyboard.nextDouble();

    System.out.println("Enter the expected years of service:");
    yearsUsed = keyboard.nextInt();

    System.out.println("Enter the predicted salvage value:");
    salvageValue = keyboard.nextDouble();

    depreciation = (price - salvageValue) / yearsUsed;

    System.out.printf("The item's yearly depreciation is %.2f", depreciation);


  }
}
