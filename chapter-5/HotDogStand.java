/* You operate several hot dog stands distributed throughout town. Define a class named HotDogStand that has
an instance variable for the hot dog stand's ID number and an instance variable for how many hot dogs the
stand has sold that day. Create a constructor that allows a user of the class to initialize both values.

Also create a method named justSold that increments the number of hot dogs the stand has sold by one. The idea
is that this method will be invoked each time the stand sells a hot dog so that you can track the total number
of hot dogs sold by the stand. Add another method that returns the number of hot dogs sold.

Finally, add a static variable that tracks the total number of hot dogs sold by all hot dog stands and a static
method that returns the value in this variable.

 */
public class HotDogStand {

  private static int totalDogsSold;

  private int standID, dogsSold;

  public HotDogStand(int id, int dogs){
    standID = id;
    dogsSold = dogs;
    totalDogsSold += dogsSold;
  }

  public void justSold(){
    dogsSold++;
    totalDogsSold++;
  }

  public static int getDogsSold(){
    return totalDogsSold;
  }



}
