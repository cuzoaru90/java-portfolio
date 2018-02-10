/**
 * Inner class demonstration with private class and inheritance
 */

public class Vehicle {

  // inner class definition
  private class Person {

    private String name;

    /**
     * Constructor
     */
    public Person(){
      name = "";
    }

    /**
     * Constructor with parameter
     * @param theName
     */
    public Person(String theName){
      name = theName;
    }

    /**
     * Copy constructor
     * @param theObject
     */
    public Person(Person theObject){
      name = theObject.name;
    }

    public void changeName(String aName){
      name = aName;
    }

    /**
     * Accessor
     * @return name String
     */
    public String getName(){
      return name;
    }

    /**
     * Mutator
     * @param theName
     */
    public void setName(String theName){
      name = theName;
    }

    /**
     * String conversion
     * @return String
     */
    public String toString(){
      return "" + name;
    }

    /**
     * Equals method
     * @param other
     * @return value from boolean expression
     */
    public boolean equals(Person other){
      return name.equals(other.name);
    }

  } // end of inner class definition

  private String manufacturer;
  private int cylinders;
  private Person owner;

  /**
   * Constructor
   */
  public Vehicle(){
    manufacturer = "";
    cylinders = 6;
    owner = null;
  }

  /**
   * Constructor with parameters
   * @param maker
   * @param numCylinders
   */
  public Vehicle(String maker, int numCylinders){
    manufacturer = maker;
    cylinders = numCylinders;
    owner = new Person("Dealer");
  }

  /**
   * Copy constructor
   * @param otherVehicle
   */
  public Vehicle(Vehicle otherVehicle){
    manufacturer = otherVehicle.manufacturer;
    cylinders = otherVehicle.cylinders;
    owner = otherVehicle.owner;
  }

  /**
   * Accessor
   * @return owner
   */
  public String getOwnerName(){
    return owner.getName();
  }

  /**
   * Mutator
   */
  public void changeOwner(String aName){
    owner.changeName(aName);
  }

  /**
   * toString method
   * @return String representation of object
   */
  public String toString(){
    return manufacturer + " " + cylinders + " " + owner;
  }


}
