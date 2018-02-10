/**
 * Generic item class
 *
 * @param <T>
 */

public class Item<T>{
  private T data;
  private int priority;

  /**
   * Constructor
   * @param newData
   * @param newPriority
   */
  public Item(T newData, int newPriority){
    data = newData;
    priority = newPriority;
  }

  /**
   * Copy constructor
   * @param anotherItem
   */
  public Item(Item<T> anotherItem){
    data = anotherItem.data;
    priority = anotherItem.priority;
  }

  /**
   * Accessor
   * @return priority
   */
  public int getPriority(){
    return priority;
  }

  /**
   * Accessor
   * @return data
   */
  public T getData(){
    return data;
  }



}

