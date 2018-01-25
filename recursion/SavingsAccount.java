/**
 * A savings account typically accrues savings using compound interest. If you deposit $1,000 with a 10% interest rate
 * per year, then after one year you have a total of $1,100. If you leave this money in the account for another year at
 * 10% interest, then after two years the total will be $1,210. After three years you would have $1,331, and so on.
 *
 * Write a program that inputs the amount of money to deposit, and interest rate per year, and the number of years the
 * money will accrue compound interest. Write a recursive function that calculates the amount of money that will be in
 * the savings account using the input information.
 *
 * To verify your function, the amount should be equal to P(1 + i)^n, where P is the amount initially saved, i is the
 * interest rate per year, and n is the number of years.
 *
 *
 */
import java.util.*;

public class SavingsAccount {

  public static final double INTEREST_RATE = 0.1;

  public static void main (String[] args){

    System.out.println("Enter in an initial deposit amount followed by years of interest to be accrued");

    Scanner keyboard = new Scanner(System.in);

    double finalSavings = 0;
    double deposit = 0;
    int years = 0;

    try {
      deposit = keyboard.nextDouble();
      years = keyboard.nextInt();
      finalSavings = calculateSavings(deposit, years);
    }
    catch(InputMismatchException e){
      System.out.println("Please input a proper value");
      System.exit(0);
    }

    System.out.printf("Savings balance after %d years is $%.2f\n", years, finalSavings);

  }

  public static double calculateSavings(double deposit, int years){

    if (years == 0){
      return deposit;
    }
    else if (years == 1){
      return deposit * (1 + INTEREST_RATE); // base case for years >= 1
    }
    else{
      // suspended calculations accrue interest on initial deposit after the else-if (base case) was reached
      return calculateSavings(deposit, years - 1) * (1 + INTEREST_RATE);
    }

  }


}
