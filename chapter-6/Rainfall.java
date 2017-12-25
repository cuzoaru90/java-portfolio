/**
 * Write a program that reads in the average monthly rainfall for a city for each month of the year and then reads in
 * the actual monthly rainfall for each of the previous 12 months. The program should then print out a nicely formatted
 * table showing the rainfall for each of the previous 12 months as well as how much above or below average the rainfall
 * was for each month. The average monthly rainfall is given for the months January, February, and so forth, in order.
 * To obtain the actual rainfall for the previous 12 months, the program should first ask what the current month is
 * and then ask for the rainfall figures for the previous 12 months. The output should correctly label the months.
 *
 * There are a variety of ways to deal with the month names. One straightforward method is to code the months as
 * integers and then do a conversion to a string for the month name before doing the output. A large switch statement is
 * acceptable in an output method. The month input can be handled in any manner you wish so long as it is relatively
 * easy and pleasant for the user. Include a loop that allows the user to repeat this entire calculation until the
 * user requests that the program end.
 *
 *
 */

import java.util.*;

public class Rainfall {

  enum MonthOfYear {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER };

  public static void main(String[] args){

    MonthOfYear[] months = MonthOfYear.values();
    String[] monthOfYearStrings = new String[months.length];

    for (int i = 0; i < monthOfYearStrings.length; i++ ){
      monthOfYearStrings[i] = months[i].toString();
    }

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter in the current month.");
    String currentMonth = keyboard.nextLine().toUpperCase();

    int currentMonthIndex = getIndexOfMonth(monthOfYearStrings, currentMonth);
    System.out.println(currentMonthIndex);

    String[] lastTwelveMonths = getLastTwelveMonths(monthOfYearStrings, currentMonthIndex);

    System.out.println("Enter rainfall of the last 12 months starting with " + currentMonth);
    String[] inputStrings = keyboard.nextLine().split(" ");

    double[] rainfallValues = new double[12];

    for (int i = 0; i < inputStrings.length; i++){
      rainfallValues[i] = Double.valueOf(inputStrings[i]);
    }

    Month[] tableEntries = new Month[12];

    for (int i = 0; i < 12; i++){
      tableEntries[i] = new Month(lastTwelveMonths[i], rainfallValues[i] );
    }

    double averageRainfall = calculateAverageRainfall(tableEntries);

    outputTable(tableEntries, averageRainfall);

  }

  public static int getIndexOfMonth(String[] arr, String target){
    for (int i = 0; i < arr.length; i++){
      if ( arr[i].equals(target) ){
        return i;
      }
    }

    return -1;
  }

  public static void outputTable(Month arr[], double averageRain){
    System.out.printf("%-15s %-20s %-20s\n", "Month ", "Rainfall(inches)", "Difference from average");
    for (Month m: arr) {
      System.out.printf("%-20s %-20.2f %-10.2f\n", m.getName(), m.getRainfall(),
              m.getRainfall() - averageRain);
    }
  }

  public static double calculateAverageRainfall(Month[] months){
    double sum = 0;

    for (Month m: months){
      sum += m.getRainfall();
    }

    return sum / months.length;
  }

  public static String[] getLastTwelveMonths(String[] months, int currentMonth){
    String[] result = new String[12];

    for (int i = currentMonth; i < currentMonth + 12; i++){
      result[i - currentMonth] = months[i%12];
    }

    return result;
  }
}
