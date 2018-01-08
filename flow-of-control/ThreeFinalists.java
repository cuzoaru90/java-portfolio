/* You have three identical prizes to give away and a pool of 30 finalists. The finalists are assigned numbers from 1
to 30. Write a program to randomly select the numbers of three finalists to receive a prize. Make sure not to pick
the same number twice. For example, picking finalists 3, 15, 29 would be valid but picking 3, 3, 31 would be invalid
because finalist number 3 is listed twice and 31 is not a valid finalist number. The following line of code can be used
to generate a random number between 1 and 30:

int num = (int) (Math.random() * 30) + 1;

 */

public class ThreeFinalists {
  public static void main (String[] args){

    int finalist1, finalist2, finalist3;
    boolean validWinners = false;

    while (!validWinners){

      finalist1 = (int)(Math.random() * 30) + 1;
      finalist2 = (int)(Math.random() * 30) + 1;
      finalist3 = (int)(Math.random() * 30) + 1;

      if (finalist1 == finalist2 ||
          finalist2 == finalist3 ||
          finalist1 == finalist3)
      {
        // Empty statement; continue loop until valid winners chosen
      }
      else{
        validWinners = true;
        System.out.printf("We have selected %d, %d, %d as winners of our prize",
            finalist1, finalist2, finalist3);
      }

    }

  }
}
