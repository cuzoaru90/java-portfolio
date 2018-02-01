/**
 * Use the sorting pattern to implement insertion sort. In insertion sort the split method always returns the value
 * (end - 1). This results in splitting the array into two pieces, one with a single value at the end of the array, and
 * the other with everything else. The join method does more work. A precondition for entry into join is that the
 * elements from array[begin] to array[end - 1] will be in sorted order. The method should insert array[end] into the
 * correct spot from array[begin] to array[end] such that sorted order is maintained.
 *
 * For example, if an array contains {2, 4, 6, 8, 5} where begin = 0 and end = 4 then array[end] = 5 and the method
 * should insert the value 5 between the 4 and 6 resulting in {2, 4, 5, 6, 8}
 *
 */

public class InsertionSort {

  public static void main(String[] args){
    double[] arr = {6.5, 3.2, 7.4, 365, -5.4, 80, -.06, 1 };

    sort(arr, 0, arr.length - 1);

    for (double elem: arr){
      System.out.print(elem + " ");
    }

  }

  public static void sort(double[] anArray, int begin, int end){

    if ( (end - begin) >= 1) {
      int splitIndex = split(begin, end);

      sort(anArray, begin, splitIndex);
      join(anArray, begin, splitIndex, end);
    }

  }

  public static int split(int begin, int end){
    return end - 1;
  }

  public static void join(double[] anArray, int begin, int splitIndex, int end){
    double[] temp;
    int intervalSize = (end - begin + 1);
    temp = new double[intervalSize];

    int leftIndex = begin;
    int rightIndex = splitIndex + 1;

    int tempIndex = 0;

    while ((leftIndex <= splitIndex) && (rightIndex <= end) ){
      if (anArray[leftIndex] < anArray[rightIndex]){
        temp[tempIndex] = anArray[leftIndex];
        tempIndex++;
        leftIndex++;
      }
      else{
        temp[tempIndex] = anArray[rightIndex];
        tempIndex++;
        rightIndex++;
      }
    }

    while (leftIndex <= splitIndex){
      temp[tempIndex] = anArray[leftIndex];
      tempIndex++;
      leftIndex++;
    }

    while (rightIndex <= end){
      temp[tempIndex] = anArray[rightIndex];
      tempIndex++;
      rightIndex++;
    }

    for (int i = 0; i < intervalSize; i++){
      anArray[begin + i] = temp[i];
    }

  }


}
