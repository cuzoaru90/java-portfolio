import java.util.*;
public class OrganismTest {

  public static void main (String[] args) {

    Cell[][] critterWorld = new Cell[20][20];

    createWorld(critterWorld);

    // Partially filled arrays aren't cutting it anymore
    ArrayList<Doodlebug> doodlebugs = new ArrayList<Doodlebug>();
    ArrayList<Ant> ants = new ArrayList<Ant>();

    while (doodlebugs.size() < 5 || ants.size() < 100) {

      int critterCoordinates = (int) (Math.random() * 400);
      int row = critterCoordinates / 20;
      int column = critterCoordinates % 20;

      if (!critterWorld[row][column].isOccupied() && ants.size() < 100) {
        Cell currentCell = critterWorld[row][column];
        Ant anAnt = new Ant();

        anAnt.assignCell(currentCell);
        ants.add(anAnt);
        currentCell.update(anAnt, true);
      }
      else if (!critterWorld[row][column].isOccupied() && doodlebugs.size() < 5) {
        Cell currentCell = critterWorld[row][column];
        Doodlebug aDoodleBug = new Doodlebug();

        aDoodleBug.assignCell(currentCell);
        doodlebugs.add(aDoodleBug);
        currentCell.update(aDoodleBug, true);
      }

    }

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter a number of time steps");
    int timeSteps = keyboard.nextInt();

    int counter = 0;

    do {

      displayWorld(critterWorld);

      System.out.println("Doodlebugs: " + doodlebugs.size());
      System.out.println("Ants: " + ants.size());

      moveDoodlebugs(doodlebugs, ants, critterWorld);

      starveDoodlebugs(doodlebugs);
      // Breed during every eighth time step
      if ( (counter > 0) && counter % 8 == 0) {
        breedDoodlebugs(doodlebugs, critterWorld);
      }
      // moveAnts()

      counter++;

    } while (counter < timeSteps);


  }


  public static void createWorld(Cell[][] critters){
    for (int row = 0; row < 20; row++){
      for (int column = 0;  column < 20; column++){
        Cell aCell = new Cell();
        critters[row][column] = aCell;
        aCell.setCoordinates(row, column);
      }
    }
  }


  public static void displayWorld(Cell[][] critters){
    for (Cell[] row: critters){
      for (Cell c: row){
        System.out.print(c);
      }
      System.out.println();
    }
  }

  public static void moveDoodlebugs(ArrayList<Doodlebug> bugs, ArrayList<Ant> ants, Cell[][] world){

    for (int i = 0; i < bugs.size(); i++){

      Doodlebug bug = bugs.get(i);

      int currentRow = bug.cell.getRow();
      int currentColumn = bug.cell.getColumn();

      Cell destination = getAdjacentCell(currentRow, currentColumn, world);

      System.out.println("Current location: " + currentRow + " " +
              currentColumn );

      if (destination != null) {
        Organism target = destination.getCritter();

        if (target == null) {
          bug.move(destination);
          bug.goWithoutFood();
        }
        else if (target instanceof Ant) {
          System.out.println("Doodlebug eats the ant");
          bug.move(destination);
          bug.resetHunger();
          removeAnt((Ant) target, ants);
        }
        else if (target instanceof Doodlebug) {
          System.out.println("Doodlebug in the way");
        }

      }

    }

  }

  public static void breedDoodlebugs(ArrayList<Doodlebug> bugs, Cell[][] world){

    int bugsInCell = bugs.size();

    for (int i = 0; i < bugsInCell; i++) {

      Doodlebug bug = bugs.get(i);

      int currentRow = bug.cell.getRow();
      int currentColumn = bug.cell.getColumn();

      System.out.println("Current breeding location: " + currentRow + " " +
              currentColumn );

      Cell adjacentCell = getAdjacentCell(currentRow, currentColumn, world);

      if (adjacentCell != null) {

        Organism target = adjacentCell.getCritter();

        if (target == null) {
          Doodlebug newBug = new Doodlebug();
          bug.breed(adjacentCell, newBug);
          bugs.add(newBug);
        }
      }

    }
  }

  public static void starveDoodlebugs(ArrayList<Doodlebug> bugs){
    for (int i = 0; i < bugs.size(); i++){
      Doodlebug bug = bugs.get(i);
      if (bug.daysNotEaten() == 3){
        bug.starve();
        removeBug(bug, bugs);
      }
    }
  }

  public static void removeAnt(Ant anAnt, ArrayList<Ant> antList ){

    int x = anAnt.cell.getRow();
    int y = anAnt.cell.getColumn();

    for (int i = 0; i < antList.size(); i++){
      Ant target = antList.get(i);
      if (x == target.cell.getRow() && y == target.cell.getColumn() ){
        antList.remove(target);
      }
    }

  }

  public static void removeBug(Doodlebug aBug, ArrayList<Doodlebug> bugList ){

    int x = aBug.cell.getRow();
    int y = aBug.cell.getColumn();

    for (int i = 0; i < bugList.size(); i++){
      Doodlebug target = bugList.get(i);

      if (x == target.cell.getRow() && y == target.cell.getColumn() ){
        bugList.remove(target);
      }
    }

  }

  public static Cell getAdjacentCell(int row, int column, Cell[][] world){

    int direction = (int) (Math.random() * 4) + 1;

    switch (direction){
      case 1:
        if (column - 1 > -1)
          return world[row][column - 1] ;
      case 2:
        if (row - 1 > -1)
          return world[row - 1][column];
      case 3:
        if (column + 1 < 20)
          return world[row][column + 1];
      case 4:
        if (row + 1 < 20)
          return world[row + 1][column];
    }

    return null;

  }


}
