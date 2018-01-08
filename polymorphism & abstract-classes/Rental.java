/**
 * Extend the previous problem with a Rental class. This class should store a Movie that is rented, an integer
 * representing the ID of the customer that rented the movie, and an integer indicating how many days late the movie is.
 * Add a method that calculates the late fees for the rental. In your main method create an array of type Rental filled
 * with sample data of all types of movies. Then create a method named lateFeesOwed that iterates through the array and
 * returns the total amount of late fees that are outstanding.
 *
 */

public class Rental {

  private Movie movie;
  private int customerID;
  private int daysLate;

  public Rental(){
    movie = null;
  }

  public Rental(Movie aMovie, int anID, int daysLate){
    movie = aMovie;
    customerID = anID;
    this.daysLate = daysLate;
  }

  public int getDaysLate(){
    return daysLate;
  }

  public double calcLateFees(int daysLate){
    return movie.calcLateFees(daysLate);
  }


}
