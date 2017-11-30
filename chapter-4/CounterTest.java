public class CounterTest {
  public static void main (String[] args){

    Counter counter = new Counter();

    for (int i = 0; i < 50; i++) {
      counter.increaseCount();
      counter.displayCount();
    }

    counter.decreaseCount();
    counter.displayCount();

    counter.resetCount();
    counter.displayCount();

    Counter counter2 = new Counter();

    counter2.decreaseCount();
    counter2.displayCount();

  }
}
