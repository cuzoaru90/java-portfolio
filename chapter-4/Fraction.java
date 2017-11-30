/* Define a class called Fraction. This class is used to represent a ratio of two integers. Include mutator methods
that allow the user to set the numerator and the denominator. Also include a method that returns the value of the
numerator divided by the denominator as a double. Include an additional method that outputs the value of the fraction
reduced to lowest terms (e.g., instead of outputting 20/60 the method should output 1/3). This will require finding
the greatest common divisor for the numerator and denominator, then dividing both by that number. Embed your class in
a test program.

 */

public class Fraction {

  private int numerator, denominator;

  // constructor
  public Fraction(int nInput, int dInput){
    setNumerator(nInput);
    setDenominator(dInput);
  }

  // returns quotient
  public double getQuotient(){
    return (numerator * 1.0) / denominator;
  }

  // mutator
  public void setNumerator(int n){
    numerator = n;
  }

  // mutator
  public void setDenominator(int d){
    denominator = d;
  }

  public void getLowestTerms(){

     int counter = 0;

     if (numerator > denominator){
       counter = denominator;
     }
     else if (denominator > numerator){
       counter = numerator;
     }

     while (counter > 0){
       if (denominator % counter == 0 &&
           numerator % counter == 0 )
       {
         denominator /= counter;
         numerator /= counter;
       }
       counter--;
     }

  }

  public void outputFraction(){
    System.out.printf("%d/%d\n", numerator, denominator);
  }


}
