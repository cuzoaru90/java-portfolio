public class Cell {

  private Organism critter;
  private boolean occupied;
  private int row;
  private int column;

  public Cell(){
    critter = null;
    occupied = false;
  }

  public Cell(Organism aCritter, boolean occupied){
    critter = aCritter;
    this.occupied = occupied;
  }

  public boolean isOccupied(){
    return occupied;
  }

  public int getRow(){
   return row;
  }

  public int getColumn(){
    return column;
  }

  public Organism getCritter(){
    return critter;
  }

  public void setCoordinates(int x, int y){
    row = x;
    column = y;
  }

  public void update(Organism aCritter, boolean occupied){
    critter = aCritter;
    this.occupied = occupied;
  }

  public String toString(){
    if (critter == null){
      return " " ;
    }

    return critter.marker;
  }

}
