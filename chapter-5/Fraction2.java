/* Define a class called Fraction. This class is used to represent a ratio of two integers. Include mutator methods
that allow the user to set the numerator and the denominator. Also include a method that displays the fraction on the
screen as a ratio (e.g., 5/9). This method does not need to reduce the fraction to lowest terms.

Include an additional method, equals, that takes as input another Fraction and returns true if the two fractions are
identical and false if they are not. This method should treat the fractions reduced to lowest terms; that is, if one
fraction is 20/60 and the other is 1/3, then the method should return true.

Embed your class in a test program that allows the user to create a fraction. Then the program should loop repeatedly
until the user decides to quit. Inside the body of the loop, the program should allow the user to enter a target
fraction into an anonymous object and learn whether the fractions are identical.
 */

public class Fraction2 {

  private int numerator, denominator;

  public Fraction2(){
    setValues(0,0);
  }

  public Fraction2(int numerator, int denominator){
    setValues(numerator, denominator);
  }


  /**
   * Mutator
   * @param n
   * @param d
   */
  public void setValues(int n, int d){
    numerator = n;
    denominator = d;
  }

  /**
   * Equals method
   * @param anotherFraction
   * @return Value of boolean expression
   */
  public boolean equals(Fraction2 anotherFraction){

      Fraction2 thisFraction = Fraction2.evaluateLowestTerms(numerator, denominator);
      Fraction2 otherFraction = Fraction2.evaluateLowestTerms(anotherFraction.numerator, anotherFraction.denominator);

      return (thisFraction.numerator == otherFraction.numerator &&
            thisFraction.denominator == otherFraction.denominator);
  }

  /**
   * toString conversion
   * @return String representation of fraction
   */
  public String toString(){
    return numerator + "/" + denominator;
  }

  /**
   * Create new fraction with lowest common denominator
   * @param numerator
   * @param denominator
   * @return new Fraction
   */
  public static Fraction2 evaluateLowestTerms(int numerator, int denominator){

    int counter = denominator;

    while (counter > 0){
      if (denominator % counter == 0 &&
            numerator % counter == 0 )
      {
        denominator /= counter;
        numerator /= counter;
      }
        counter--;
    }

    return new Fraction2(numerator, denominator);
  }

}
