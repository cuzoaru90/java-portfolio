/* One way to estimate the adult height of a child is to use the following formula, which uses the height of the
parents:

H(male_child) = ( height_mother) x (13/12) + H(father) ) / 2
H(female_child) = (  height_father) x (12/13) + H(mother) ) / 2

All heights are in inches. Write a program that takes as input the gender of the child, the height of the mother in
inches, and the height of the father in inches, and outputs the estimated adult height of the child in inches. The
program should allow the user to enter a new set of values and output the predicted height until the user decides to
exit. The user should be able to input the heights in feet and inches, and the program should output the estimated
height of the child in feet and inches. Use the int data type to store the heights.

 */

import java.util.*;

public class AdultHeight {
  public static void main(String[]args){

    int fatherHeight, motherHeight;
    double childHeight = 0;
    boolean programRunning = true;

    String genderInput = "";

    Scanner keyboard = new Scanner(System.in);

    do {
      System.out.println("Enter the gender of the child (m for male, f for female, q to quit)");
      genderInput = keyboard.next().toLowerCase();

      if (genderInput.equals("q")){
         System.out.println("goodbye");
         System.exit(0);
      }

      System.out.println("Enter the height of the mother (in feet and inches):");
      motherHeight = keyboard.nextInt() * 12 + keyboard.nextInt();

      System.out.println("Enter the height of the father (in feet and inches):");
      fatherHeight = keyboard.nextInt() * 12 + keyboard.nextInt();

      if (genderInput.equals("m")){
        childHeight = (motherHeight * (13.0/12) + fatherHeight) / 2;
      }
      else if (genderInput.equals("f")){
        childHeight = (fatherHeight * (12.0/13) + motherHeight) / 2;
      }
      else
        System.out.println("Provided invalid gender, so height is undetermined");

      System.out.printf("Estimated height of the child: %.2f inches\n\n", childHeight);

    } while (programRunning);

  }
}
