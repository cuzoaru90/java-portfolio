/* One way to measure the amount of energy that is expended during exercise is to use metabolic equivalents (MET).
Here are some METS for various activities:

Running 6 MPH: 10 METS
Basketball: 8 METS
Sleeping: 1 MET

The number of calories burned per minute may be estimated using the formula:
Calories/Minute = 0.0175 * MET * Weight in kilograms

Write a program that calculates and outputs the total number of calories burned for a 150-pound person who runs 6 MPH
for 30 minutes, plays basketball for 30 minutes, and then sleeps for 6 hours. One kilogram is equal to 2.2 pounds.

*/

/* I use Chapter 1 tools to solve this problem */

public class Energy{

  public static void main (String [] args){

    double caloriesBurned, weightKg = (150/2.2);

      caloriesBurned = (0.0175 * 10 * weightKg) * 30
              + (0.0175 * 8 * weightKg) * 30
              + (0.0175 * 1 * weightKg) * (30 * 6);

      System.out.println(caloriesBurned);

    }

}