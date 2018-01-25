/**
 * There are n people in a room, where n is an integer greater than or equal to 1. Each person shakes hands once with
 * every other person. What is total number, h(n) of handshakes? Write a recursive function to solve this problem. To
 * get you started, if there are only one or two people in the room, then:
 *
 * handshake(1) = 0;
 * handshake(2) = 1;
 *
 * If a third person enters the room, she must shake hands with each of the two people already there. This is two
 * handshakes in addition to the number of handshakes that would be made in a room of two people, or a total of three
 * handshakes.
 *
 * If a fourth person enters the room, she must shake hands with each of the three people already present. This is three
 * handshakes that would be made in a room of three people, or six handshakes.
 *
 * If you can generalize this to n handshakes then it should help you write the recursive solution.
 *
 */
import java.util.*;

public class Handshakes {
  public static void main (String[] args){

    int peopleInRoom = 0;

    System.out.println("Enter the number of people in a room");
    Scanner keyboard = new Scanner(System.in);

    try{
      peopleInRoom = keyboard.nextInt();
    }
    catch (InputMismatchException e){
      System.out.println("Please enter an integer value");
      System.exit(0);
    }

    int handshakes = countHandshakes(peopleInRoom);
    System.out.println("Handshakes: " + handshakes);
  }

  public static int countHandshakes(int people){
    if (people <= 1){
      return 0;
    }
    else if (people == 2){
      return 1;
    }
    else{
      return countHandshakes(people - 1) + (people - 1);
    }

  }

}
