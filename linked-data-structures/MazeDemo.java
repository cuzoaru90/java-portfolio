import java.util.*;

public class MazeDemo {
  public static void main (String[] args){

    Maze maze = new Maze();
    maze.createRooms();
    maze.generateLinks();

    boolean exitFound = false;

    while (!exitFound) {
      maze.displayLocation();
      maze.move();
      exitFound = maze.exitFound();
    }

    System.out.println("Reached the exit!");

  }


}
