import java.util.ArrayList;

public class Doodlebug extends Organism {

  private int daysWithoutFood;

  public Doodlebug(){
    marker = "X";
    alive = true;
    daysWithoutFood = 0;
  }

  @Override
  public void breed(Cell target, Organism offspring) {
    target.update(offspring, true);
    offspring.assignCell(target);
  }

  @Override
  public void move(Cell destination, ArrayList<Organism> critters) {

    if (destination.getCritter() == null) {
      this.goWithoutFood();
    }
    else if (destination.getCritter() instanceof Ant){
      daysWithoutFood = 0;
    }

    cell.update(null, false);
    destination.update(this, true);
    this.assignCell(destination);

    if (daysNotEaten() == 3){
      starve(critters,this);
    }

  }

  public int daysNotEaten(){
    return daysWithoutFood;
  }

  public void goWithoutFood(){
    daysWithoutFood++;
  }

  public void starve(ArrayList<Organism> critters, Organism critter){
    cell.update(null, false);
    critters.remove(critter);
  }
}
