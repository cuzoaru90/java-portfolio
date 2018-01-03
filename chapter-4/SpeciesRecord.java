/* Define a class whose objects are records on animal species. The class should have instance variables for the species
name, population, and growth rate. The growth rate is a percentage that can be positive or negative and can exceed 100
percent. Include a suitable collection of constructors, mutator methods, and accessor methods. Include a toString
method and an equals methods. Include a boolean valued method named endangered that returns true when the growth rate
is negative and returns false otherwise. Write a test program (or programs) that tests each method in your class
definition.
 */

public class SpeciesRecord {

  private String name;
  private int population;
  private double growthRate;

  /**
   * Constructor
   */
  public SpeciesRecord(){
    name = "";
    population = 10;
    growthRate = .1;
  }

  /**
   * Constructor
   * @param newName
   * @param size
   * @param rate
   */
  public SpeciesRecord(String newName, int size, double rate){
    name = newName;
    population = size;
    growthRate = rate;
  }

  /**
   *
   * @return String representation of species
   */
  public String toString(){
    return name + " " + population + " " + growthRate;
  }

  /**
   * Equals method for object comparison
   * @param otherRecord
   * @return value from boolean expression
   */
  public boolean equals(SpeciesRecord otherRecord){
    return (name.equals(otherRecord.name) &&
      population == otherRecord.population &&
      growthRate == otherRecord.growthRate);
  }

  /**
   * Determines if species is endangered
   * @return value from boolean expression
   */
  public boolean endangered(){
    return (growthRate < 0);
  }


}
