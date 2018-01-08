public class Truck extends Vehicle {

  private double loadCapacity;
  private int towingCapacity;

  public Truck(String maker, int numCylinders, Person theOwner){
    super(maker, numCylinders, theOwner);
    loadCapacity = 0.0;
    towingCapacity = 0;
  }

  public void setLoadCapacity(double aLoadCapacity){
   loadCapacity = aLoadCapacity;
  }

  public void setTowingCapacity(int aTowingCapacity){
    towingCapacity = aTowingCapacity;
  }

  public String toString(){
    return super.toString() + " " + loadCapacity + " " + towingCapacity;
  }

}
