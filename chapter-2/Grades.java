/*
Write a program that calculate the total grade for three classroom exercises as a percentage. Use the DecimalFormat
Class to output the value as percent. The scores should be summarized in a table. Input the assignment information in
this order: name of assignment (may include spaces), point earned (integer), and total points possible (integer). The
percentage is the sum of the total points earned divided by the total points possible. Sample input and output is shown
below (in book).
*/

import java.text.DecimalFormat;
import java.util.*;

public class Grades {
  public static void main (String [] args){

      String exercise1, exercise2, exercise3;
      int score1, score2, score3, totalScore;
      int possible1, possible2, possible3, totalPossible;
      double percentage;

      Scanner keyboard = new Scanner(System.in);

      System.out.println("Name of exercise 1:");
      exercise1 = keyboard.nextLine();
      System.out.println("Score received for exercise 1:");
      score1 = keyboard.nextInt();
      keyboard.nextLine(); // Inserted after nextInt to resolve input issues
      System.out.println("Total points possible for exercise 1:");
      possible1 = keyboard.nextInt();
      keyboard.nextLine();

      System.out.println("Name of exercise 2:");
      exercise2 = keyboard.nextLine();
      System.out.println("Score received for exercise 2:");
      score2 = keyboard.nextInt();
      keyboard.nextLine(); // Inserted after nextInt to resolve input issues
      System.out.println("Total points possible for exercise 2:");
      possible2 = keyboard.nextInt();
      keyboard.nextLine();

      System.out.println("Name of exercise 3:");
      exercise3 = keyboard.nextLine();
      System.out.println("Score received for exercise 3:");
      score3 = keyboard.nextInt();
      keyboard.nextLine(); // Inserted after nextInt to resolve input issues
      System.out.println("Total points possible for exercise 3:");
      possible3 = keyboard.nextInt();
      keyboard.nextLine();

      totalScore = score1 + score2 + score3;
      totalPossible = possible1 + possible2 + possible3;
      percentage = totalScore * 1.0 / totalPossible;

      System.out.printf("%-30s %-10s %-20s\n", "Exercise", "Score", "Total Possible");
      System.out.printf("%-30s %-10d %-10d\n", exercise1, score1, possible1);
      System.out.printf("%-30s %-10d %-10d\n", exercise2, score2, possible2);
      System.out.printf("%-30s %-10d %-10d\n", exercise3, score3, possible3);
      System.out.printf("%-30s %-10d %-10d\n", "Total", totalScore, totalPossible);

      DecimalFormat percent = new DecimalFormat("0.00%");

      System.out.printf("\nYour total is %d out of %d, or ", totalScore, totalPossible );
      System.out.println( percent.format(percentage) );
  }
}
