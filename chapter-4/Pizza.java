/* Create a class named Pizza that stores information about a single pizza. It should contain the following:

Private instance variables to store the size of the pizza (either small, medium, or large), the number of cheese
toppings, the number of pepperoni toppings, and the number of ham toppings.

Constructors(s) that set all of the instance variables.

Public methods to get and set the instance variables.

A public method named calcCost() that returns a double that is the cost of the pizza.

Pizza cost is determined by:
  Small: $10 + $2 per topping
  Medium: $12 + $2 per topping
  Large: $14 + $2 per topping

A public method named getDescription() that returns a String containing the pizza size, quantity of each topping, and
the pizza cost as calculated by calcCost().

Write test code to create several pizzas and output their descriptions. For example, a large pizza with 1 cheese, 1
pepperoni, and 2 ham toppings should cost a total of $22.

 */

public class Pizza {

  private int cheeseToppings, pepperoniToppings, hamToppings;
  private String size;

  /**
   * Constructor
   */
  public Pizza(){
    setToppings(1, 0, 0);
    setSize("medium");
  }

  /**
   * Constructor
   * @param size
   * @param cheese
   * @param pepperoni
   * @param ham
   */
  public Pizza(String size, int cheese, int pepperoni, int ham){
    setToppings(cheese, pepperoni, ham);
    setSize(size);
  }

  /**
   * Mutator
   * @param size
   */
  public void setSize(String size){
    this.size = size;
  }

  /**
   * Mutator
   * @param cheese
   * @param pepperoni
   * @param ham
   */
  public void setToppings(int cheese, int pepperoni, int ham){
    cheeseToppings = cheese;
    pepperoniToppings = pepperoni;
    hamToppings = ham;
  }

  /**
   * Accessor
   * @return String representation of pizza and cost
   */
  public String getDescription(){
    return "Size: " + size + ", " + cheeseToppings + " cheese toppings, " +
      pepperoniToppings + " pepperoni toppings, " + hamToppings + " ham toppings " +
      "\nCost: $" + calcCost();
  }

  /**
   * Accessor
   * @return total number of toppings
   */
  public int getToppings(){
    return cheeseToppings + pepperoniToppings + hamToppings;
  }

  /**
   * Calculate pizza cost
   * @return pizza cost
   */
  public int calcCost(){

    int baseCost = 0;

    if ( size.equals("small") ){
      baseCost = 10;
    }
    else if (size.equals("medium") ){
      baseCost = 12;
    }
    else if (size.equals("large") ){
      baseCost = 14;
    }

    return baseCost + getToppings() * 2;

  }

}
