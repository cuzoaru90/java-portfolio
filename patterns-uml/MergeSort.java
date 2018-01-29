/**
 * Merge sort demo
 *
 *
 */
public class MergeSort {


  public static void main(String[] args){
    double[] arr = {6.5, 3.2, -2, 18, 32, 7.9};

    sort(arr, 0, arr.length - 1);

    for (double elem: arr){
     System.out.print(elem + " ");
    }

  }

  public static void sort(double[] anArray, int begin, int end){

   if ((end - begin) >= 1) {
     int splitIndex = split(anArray, begin, end);
     sort(anArray, begin, splitIndex);
     sort(anArray, splitIndex + 1, end);
     join(anArray, begin, splitIndex, end);
   }


  }

  public static int split(double[] anArray, int begin, int end){
    return (begin + end) / 2;
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

    while (leftIndex <= splitIndex){  // Copy rest of left half
      temp[tempIndex] = anArray[leftIndex];
      tempIndex++;
      leftIndex++;
    }

    while (rightIndex <= end){  // Copy rest of right half
      temp[tempIndex] = anArray[rightIndex];
      tempIndex++;
      rightIndex++;
    }

    for (int i = 0; i < intervalSize; i++){
      anArray[begin + i] = temp[i];
    }

  }


}
