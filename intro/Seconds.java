/* Write a program that outputs the number of hours, minutes, and seconds that corresponds to 50391 total seconds. The
output should be 13 hours, 59 minutes, and 51 seconds. Test your program with a different number of total seconds to
ensure that it works for other cases.
 */

public class Seconds {

  public static void main(String[] args){
    int hours, minutes, seconds, totalSeconds = 50391;

    hours = totalSeconds / (60 * 60);
    minutes = ( totalSeconds % (60 * 60) ) / 60;
    seconds = ( totalSeconds % (60 * 60) ) % 60;

    System.out.println(hours + " hours");
    System.out.println(minutes + " minutes");
    System.out.println(seconds + " seconds");

  }

}
