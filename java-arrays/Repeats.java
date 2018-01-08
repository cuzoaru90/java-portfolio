import java.util.ArrayList;

/**
 * Write a static method called deleteRepeats that has a partially filled array of characters as a formal parameter and
 * that deletes all repeated letters from the array. Because a partially filled array requires two arguments, the
 * method should actually have two formal parameters: an array parameter and a formal parameter of type int that gives
 * the number of array positions used. When a letter is deleted, the remaining letters are moved one position to fill
 * in the gap. This creates empty positions at the end of the array so that less of the array is used. Because the
 * formal parameter is a partially filled array, a second formal parameter of type int should tell how many array
 * positions are filled. This second formal parameter cannot be changed by a Java method, so have the method return
 * the new value for this parameter. For example, consider the following code:
 *
 * char a[10];
 * a[0] = 'a';
 * a[1] = 'b';
 * a[2] = 'a';
 * a[3] = 'c';
 * int size = 4;
 * size = deleteRepeats(a, size);
 *
 * After this code is executed, the value of a[0] is 'a', the value of a[1] is 'b', the value of a[2] is 'c', and the
 * value of size is 3. (The value of a[3] is no longer of any concern, because the partially filled array no longer
 * uses this indexed variable.) You may assume that the partially filled array contains only lowercase letters. Write
 * a suitable test program for your method.
 *
 *
 */

public class Repeats {

  public static void main(String[] args){

    char [] charArray = new char[50];

    for (int i = 0; i < charArray.length; i++){
      int ascii = (int) (Math.random() * 26) + 97;
      charArray[i] = (char)ascii;
    }

    for (char c: charArray){
      System.out.print(c);
    }

    System.out.println();

    int newArrSize = deleteRepeats(charArray, 30);

    System.out.println("Modified array");

    printArray(charArray);

    System.out.println("\nNew array size: " + newArrSize);

  }

  public static void shiftArrElements(char [] partialArr, int deletionIndex){
    for (int i = deletionIndex; i < partialArr.length - 1; i++){
      partialArr[i] = partialArr[i+1];
    }
  }

  public static void printArray(char[] arr){
    for (char c: arr){
      System.out.print(c);
    }

    System.out.println();
  }

  public static int numRepeats(char[] arr, char value){
    int charInstances = 0;

    for (char c: arr){
      if (c == value){
        charInstances++;
      }
    }
    return charInstances - 1;
  }

  public static int deleteRepeats(char [] partialArr, int size){

    int lastUsedPosition = size;

    while (lastUsedPosition < partialArr.length){
      partialArr[lastUsedPosition] = '-';
      lastUsedPosition++;
    }

    int arrPosition = 0;

    while (arrPosition < size ) {

      int repeats = numRepeats(partialArr, partialArr[arrPosition]);

      System.out.println( "At letter " + partialArr[arrPosition] + ": " );
      printArray(partialArr);

      while (repeats > 0) {
        for (int i = arrPosition + 1; i < size; i++) {
          if (partialArr[i] == partialArr[arrPosition]) {
            shiftArrElements(partialArr, i);
            repeats--;
            size--;
          }
        }
      }
      arrPosition++;
    }

    return size;
  }

}
