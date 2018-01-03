/* The Fibonacci numbers F(n) are are defined as follows: F(0) is 1, F(1) is 1, and F(i+2) = F(i) + F(i+1)
i = 0, 1, 2,...

In other words, each number is the sum of the previous two numbers. The first few Fibonacci numbers are 1,1,2,3,5, and
8. One place where these numbers occur is as certain population growth rates. If a population has no deaths, then the
series shows the size of the population after each time period. It takes an organism two time periods to mature to
reproducing age, and then the organism reproduces once every time period. The formula applies most straightforwardly
to asexual reproduction at a rate of one offspring per time period. In any event, the green crud population grows at
this rate and has a time period of 5 days. Hence, if a green crud population starts out as 10 pounds of crud, then in
5 days, there is still 10 pounds of crud; in 10 days, there is 20 pounds of crud; in 15 days, 30 pounds; in 20 days,
50 pounds; and so forth.

Write a program that takes both the initial size of a green crud population (in pounds) and a number of days as input
and outputs the number of pounds of green crud after that many days. Assume that the population size is the same for
4 days and then increases every fifth day. Your program should allow the user to repeat this calculation as often as
desired.

 */
import java.util.*;

public class Fibonacci {
  public static void main(String[] args){

    int populationInput = 0, totalPopulation = 0, days = 0;
    boolean programRunning = true;
    String choice = "";
    Scanner keyboard = new Scanner(System.in);

    do {
      System.out.println("Enter in the initial size of the green crud population (in pounds): ");
      populationInput = keyboard.nextInt();

      System.out.println("Enter the number of days over which the population will grow: ");
      days = keyboard.nextInt();

      int precedingTotal = 0;
      int lastTotal = populationInput;

      for (int i = 0; i <= days; i+=5 ){
        totalPopulation = precedingTotal + lastTotal;
        precedingTotal = lastTotal;
        lastTotal = totalPopulation;
      }

      System.out.printf("Population after %d days is %d pounds\n", days, totalPopulation);
      System.out.println("Do you want to do another calculation? Press q to quit.");

      totalPopulation = 0;
      choice = keyboard.next();

      if ( choice.equals("q") )
        programRunning = false;

    } while (programRunning);

  }

}
