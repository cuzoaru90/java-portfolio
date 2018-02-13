import java.util.*;

/**
 * Demonstration program for the circular linked list class.
 * User inputs a number of items to be in the list, and every third item is eliminated until there is only
 * one item left.
 *
 */

public class Elimination {

  public static void main(String[] args){

    CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();

    System.out.println("Enter in number of items to be in the list:");

    Scanner keyboard = new Scanner(System.in);
    int items = 0;

    try{
      items = keyboard.nextInt();
    }
    catch (InputMismatchException e){
      System.out.println("Input must be an integer");
      System.exit(0);
    }

    int counter = items;

    while (counter > 0){
      list.add(counter);
      counter--;
    }

    list.linkToHead();

    list.startElimination();

  }


}
