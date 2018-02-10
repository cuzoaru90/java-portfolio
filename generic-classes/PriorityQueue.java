import java.util.ArrayList;

/**
 * Priority queue implementation to work with generic types
 *
 * @param <T>
 */

public class PriorityQueue<T> {

  private ArrayList<Item> queue;

  /**
   * Constructor
   */
  public PriorityQueue(){
    queue = new ArrayList<Item>();
  }

  /**
   * Mutator
   * @param anItem
   */
  public void add(Item anItem){
    queue.add(anItem);
  }


  /**
   * Remove element
   * @return removed element value
   */
  public Item remove(){

    if (queue.isEmpty() ){
      return null;
    }

    int max = 0;
    int maxIndex = 0;

    for (int i = 0; i < queue.size(); i++){
      int priority = queue.get(i).getPriority();

      if (priority > max){
        max = priority;
        maxIndex = i;
      }
    }

    Item maxPriorityItem = queue.get(maxIndex);
    Item result = new Item(maxPriorityItem);
    T data = (T) maxPriorityItem.getData();

    queue.remove(maxPriorityItem);
    System.out.println("Removed " + data + " from the priority queue.");

    return result;

  }

  /**
   * Accessor
   * @return size
   */
  public int getSize(){
    return queue.size();
  }


}
