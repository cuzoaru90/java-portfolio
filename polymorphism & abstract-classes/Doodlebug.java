public class Doodlebug extends Organism {

  private int daysWithoutFood;

  public Doodlebug(){
    marker = "X";
    alive = true;
    daysWithoutFood = 0;
  }

  public int daysNotEaten(){
    return daysWithoutFood;
  }

  @Override
  public void breed(Cell target, Organism offspring) {
    target.update(offspring, true);
    offspring.assignCell(target);
  }

  @Override
  public void move(Cell destination) {
    cell.update(null, false);
    destination.update(this, true);
    this.assignCell(destination);
  }

  public void goWithoutFood(){
    daysWithoutFood++;
  }

  public void resetHunger(){
    daysWithoutFood = 0;
  }

  public void starve(){
    cell.update(null, false);
  }
}
