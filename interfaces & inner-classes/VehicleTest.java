public class VehicleTest {

  public static void main (String[] args){
    Vehicle aVehicle = new Vehicle("Ford", 6);

    System.out.println( aVehicle.toString() );

    aVehicle.changeOwner("Joe");

    System.out.println( aVehicle.toString() );

    Truck aTruck = new Truck("Volvo", 4);

    aTruck.changeOwner("Candy");

    System.out.println( aTruck.toString() );

  }

}
