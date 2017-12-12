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
    setNumerator(0);
    setDenominator(0);
  }

  public Fraction2(int numerator, int denominator){
    setNumerator(numerator);
    setDenominator(denominator);
  }

  // mutator
  public void setNumerator(int n){
    numerator = n;
  }

  // mutator
  public void setDenominator(int d) {
    denominator = d;
  }

  public void displayFraction(){
    System.out.println(numerator + "/" + denominator );
  }

  // do comparison with local fractions; avoid mutation on calling object
  public boolean equals(Fraction2 anotherFraction){

      Fraction2 thisFraction = evaluateLowestTerms(numerator, denominator);
      Fraction2 otherFraction = evaluateLowestTerms(anotherFraction.numerator, anotherFraction.denominator);

      return (thisFraction.numerator == otherFraction.numerator &&
            thisFraction.denominator == otherFraction.denominator);
  }

  // returns fraction objects that will be used in scope of the equals method above
  public Fraction2 evaluateLowestTerms(int numerator, int denominator){

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

      return new Fraction2(lowestNumerator, lowestDenominator);
  }



}
