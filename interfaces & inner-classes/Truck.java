public class Truck extends Vehicle {
  private double loadCapacity;
  private int towingCapacity;

  /**
   * Constructor with parameters
   * @param maker
   * @param numCylinders
   */
  public Truck(String maker, int numCylinders){
    super(maker, numCylinders);
    loadCapacity = 0.0;
    towingCapacity = 0;
  }

  /**
   * Mutator
   * @param aLoadCapacity
   */
  public void setLoadCapacity(double aLoadCapacity){
    loadCapacity = aLoadCapacity;
  }

  /**
   * Mutator
   * @param aTowingCapacity
   */
  public void setTowingCapacity(int aTowingCapacity){
    towingCapacity = aTowingCapacity;
  }

  /**
   * toString
   * @return String representation of object
   */
  public String toString(){
    return super.toString() + " " + loadCapacity + " " + towingCapacity;
  }

}
