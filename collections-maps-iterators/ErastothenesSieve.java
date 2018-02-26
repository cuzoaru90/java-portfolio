import java.util.*;

/**
 * Program that simulates the Sieve of Erastothenes (https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes).
 * This demonstrates an instance where iterators are actually useful.
 *
 */
public class ErastothenesSieve {

  public static final int LIST_SIZE = 40000;

  public static void main (String[] args){
    ArrayList<Integer> numbers = new ArrayList<Integer>();

    int startingValue = 2;

    while (startingValue <= LIST_SIZE){
      numbers.add(startingValue);
      startingValue++;
    }

    ListIterator<Integer> i;

    int index = 0;

    while (index < numbers.size()){

      i = numbers.listIterator(index);
      int currentPrime = i.next();

      while ( i.hasNext() ){
        if ( i.next() % currentPrime == 0 ){
          i.remove();
        }
      }

      index++;
    }

    i = numbers.listIterator();

    while ( i.hasNext() ){
      System.out.println( i.next() );
    }

  }


}
