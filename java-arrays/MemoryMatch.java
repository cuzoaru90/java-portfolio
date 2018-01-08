/** A common memory matching game played by young children is to start with a deck of cards that contain identical
 * pairs. For example, given six cards in the deck, two might be labeled 1, two labeled 2, and two labeled 3. The
 * cards are shuffled and placed face down on the table. A player then selects two cards that are face down, turns them
 * face up, and if the cards match they are left face up. If the two cards do not match they are returned to their
 * original face down position. The game continues until all cards are face up.
 *
 * Write a program that plays the memory matching game. Use sixteen cards that are laid out in a 4x4 square and are
 * labeled with pairs of numbers form 1 to 8. Your program should allow the player to specify the cards that she would
 * like to select through a coordinate system.
 *
 * For example, in the follow layout:
 *
 *      1 2 3 4
 *     ---------
 *  1 | 8 * * *
 *  2 | * * * *
 *  3 | * 8 * *
 *  4 | * * * *
 *
 *  All of the face down cards are indicated by *. The pairs of 8 which are face up are at coordinates (1,1) and (2,3).
 *  To hide the cards that have been temporarily placed face up, output a large number of newlines to force the old
 *  board off the screen.
 *
 *  Hint: Use a 2D array for the arrangement of cards and another 2D array that indicates if a card is face up or face
 *  down. Or, a more elegant solution is to create a single 2D array where each element is an object that stores both
 *  the card's value and face. Write a function that "shuffles" the cards in the array by repeatedly selecting two
 *  cards at random and swapping them.
 *
 *
 */

import java.util.*;

public class MemoryMatch {

  public static void main(String[] args) {

    Card[][] deck = new Card[4][4];

    for (int row = 0; row < deck.length; row++){

      for (int column = 0; column < deck[0].length; column++){
        if (row % 2 == 0) {
          deck[row][column] = new Card(column + 1, false);
        }
        else{
          deck[row][column] = new Card((column + 5), false);
        }
      }

    }

    shuffle(deck);

    boolean allFaceUp = false;

    Scanner keyboard = new Scanner(System.in);

    while (!allFaceUp) {

      System.out.println("Enter in the coordinates of first card (separate with comma (no whitespace)):");
      String selectionOne = keyboard.nextLine();
      String[] coordinates = selectionOne.split(", ");

      int x1 = Integer.parseInt(coordinates[0]);
      int y1 = Integer.parseInt(coordinates[1]);

      System.out.println("Enter in the coordinates of second card (separate with comma (no whitespace)):");
      String selectionTwo = keyboard.nextLine();
      String[] coordinatesTwo = selectionTwo.split(", ");

      int x2 = Integer.parseInt(coordinatesTwo[0]);
      int y2 = Integer.parseInt(coordinatesTwo[1]);

      if ( validCoordinates(x1,y1,x2,y2) ) {
        Card.makeMatch(deck[x1 - 1][y1 - 1], deck[x2 - 1][y2 - 1]);
      }
      else {
        System.out.println("Invalid coordinates detected, please enter a number from 1 to 4.");
      }

      displayDeck(deck);

      if ( allFaceUp(deck) ){
        System.exit(0);
      }

    }
  }


  public static void displayDeck(Card[][] arr){
    for (int row = 0; row < arr.length; row++){
      for (int column = 0; column < arr[0].length; column++ ){
        System.out.print(arr[row][column]);
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void shuffle(Card[][] arr){

    for (int row = 0; row < arr.length; row++){
      for (int column = 0; column < arr[0].length; column++ ){
        int xCoordinate = (int) (Math.random() * 4);
        int yCoordinate = (int) (Math.random() * 4);

        arr[row][column].swap(arr[xCoordinate][yCoordinate]);
      }
    }
  }

  public static boolean validCoordinates(int n1, int n2, int n3, int n4){
    return (
            (n1 > 0 && n1 < 5) &&
                    (n2 > 0 && n2 < 5) &&
                    (n3 > 0 && n3 < 5) &&
                    (n4 > 0 && n4 < 5)
    );

  }

  public static boolean allFaceUp(Card[][] arr){
    for (int row = 0; row < arr.length; row++){
      for (int column = 0; column < arr[0].length; column++ ){
        boolean faceUp = arr[row][column].getFace();
        if (!faceUp){
          return false;
        }
      }
    }
    return true;
  }

}
