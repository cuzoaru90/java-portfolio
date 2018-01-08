/**
 * Design a class called BubbleSort that is similar to the class SelectionSort given in Display 6.11. The class
 * BubbleSort will be used in the same way as the class SelectionSort, but it will use the bubble sort algorithm.
 *
 * The bubble sort algorithm checks all adjacent pairs of elements in the array from the beginning to the end and
 * interchanges any two elements that are out of order. This process is repeated until the array is sorted. The
 * algorithm is as follows:
 *
 * Bubble Sort Algorithm to Sort and Array a
 *
 * Repeat the following until the array a is sorted:
 *
 *   for (index = 0; index < a.length - 1; index++)
 *     if (a[index] > a[index+1])
 *       Interchange the values of a[index] and a[index + 1]
 *
 * The bubble sort algorithm is good for sorting an array that is "almost sorted." It is not competitive with other
 * sorting methods for most other situations.
 *
 */

public class BubbleSort {

  public static void sort(double[] arr){

    boolean arraySorted = false;

    while (!arraySorted) {

      for (int index = 0; index < arr.length - 1; index++) {
        if (arr[index] > arr[index + 1]) {
          double temp = arr[index];
          arr[index] = arr[index + 1];
          arr[index + 1] = temp;
        }
      }
      arraySorted = sorted(arr);

    }

  }

  public static boolean sorted(double[] arr){
    for (int index = 0; index < arr.length - 1; index++) {
      if (arr[index] > arr[index + 1]){
        return false;
      }
    }
    return true;
  }

}
