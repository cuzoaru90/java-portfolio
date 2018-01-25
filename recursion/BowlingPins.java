import java.util.*;

/**
 * Consider a frame of bowling pins shown below, where each * represents a pin:
 *       *
 *      * *
 *     * * *
 *    * * * *
 *   * * * * *
 *
 * There are five rows and a total of fifteen pins.
 *
 * If we only had the top four rows then there would be a total of 10 pins.
 * If we had only the top three rows then there would be a total of 6 pins.
 * If we had only the top two rows then there would be a total of 3 pins.
 * If we had only the top row then there would be a total of 1 pin.
 *
 * Write a recursive function that takes as input the number of rows n and outputs the total number of pins that would
 * exist in a pyramid with n rows. Your program should allow for values of n that are larger than 5.
 *
 */

public class BowlingPins {

  public static void main (String[] args){

    System.out.println("Enter the number of rows in bowling pin frame");
    Scanner keyboard = new Scanner(System.in);

    int rows = 0;
    int totalPins = 0;

    try{
      rows = keyboard.nextInt();
      totalPins = countBowlingPins(rows);
    }
    catch (InputMismatchException e){
      System.out.println("Please enter an integer value");
      System.exit(0);
    }

    System.out.println("Total pins: " + totalPins);

  }

  public static int countBowlingPins(int rows){
    if (rows == 0){
      return 0;
    }
    else if (rows == 1){
      return 1;
    }
    else{
      return countBowlingPins(rows - 1) + rows;
    }

  }

}
