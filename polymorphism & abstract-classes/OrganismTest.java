import java.util.*;
public class OrganismTest {

  public static void main (String[] args) {

    Cell[][] critterWorld = new Cell[20][20];

    createWorld(critterWorld);

    // Partially filled arrays aren't cutting it anymore
    ArrayList<Organism> doodlebugs = new ArrayList<Organism>();
    ArrayList<Organism> ants = new ArrayList<Organism>();

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

      // Doodlebugs move first
      moveCritters(doodlebugs, ants, critterWorld);

      // Breed during every eighth time step
      if ( (counter > 0) && counter % 8 == 0) {
        breedCritters(doodlebugs, critterWorld);
      }

      // Ants move second
      moveCritters(ants, ants, critterWorld);

      // Breed during every third time step
      if ( (counter > 0) && counter % 3 == 0) {
        breedCritters(ants, critterWorld);
      }

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

  /**
   * Makes move for each critter (doodlebug or ant) in the the organism list; move() method uses late binding
   * @param critters Organism list (doodlebug or ant)
   * @param ants List of ants, remove an ant if doodlebug moves to space occupied by ant
   * @param world 20 x 20 grid of all cells (occupied or vacant);
   */
  public static void moveCritters(ArrayList<Organism> critters, ArrayList<Organism> ants, Cell[][] world){

    for (int i = 0; i < critters.size(); i++){

      Organism critter = critters.get(i);

      int currentRow = critter.cell.getRow();
      int currentColumn = critter.cell.getColumn();

      Cell destination = randomAdjacentCell(currentRow, currentColumn, world);

      if (destination != null && critter instanceof Doodlebug) {
        Organism target = destination.getCritter();

        if (target instanceof Doodlebug) {
          // System.out.println("Doodlebug in the way");
        }
        else{
          if (target instanceof Ant){
            removeAnt( target, ants);
          }
          critter.move(destination, critters);
        }

      }
      else if (destination != null && critter instanceof Ant){
        Organism target = destination.getCritter();
        if (target == null){
          critter.move(destination, critters);
        }
      }

    }

  }

  /**
   * Breeds for each critter (doodlebug or ant) in the the organism list; breed() method uses late binding
   * @param critters Organism list (doodlebug or ant)
   * @param world 20 x 20 grid of all cells (occupied or vacant);
   */
  public static void breedCritters(ArrayList<Organism> critters, Cell[][] world){

    int breedingCritters = critters.size();

    for (int i = 0; i < breedingCritters; i++) {

      Organism critter = critters.get(i);

      int currentRow = critter.cell.getRow();
      int currentColumn = critter.cell.getColumn();

      Cell adjacentCell = anyVacantCell(currentRow, currentColumn, world);

      if (adjacentCell != null) {

        if (critter instanceof Doodlebug) {
          Doodlebug newBug = new Doodlebug();
          critter.breed(adjacentCell, newBug);
          critters.add(newBug);
        }
        else if (critter instanceof Ant){
          Ant newAnt = new Ant();
          critter.breed(adjacentCell, newAnt);
          critters.add(newAnt);
        }
      }

    }
  }


  public static void removeAnt(Organism anAnt, ArrayList<Organism> antList ){

    int x = anAnt.cell.getRow();
    int y = anAnt.cell.getColumn();

    for (int i = 0; i < antList.size(); i++){
      Organism target = antList.get(i);
      if (x == target.cell.getRow() && y == target.cell.getColumn() ){
        antList.remove(target);
      }
    }

  }

  public static Cell randomAdjacentCell(int row, int column, Cell[][] world){

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

  public static Cell anyVacantCell(int row, int column, Cell[][] world){

    if (column - 1 > -1 && !world[row][column - 1].isOccupied() ){
      return world[row][column - 1];
    }
    else if (row - 1 > -1 && !world[row - 1][column].isOccupied() ){
      return world[row - 1][column];
    }
    else if (column + 1 < 20 && !world[row][column + 1].isOccupied() ){
      return world[row][column + 1];
    }
    else if (row + 1 < 20 && !world[row + 1][column].isOccupied() ){
      return world[row + 1][column];
    }

    return null;

  }


}
