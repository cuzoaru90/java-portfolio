/**
 * Write a program that takes its input from a binary file of numbers of type double. The file contains nothing but
 * numbers of type double written to the file with writeDouble. The program outputs to the screen the average and
 * standard deviation fo the numbers in the file. The standard deviation of a list of numbers n1, n2, n3, and so forth
 * is defined as the square root of the average of the following numbers:
 *
 * (n1 - a)^2, (n2 - a)^2, (n3 - a)^2, and so forth.
 *
 * The number a is the average of the numbers n1, n2, n3, and so forth.
 *
 */

import java.io.*;
import java.util.ArrayList;

public class Numbers {

  public static final int DOUBLES = 40;

  public static void main (String[] args){

    try{
      ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.txt"));

      for (int i = 0; i < DOUBLES; i++){
        double randDouble = (Math.random() * DOUBLES) + 1;
        outputStream.writeDouble(randDouble);
      }

      System.out.println("Doubles written to the file data.txt.");
      outputStream.close();

    }
    catch(IOException e){
      System.out.println("Problem with file output");
      System.exit(0);
    }

    ArrayList<Double> doublesList = new ArrayList<Double>();

    readBinaryFile("data.txt", doublesList);

    double average = calculateMean(doublesList);
    double standardDeviation = calculateStandardDeviation(doublesList, average);

    System.out.printf("Average: %.2f\n", average);
    System.out.printf("Standard deviation: %.2f\n", standardDeviation);

  }

  public static void readBinaryFile(String filename, ArrayList<Double> list){

    try{
      ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));

      // try-catch is necessary for determining end of binary file; unavoidable code smell
      try {
        while (true) {
          double aDouble = inputStream.readDouble();
          list.add(aDouble);
        }
      }
      catch (EOFException e){
        ;
      }

    }
    catch (FileNotFoundException e){
      System.out.println("Problem opening file.");
      System.exit(0);
    }
    catch (IOException e){
      System.out.println("Problem with input from " + filename);
    }

  }

  public static double calculateMean(ArrayList<Double> list){
    double sum = 0;

    for (Double elem: list){
      sum += elem;
    }

    return sum / list.size();
  }

  public static double calculateStandardDeviation(ArrayList<Double> list, double avg){
    double sumOfDistances = 0;

    for (Double elem: list){
      double distanceFromMean = Math.pow(elem - avg, 2);
      sumOfDistances += distanceFromMean;
    }

    double averageOfDistances = sumOfDistances / list.size();

    return Math.sqrt(averageOfDistances);

  }

}
