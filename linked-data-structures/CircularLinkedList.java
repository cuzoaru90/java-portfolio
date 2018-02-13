public class CircularLinkedList<T> {

  // inner Node class; allows variables to be used in place of accessor/mutators (for linked list class)
  public class Node<T> {

    private T data;
    private Node<T> prevLink;
    private Node<T> nextLink;

    /**
     * Constructor
     */
    public Node() {
      prevLink = null;
      nextLink = null;
    }

    /**
     * Constructor
     * @param newData
     * @param prev
     * @param next
     */
    public Node(T newData, Node<T> prev, Node<T> next) {
      data = newData;
      prevLink = prev;
      nextLink = next;
    }

    /**
     * toString method
     * @return String representation
     */
    public String toString(){
      return "Value:" + data + ", Previous: " + prevLink.data +
              ", Next: " + nextLink.data;
    }

    /**
     * May be useful for Strings and characters
     * @param otherObject
     * @return boolean value from expression
     */
    public boolean equals(Object otherObject){
      Node<T> otherData = (Node<T>)otherObject;
      return data.equals(otherData.data);
    }

  } // end of inner class

  private Node<T> head;

  /**
   * Constructor
   */
  public CircularLinkedList(){
    head = null;
  }

  /**
   * Insert data to front of list and updates links
   * @param data
   */
  public void add(T data){

    if (head == null){
      head = new Node<T>(data, null, null);
    }
    else{
      Node<T> aNode = new Node<T>(data, null, head);
      head.prevLink = aNode;
      head = aNode;
    }

  }

  /**
   * Links last node to head, so that list is circular
   */
  public void linkToHead() {
    Node<T> position = head;
    Node<T> lastNode = null;

    while (position != null) {

      if (position.nextLink == null){
        lastNode = position;
      }

      position = position.nextLink;
    }

    lastNode.nextLink = head;
    head.prevLink = lastNode;
  }

  /**
   * Accessor method
   * @return Size of linked list
   */
  public int size(){

    Node<T> position = head;
    int count = 0;

    while (position.nextLink != null) {

      if ( position.nextLink.data == head.data ){
        return count;
      }

      position = position.nextLink;
      count++;
    }

    return 0; // keep compiler happy

  }

  /**
   * Accessor and mutator; removes requested data from list and updates links
   * @param data
   * @return removedNode
   */
  public Node removeNode(T data){

    Node<T> position = head;

    while (position.nextLink != null) {

      if (data == position.data){
        Node prev = position.prevLink;
        Node next = position.nextLink;

        prev.nextLink = next;
        next.prevLink = prev;

        if (data == head.data){
          head = prev;
        }

        return position;
      }
      else if (position.nextLink == head){
        System.out.println("Data not found in the linked list");
        return null;
      }

      position = position.nextLink;
    }

    return null; // keep compiler happy
  }

  /**
   * Mutator; removes an element every three steps/rounds until only one is left
   */
  public void startElimination(){

    int items = size();
    int count = 1;

    Node<T> position = head;

    while (items > 0){

      if ( (count % 3 == 0) && count > 0 ){
        Node eliminated = removeNode(position.data);
        System.out.println("Eliminated " + eliminated.data);
      }

      position = position.nextLink;
      count++;
      items = size();
    }

    System.out.println(head.data + " is the winner");

  }


}

