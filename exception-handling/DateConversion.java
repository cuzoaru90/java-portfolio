/**
 * Write a program that converts dates from numerical month/day/year format to normal "month day, year" format
 * (for example, 12/25/2000 corresponds to December 25, 2000). You will define three exception classes, one called
 * Month-Exception, another called DayException, and third called YearException. If the user enters anything other than
 * a legal month number (integers from 1 to 12), then your program will throw and catch a DayException and ask the
 * user to reenter the day. If the user enters a year that is not in the range 1000 to 3000 (inclusive), then your
 * program will throw and catch a YearException and ask the user to reenter the year. Keep leap years in consideration
 * when making your program.
 *
 */
import java.util.*;

public class DateConversion {

  enum Month {January, February, March, April, May, June, July, August, September, October, November, December};

  public static void main (String[] args){

    System.out.println("Enter in a date");

    boolean validInput = false;

    Scanner keyboard = new Scanner(System.in);

    int month = 0, day = 0, year = 0;

    while (!validInput){

      try {
        month = keyboard.nextInt();
        day = keyboard.nextInt();
        year = keyboard.nextInt();

        if (month < 1 || month > 12){
          throw new MonthException();
        }

        int maxDays = daysInMonth(month, year);

        if (day < 1 || day > maxDays){
          throw new DayException();
        }

        if (year < 1000 || year > 3000){
          throw new YearException();
        }

        validInput = true;
      }
      catch (InputMismatchException e){
        System.out.println("Input must be an integer");
        keyboard.next();
      }
      catch (MonthException e){
        System.out.println(e.getMessage());
      }
      catch (DayException e){
        System.out.println(e.getMessage());
      }
      catch (YearException e){
        System.out.println(e.getMessage());
      }

    }

    System.out.println(dateString(month, day, year));

  }

  public static int daysInMonth(int month, int year){
    switch(month){
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      case 2:
        if (year % 4 == 0) {
          return 29;
        }
        else {
          return 28;
        }
      default:
        return 31;
    }
  }

  public static String dateString(int month, int day, int year){
    Month[] months = Month.values();

    String monthString = months[month - 1].toString();

    return monthString + " " + day +  ", " + year;

  }

}
