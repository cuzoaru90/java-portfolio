public class BubbleSortTest {

  public static final int MAX_ARRAY_SIZE = 50;

  public static void main (String[] args){
    double [] numbers = {5.2, 1.3, 2.4, 7.6, -3.42, 54, 2.2, 7.2};

    BubbleSort.sort(numbers);

    for (double elem: numbers){
      System.out.print(elem + ", ");
    }

    System.out.println();

  }

}
