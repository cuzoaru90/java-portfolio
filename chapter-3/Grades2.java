/*
Write a program that calculate the total grade for N classroom exercises as a percentage. Use the DecimalFormat
Class to output the value as a percent. The user should input the value for N followed by each of the N scores and
totals. Calculate the overall percentage (sum of total points divided by points possible) and output it using the
DecimalFormat class. Sample input and output is shown below (in book).
*/

import java.text.DecimalFormat;
import java.util.*;

public class Grades2 {
  public static void main (String[]args){

    int exercises = 0;
    int totalPoints = 0, totalPossible = 0;

    Scanner keyboard = new Scanner(System.in);

    System.out.println("How many exercises to input?");
    exercises = keyboard.nextInt();

    for (int i = 1; i <= exercises; i++){
      int pointsEarned, pointsPossible;

      System.out.printf("\nScore received for exercise %d\n", i);
      pointsEarned = keyboard.nextInt();

      System.out.printf("Total points possible for exercise %d\n", i);
      pointsPossible = keyboard.nextInt();

      totalPoints += pointsEarned;
      totalPossible += pointsPossible;
    }

    double percentage = totalPoints * 1.0 / totalPossible;
    DecimalFormat percent = new DecimalFormat("0.00%");

    System.out.printf("\nYour total is %d out of %d, or ", totalPoints, totalPossible);
    System.out.println(percent.format(percentage));

  }

}
