/**
 * An array can be used to store large integers one digit at a time. For example, the integer 1234 could be stored in
 * the array a by setting a[0] to 1, a[1] to 2, a[2] to 3, and a[3] to 4. However, for this exercise you might find it
 * more useful to store the digits backward; that is, place 4 in a[0], 3 in a[1], 2 in a[2], 1 in a[3]. In this exercise,
 * write a program that reads in two positive integers that are 20 or fewer digits in length and then outputs the sum of
 * the two numbers. Your program will read the digits as values of type char so that the number 1234 is read as the
 * four characters '1', '2', '3', and '4'. After they are read into the program, the characters are changed to values of
 * type int.
 *
 * The digits should be read into a partially filled array, and you might find it useful to reverse the order of the
 * elements in the array after the array is filled with data from the keyboard. (Whether or not you reverse the order
 * of the elements in the array is up to you. It can be done either way, and each way has its advantages and
 * disadvantages.)
 *
 * Your program should perform the addition by implementing the usual paper-and-pencil addition algorithm. The result of
 * the addition should be stored in an array of size 20, and the result should then be written to the screen. If the
 * result of the addition is an integer with more than the maximum number of digits (that is, more than 20 digits), then
 * your program should issue a message saying that it has encountered "integer overflow." You should be able to change
 * the maximum length of the integers by changing only one named constant. Include a loop that allows the user to
 * continue to do more additions until the user says the program should end.
 *
 *
 */

import java.util.*;

public class Addition {

  public static final int MAX_ARRAY_SIZE = 20;

  public static void main (String[] args){

    String optionSelect = "";

    do {

      Scanner keyboard = new Scanner(System.in);

      System.out.println("Enter in two integers");

      String input1 = keyboard.next();
      String input2 = keyboard.next();

      char[] inputChars1 = new char[MAX_ARRAY_SIZE];
      char[] inputChars2 = new char[MAX_ARRAY_SIZE];

      storeDigitsBackward(inputChars1, input1, input1.length());
      storeDigitsBackward(inputChars2, input2, input2.length());

      int[] inputSum = addNumbers(inputChars1, inputChars2);

      // outputs sum of arrays
      for (int elem : inputSum) {
        System.out.print(elem);
      }

      System.out.println("\nDo another calculation? Press q to quit.");
      optionSelect = keyboard.next();

    } while ( !optionSelect.equals("q") );

  }

  public static void storeDigitsBackward(char[] arr, String input, int inputLength){
    int arrIndex = 0;

    // fills numChars array with values from index 0 to input length;
    while (arrIndex < inputLength ){
      arr[arrIndex] = input.charAt(inputLength - 1 - arrIndex);
      arrIndex++;
    }

    // remaining array elements need to be filled with 0 for addition method to properly work
    fillWithZero(arr, inputLength);
  }

  public static void fillWithZero(char[] arr, int startIndex){

    while (startIndex < arr.length){
      arr[startIndex] = '0';
      startIndex++;
    }

  }

  public static int[] addNumbers(char[] arr1, char[] arr2 ){
    int[] result = new int[MAX_ARRAY_SIZE];
    int carryOver = 0;

    int counter = 0;

    while (counter < result.length){

      int sum = Character.getNumericValue(arr1[counter]) +
                Character.getNumericValue(arr2[counter]) + carryOver;

      int resultIndex = result.length - 1 - counter; // sums are entered starting from end of array

      result[resultIndex] = sum % 10;

      if (sum / 10 == 1){
        checkForOverflow(resultIndex);
        carryOver = 1;
      }
      else{
        carryOver = 0;
      }

      counter++;
    }

    return result;
  }

  public static void checkForOverflow(int index){
    if (index == 0){
      System.out.println("Encountered integer overflow in the program, try smaller integers. ");
      System.exit(0);
    }
  }

}
