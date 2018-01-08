/**
 * The standard deviation of a list of numbers is a measure of how much the numbers deviate from the average. If the
 * standard deviation is small, the numbers are clustered close to the average. If the standard deviation is large, the
 * numbers are scattered far from the average. The standard deviation of a list of numbers n1, n2, n3, and so forth is
 * defined as the square root of the average of the following numbers:
 *
 * (n1 - a)^2, (n2 - a)^2, (n3 - a)^2, and so forth.
 *
 * The number a is the average of the numbers n1, n2, n3, and so forth.
 *
 * Define a static method that takes a partially filled array of numbers as its argument and returns the standard
 * deviation of the numbers in the partially filled array. Because a partially filled array requires two arguments, the
 * method should actually have two formal parameters, an array parameter and a formal parameter of type int that gives
 * the number of array positions used. The numbers in the array should be of type double. Write a suitable test
 * program for your method.
 */

import java.util.*;

public class StandardDeviation {

  public static void main (String[] args){

    double [] numbers = new double[50];
    int positionsUsed = 0;
    int arrPosition = 0;

    System.out.println("Enter in doubles separated by a space");

    Scanner keyboard = new Scanner(System.in);
    String input = keyboard.next();

    while ( !input.equals("-99") ){
      numbers[arrPosition] = Double.valueOf(input);
      arrPosition++;
      positionsUsed++;

      input = keyboard.next();
    }

    for (double num: numbers){
      System.out.print(num + " ");
    }

    System.out.println('\n' + positionsUsed);

    double avg = calculateAverage(numbers, positionsUsed);
    double standardDeviation = calculateStandardDeviation(numbers, positionsUsed, avg);

    System.out.println(avg);
    System.out.println(standardDeviation);

  }


  public static double calculateAverage(double[] arr, int size){
    double sum = 0;

    for (int i = 0; i < size; i++){
      sum += arr[i];
    }

    return sum / (double)size;
  }

  public static double calculateStandardDeviation(double[] arr, int size, double average){

    double sumOfDistances = 0;

    for (int i = 0; i < size; i++){
      double distanceFromMean = Math.pow(arr[i] - average, 2);
      sumOfDistances += distanceFromMean;
    }

    double averageOfDistances = sumOfDistances / (double)size;

    return Math.sqrt(averageOfDistances);

  }

}
