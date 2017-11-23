/* In the game of craps, a pass line bet proceeds as follows. Two six-sided dice are rolled; the first roll of the dice
in a craps round is called the "come out roll." A come out roll of 7 or 11 automatically wins, and a come out roll of
2, 3, or 12 automatically loses. If 4,5,6,8,9, or 10 is rolled on the come out roll, that number becomes "the point."
The player keeps rolling the dice until either 7 or the point is rolled. If the point is rolled first, the the player
wins the bet. If a 7 is rolled first, then the player loses.

Write a program that simulates a game of craps using these rules without human input. Instead of asking for a wager, the
program should calculate whether the player would win or lose. The program should simulate rolling the two dice and
calculate the sum. Add a loop so that the program plays 10,000 games. Add counters that count how many times the player
wins, and how many times the player loses. At the end of the 10,000 games, compute the probability of winning and
output this value. Over the long run, who is going to win the most games, you or the house?

Note: To generate a random number x, where 0 <= x < 1, use x = Math.random(). For example, multiplying Math.random()
by 6 and converting to int results in a random integer between 0 and 5.
*/

import java.util.*;
import java.text.DecimalFormat;

public class Craps {
  public static void main(String[] args){

    int diceRoll, wins = 0, losses = 0;

    for (int i = 0; i < 10000; i++) {
      diceRoll = (int) (Math.random() * 6) + 1
          + (int) (Math.random() * 6) + 1;

      switch(diceRoll){
          case 7:
          case 11:
            wins++;
            break;
          case 2:
          case 3:
          case 12:
            losses++;
            break;
          default:
            int point = diceRoll;

           // checks for wins and losses
            boolean gameOver = false;

           // Loop continues until either the roll is equal to "the point" or 7
            while ( !gameOver ){
              diceRoll = (int) (Math.random() * 6) + 1
                   + (int) (Math.random() * 6) + 1;

              if (diceRoll == point ) {
                 gameOver = true;
                 wins++;
              }
              else if (diceRoll == 7) {
                 gameOver = true;
                 losses++;
              }
           } // End of while-loop
           break;
      } // End of switch statement
    } // End of game loop

    System.out.println("wins: " + wins);
    System.out.println("losses: " + losses);

    double winRatio = wins * 1.0 / (wins+losses);

    DecimalFormat percent = new DecimalFormat("0.00%");

    System.out.println("Probability of winning: " + percent.format(winRatio) );

  }

}
