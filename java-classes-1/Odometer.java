/* Define a class called Odometer that will be used to track fuel and mileage for an automobile. The class should have
instance variables to track the miles driven and the fuel efficiency of the vehicle in miles per gallon. Include a
mutator method to reset the odometer to zero miles, a mutator method to set the fuel efficiency, a mutator method that
accepts miles driven for a trip and adds it to the odometer's total, and an accessor method that returns the number of
gallons of gasoline that the vehicle has consumed since the odometer was last reset.

Use your class with a test program that creates several trips with different fuel efficiencies. You should decide which
variables should be public, if any.

*/

public class Odometer {

  private double milesDriven, fuelEfficiency;

  /**
   * Constructor
   * @param miles
   * @param efficiency
   */
  public Odometer(double miles, double efficiency){
    milesDriven = miles;
    fuelEfficiency = efficiency;
  }

  /**
   * Computes gas consumed on trip
   * @return Computed gas consumption
   */
  public double gasConsumed(){
    return milesDriven / fuelEfficiency;
  }

  /**
   * Mutator
   */
  public void resetOdometer(){
    milesDriven = 0;
  }

  /**
   * Mutator
   * @param miles
   */
  public void addToMileage(double miles){
    milesDriven += miles;
  }

  /**
   * Mutator
   * @param efficiency
   */
  public void setEfficiency(double efficiency){
    fuelEfficiency = efficiency;
  }

}
