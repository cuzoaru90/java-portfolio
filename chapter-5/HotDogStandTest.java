public class HotDogStandTest {

  public static void main(String[]args){
    HotDogStand stand1 = new HotDogStand(1, 23);
    HotDogStand stand2 = new HotDogStand(2, 34);
    HotDogStand stand3 = new HotDogStand(3, 25);

    stand2.justSold();
    stand3.justSold();

    int totalDogs = HotDogStand.getDogsSold();

    System.out.println(totalDogs);

  }
}
