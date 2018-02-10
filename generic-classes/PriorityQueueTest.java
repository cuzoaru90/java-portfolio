public class PriorityQueueTest {

  public static void main(String[] args){

    PriorityQueue<Item> queue = new PriorityQueue<Item>();

    for (int i = 0; i < 12; i++){
      int randInt = (int) (Math.random() * 50 + 1);
      int randPriority = (int) (Math.random() * 12 + 1);

      Item anItem = new Item(randInt, randPriority);
      queue.add(anItem);
      System.out.printf("Added %d, %d to the priority queue\n", randInt, randPriority );
    }

    System.out.println();

    int queueItems = queue.getSize();

    while (queueItems > 0){
      queue.remove();
      queueItems = queue.getSize();
    }

  }
  
}
