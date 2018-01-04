public class VehiclesTest {

  public static void main (String[] args){

    Person billy = new Person("Billy");
    Truck aTruck = new Truck("Ford", 8, billy);

    aTruck.setLoadCapacity(500.0);
    aTruck.setTowingCapacity(1850);

    Person johnny = new Person("Johnny");
    Vehicle aSedan = new Vehicle("Toyota", 5, johnny);

    System.out.println(aTruck);
    System.out.println(aSedan);

  }

}
