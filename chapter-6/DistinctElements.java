/**
 * Write a program that reads numbers from the keyboard into an array of type int[]. You may assume that there will be
 * 50 or fewer entries in the array. Your program allows any number of numbers to be entered, up to 50 numbers. The
 * output is to be a two-column list. The first column is a list of the distinct array elements; the second column is
 * the count of the number of occurrences of each element. The list should be sorted on entries in the first column,
 * largest to smallest.
 *
 * For the array
 *
 * -12 3 -12 4 1 -12 1 -1 1 2 3 4 2 3 -12
 *
 * the output should be
 *  N   Count
 *  4     2
 *  3     3
 *  2     2
 *  1     4
 * -1     1
 * -12    4
 *
 * I solve this and other problems without the use of the ArrayList Class.
 *
 */

import java.util.*;

public class DistinctElements {

  public static void main (String[] args){

    int [] numbers = new int[50];

    int positionsUsed = 0;

    System.out.println("Enter up to 50 integers separated by a space");

    Scanner keyboard = new Scanner(System.in);
    int input = keyboard.nextInt();

    while (input != -99){
      numbers[positionsUsed] = input;
      positionsUsed++;
      input = keyboard.nextInt();
    }

    int [] distinctElements = new int[positionsUsed];
    int distinctIndex = 0;

    for (int i = 0; i < distinctElements.length; i++){
      if ( !contains(distinctElements, numbers[i]) ){
        distinctElements[distinctIndex] = numbers[i];
        distinctIndex++;
      }
    }

    int [] distinctEntries = new int[distinctIndex];

    for (int i = 0; i < distinctEntries.length; i++){
      distinctEntries[i] = distinctElements[i];
    }

    Arrays.sort(distinctEntries);
    reverseArray(distinctEntries);

    printList(distinctEntries, numbers);

  }

  public static int numOccurrences(int[] arr, int value){
    int occurrences = 0;

    for (int elem: arr){
      if (elem == value){
        occurrences++;
      }
    }

    return occurrences;
  }

  public static boolean contains(int[]arr, int value){
    for (int element: arr){
      if (element == value){
        return true;
      }
    }
    return false;
  }

  public static void reverseArray(int[] arr){

    if (arr == null) {
      return;
    }

    int i = 0;
    int j = arr.length - 1;

    while (j > i) {
      int temp = arr[j];
      arr[j] = arr[i];
      arr[i] = temp;
      j--;
      i++;
    }
  }

  public static void printList(int[] arr, int[] originalInput ){

    System.out.printf("%5s %8s\n", "N", "Count");

    for (int elem: arr){
      int occurrences = numOccurrences(originalInput, elem);
      System.out.printf("%5d %5d\n", elem, occurrences);
    }
  }

}
