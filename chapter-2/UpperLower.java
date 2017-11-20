/* Write a program that reads in a line of text and then outputs that line of text first in all uppercase letters
and then in all lowercase letters.
*/

import java.util.*;

public class UpperLower {

  public static void main (String [] args){
    String inputLine = "";
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter in a line of text (it will be returned in both uppercase and lowercase):");
    inputLine = keyboard.nextLine();

    System.out.println( inputLine.toUpperCase() );
    System.out.println( inputLine.toLowerCase() );
  }

}
