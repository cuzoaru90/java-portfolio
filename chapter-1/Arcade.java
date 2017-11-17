/* The video game machines at your local arcade output coupons according to how well you play the game.
You can redeem 10 coupons for a candy bar or 3 coupons for a gumball. You prefer candy bars to gumballs.

Write a program that defines a variable initially assigned to the number of coupons you win. Next, the program should
output how many candy bars and gumballs you can get if you spend all of your coupons on candy bars first, and any
remaining coupons on gumballs.
*/


/* I use Chapter 1 tools to solve this problem */

public class Arcade {

  public static void main(String[] args){

    int couponsWon = 148; // random value inserted for this based on my interpretation of the problem
    int candybars = couponsWon / 10;
    int gumballs = (couponsWon % 10) / 3;

    System.out.println("You won " + candybars + " candybars and "
            + gumballs + " gumballs");

  }

}
