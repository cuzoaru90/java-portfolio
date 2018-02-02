/**
 * Recursive binary search for Comparable objects
 *
 */
public class ComparableBinarySearch {

  public static void main(String[] args){

    // Wrapper classes automatically implement Comparable interface
    Integer[] numbers = {-10, -6, -2, 1, 4, 7, 9};
    Double[] doubles = {-4.5, -2.65, -0.5, -.009, 6.3, 11.56, 31.7, 78.4, 298.6};


    for (int i = -10; i < 10; i++){
      int intResult = search(numbers, 0, numbers.length - 1, i);

      if (intResult > -1){
        System.out.println(i + " found at index " + intResult);
      }
      else{
        System.out.println(i + " not found in the array ");
      }
    }

  }

  public static int search(Comparable[] collection, int firstIndex, int lastIndex, Comparable key){
    int result = 0;

    if (firstIndex > lastIndex){
      result = -1;
    }
    else{
      int midIndex = (firstIndex + lastIndex) / 2;

      if (key.compareTo(collection[midIndex]) == 0){
        result = midIndex;
      }
      else if (key.compareTo(collection[midIndex]) < 0 ){
        result = search(collection, firstIndex, midIndex - 1, key);
      }
      else if (key.compareTo(collection[midIndex]) > 0 ){
        result = search(collection, midIndex + 1, lastIndex, key);
      }
    }

    return result;

  }

}
