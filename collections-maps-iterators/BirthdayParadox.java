import java.util.*;

/**
 * Program that simulates the Birthday paradox (https://en.wikipedia.org/wiki/Birthday_problem).
 * This demonstrates the usefulness of the HashSet class.
 *
 */
public class BirthdayParadox {

  // Change these to experiment with different values
  public static final int PEOPLE_IN_ROOM = 30;
  public static final int TRIALS = 6000;

  public static void main (String[] args){

    int sameBirthdayCount = 0;

    for (int trial = 0; trial < TRIALS; trial++) {
      HashSet<Integer> birthdays = new HashSet<Integer>();

      for (int people = 0; people < PEOPLE_IN_ROOM; people++) {
        int birthday = (int) ((Math.random() * 365) + 1);
        birthdays.add(birthday);
      }

      if ( birthdays.size() < PEOPLE_IN_ROOM ){
        sameBirthdayCount++;
      }
    }

    double probability = (double)sameBirthdayCount / TRIALS;

    System.out.printf("For %d people, the probability of at least two birthdays is %.3f",
            PEOPLE_IN_ROOM, probability);

  }

}
