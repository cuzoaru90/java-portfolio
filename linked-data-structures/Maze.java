import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze {

  // inner Node class
  public class Node<T>{

    private T data;
    private Node north, east, west, south;

    public Node(T newData){
      data = newData;
    }

  } // end of inner class

  private Node location;
  private ArrayList<Node> rooms;

  /**
   * Constructor
   */
  public Maze(){
    rooms = new ArrayList<Node>();
  }

  /**
   * Creates nodes (rooms)
   */
  public void createRooms(){
    int charIndex = 65;

    while (charIndex < 77) {
      String letter = Character.toString((char) charIndex);
      Node room = new Node(letter);
      rooms.add(room);

      charIndex++;
    }

    location = rooms.get(0);

  }

  /**
   * Assigns links to created nodes (rooms)
   */
  public void generateLinks(){

    Scanner inputStream = null;

    try{
      inputStream = new Scanner(new FileInputStream("rooms.txt"));
    }
    catch (FileNotFoundException e){
      System.out.println("Problem opening file.");
      System.exit(0);
    }

    String line = "";

    for (Node room: rooms){
      line = inputStream.nextLine();

      String[] fields = line.split(" ");
      room.north = getIndexOf(fields[1]);
      room.east = getIndexOf(fields[2]);
      room.west = getIndexOf(fields[3]);
      room.south = getIndexOf(fields[4]);
    }

    inputStream.close();

  }

  /**
   * Finds index of room with the letter parameter and returns the room
   * @param letter
   * @return room at found index
   */
  public Node getIndexOf(String letter){
    for (Node room: rooms){
      if (letter.equals(room.data)){
        return room;
      }
    }
    return null;
  }

  /**
   * Shows location and possible movement options
   */
  public void displayLocation(){
    System.out.println("You are in room " + location.data + " of the maze");
    System.out.println( "You can move " + getMoves() );
  }

  /**
   * Show rooms; for debugging purposes
   */
  public void displayRooms(){
    for (Node room: rooms){
      System.out.println(room.data);
    }
  }

  /**
   * Gets string of possible movement directions
   * @return moves
   */
  public String getMoves(){
    String links = "";

    if (location.north != null){
      links += "north ";
    }

    if (location.east != null){
      links += "east ";
    }

    if (location.west != null){
      links += "west ";
    }

    if (location.south != null){
      links += "south";
    }

    return links;

  }

  /**
   * Takes string as input, and gets corresponding direction
   * @param direction
   * @return Destination room
   */
  public Node getDestination(String direction){

    if (direction.toUpperCase().equals("N")){
      return location.north;
    }
    else if (direction.toUpperCase().equals("E")) {
      return location.east;
    }
    else if (direction.toUpperCase().equals("W")) {
      return location.west;
    }
    else if (direction.toUpperCase().equals("S")) {
      return location.south;
    }

    return null;

  }

  /**
   * Updates location if move successful
   */
  public void move(){

    Scanner keyboard = new Scanner(System.in);

    String direction = "";
    Node destination = null;

    while (destination == null) {

      direction = keyboard.next();
      destination = getDestination(direction);

      if (destination != null) {
        location = destination;
      }
      else {
        System.out.println("Invalid input for move, try again");
      }

    }

  }

  /**
   * Checks if exit/end has been reached
   * @return Boolean value from expression
   */
  public boolean exitFound(){

    if ( location.data.equals("L") ){
      return true;
    }

    return false;
  }

}
