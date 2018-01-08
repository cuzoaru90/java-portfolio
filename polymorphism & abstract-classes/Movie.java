/**
 * Create a class named Movie that can be used with your video rental business. The Movie class should track the Motion
 * Picture Association of America (MPAA) rating(e.g., Rated G, PG-13, R), ID Number, and movie title with appropriate
 * accessor and mutator methods. Also create an equals() method that overrides Object's equals() method, where two movies
 * are equal if their ID number is identical.
 *
 * Next create three additional classes named Action, Comedy, and Drama that are derived from Movie. Finally, create an
 * overridden method named calcLateFees that takes as input the number of days a movie is late and returns the late fee
 * for that movie. The default late fee is $2/day. Action movies have a late fee of $3/day, comedies are $2.50/day, and
 * dramas are $2/day. Test your classes from a main method.
 *
 */
public class Movie {

  protected String rating, title;
  protected int ID;


  public Movie(){
    rating = "";
    title = "";
    ID = 0;
  }

  public Movie(String theTitle, String theRating, int theID){
    title = theTitle;
    rating = theRating;
    ID = theID;
  }

  public double calcLateFees(int daysLate){
    return daysLate * 2;
  }

  public boolean equals(Movie otherMovie){
    return ID == otherMovie.ID;
  }


}
