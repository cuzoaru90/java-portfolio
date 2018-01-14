import java.util.ArrayList;

public class Ant extends Organism {

  public Ant(){
    marker = "o";
    alive = true;
  }

  @Override
  public void breed(Cell target, Organism offspring) {
    target.update(offspring, true);
    offspring.assignCell(target);
  }

  @Override
  public void move(Cell destination, ArrayList<Organism> critters) {
    cell.update(null, false);
    destination.update(this, true);
    this.assignCell(destination);
  }


}
