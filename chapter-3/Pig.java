/* The game of Pig is a simple two player dice game in which the first player to reach 100 or more points wins.
Players take turns. On each turn a player rolls a six-sided die. After each roll:

If the player rolls a 1, then the player gets no new points and it becomes the other player's turn.

If the player rolls 2 through 6, then he can either:
 ROLL AGAIN or
 HOLD. At this point the sum of all rolls is added to the player's score and it becomes the other player's turn

Write a program that plays the game of Pig, where one player is a human and the other is the computer. When it is the
human's turn, the program should show the score of both players and the previous roll. Allow the human to input "r"
to roll again or "h" to hold.

The computer program should play according to the following rule:
Keep rolling when it is the computer's turn until it has accumulated 20 or more points, then hold. If the computer
wins or rolls a 1, then the turn ends immediately.

Allow the human to roll first. The following line of code can be used to generate a random number between 1 and 6
that can correspond to the dice roll:

int diceroll = (int) (Math.random() * 6) + 1;

*/

import java.util.*;

public class Pig {

  public static void main (String[] args) {

    boolean playerTurn = true, gameOver = false;
    int playerScore = 0, lastTurnPlayerScore = 0, computerScore = 0, lastTurnComputerScore = 0;
    String playerChoice = "";

    Scanner keyboard = new Scanner(System.in);

    do {
      // Player turn logic
      if (playerTurn) {

        int dieRoll = (int) (Math.random() * 6) + 1;
        System.out.println("\nPlayer rolled " + dieRoll);
        playerScore += dieRoll;

        if (dieRoll == 1) {
          System.out.println("You lose all points gained this round; it's computer's turn\n");
          playerTurn = false;
          playerScore = lastTurnPlayerScore;
        }
        else if (playerScore >= 100) {
          System.out.println("Player wins");
          System.exit(0);
        }
        else {
          System.out.println("Player score: " + playerScore);
          System.out.println("Computer score: " + computerScore);
          System.out.println("\nRoll or hold?");
          playerChoice = keyboard.next();

            if (playerChoice.equals("h")) {
              System.out.println("You held your points\n");
              playerTurn = false;
              lastTurnPlayerScore = playerScore;
            }
        }

      } // end of player logic

      // Computer turn logic
      else{

        int dieRoll = (int) (Math.random() * 6) + 1;

        if (dieRoll == 1){
          System.out.println("Computer rolled a 1 and lost all points this round; it's player's turn\n");
          computerScore = lastTurnComputerScore;
          playerTurn = true;
        }
        else if ( computerScore - lastTurnComputerScore >= 20){
          lastTurnComputerScore = computerScore;
          System.out.println("Computer held its points");
          playerTurn = true;
        }
        else{
          computerScore += dieRoll;
        }

        if (computerScore >= 100) {
          System.out.printf("Computer wins with %d points", computerScore );
          gameOver = true;
        }
      } // end of computer logic

    } while (!gameOver);

  }
}
