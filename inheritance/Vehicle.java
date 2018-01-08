/**
 * Create a class called Vehicle that has the manufacturer's name (type String), number of cylinders in the engine
 * (type int), and owner (type Person give below). Then, create a class called Truck that is derived from Vehicle and
 * has the following additional properties: the load capacity in tons (type double since it may contain a fractional
 * part) and towing capacity in pounds (type int). Be sure your class has a reasonable complement of constructors,
 * accessor and mutator methods, and suitably defined equals and toString methods. Write a program to test all your
 * methods.
 *
 * The definition of the class Person is below. Completing the definitions of the methods is part of the programming
 * project.
 *
 */
public class Vehicle {

  private String manufacturer;
  private int cylinders;
  private Person owner;

  public Vehicle(){
    manufacturer = "";
    cylinders = 6;
    owner = null;
  }

  public Vehicle(String maker, int numCylinders, Person theOwner){
    manufacturer = maker;
    cylinders = numCylinders;
    owner = theOwner;
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

  public String toString(){
    return manufacturer + " " + cylinders + " " + owner;
  }

}
