/* Define a class called Fraction. This class is used to represent a ratio of two integers. Include mutator methods
that allow the user to set the numerator and the denominator. Also include a method that returns the value of the
numerator divided by the denominator as a double. Include an additional method that outputs the value of the fraction
reduced to lowest terms (e.g., instead of outputting 20/60 the method should output 1/3). This will require finding
the greatest common divisor for the numerator and denominator, then dividing both by that number. Embed your class in
a test program.

 */

public class Fraction {

  private int numerator, denominator;

  /**
   * Constructor
   */
  public Fraction(){
    numerator = 0;
    denominator = 0;
  }

  /**
   * Constructor
   * @param nInput
   * @param dInput
   */
  public Fraction(int nInput, int dInput){
    setNumerator(nInput);
    setDenominator(dInput);
  }

  /**
   * Computes quotient
   * @return Value of computed quotient
   */
  public double getQuotient(){
    return (numerator * 1.0) / denominator;
  }

  /**
   * Mutator
   * @param n
   */
  public void setNumerator(int n){
    numerator = n;
  }

  /**
   * Mutator
   * @param d
   */
  public void setDenominator(int d){
    denominator = d;
  }

  /**
   * Display reduced fraction to screen; uses local variables to avoid mutation on instance variables
   *
   */
  public void outputLowestFraction(){

     int counter = 0;
     int lowestNumerator = numerator;
     int lowestDenominator = denominator;

     if (lowestNumerator > lowestDenominator){
       counter = lowestDenominator;
     }
     else if (lowestDenominator > lowestNumerator){
       counter = lowestNumerator;
     }

     while (counter > 0){
       if (lowestDenominator % counter == 0 &&
           lowestNumerator % counter == 0 )
       {
         lowestDenominator /= counter;
         lowestNumerator /= counter;
       }
       counter--;
     }

     outputFraction(lowestNumerator, lowestDenominator);
  }

  /**
   * Helper for method above
   * @param numerator
   * @param denominator
   */
  public void outputFraction(int numerator, int denominator ){
    System.out.printf("%d/%d\n", numerator, denominator);
  }

 /**
  * Convert instance variables to a String
  * @return String representation of object
  */
  public String toString(){
    return numerator + "/" + denominator;
  }

}
