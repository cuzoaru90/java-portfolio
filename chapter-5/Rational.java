/* Define a class for rational numbers. A rational number is a number that can be represented as the quotient of two
integers. For example, 1/2, 3/4, 64/2, and so forth are all rational numbers. (By 1/2 and so forth, we mean the everyday
meaning of the fraction, not the integer division this expression would produce in a Java program.) Represent rational
numbers as two values of type int, one for the numerator and one for the denominator. Your class should have two
instance variables of type int. Call the class Rational.

Include a constructor with two arguments that can be used to set the instance variables of an object to any values.
Also include a constructor that has only a single parameter of type int; call this single parameter wholeNumber and
define the constructor so that the object will be initialized to the rational number wholeNumber/1. Also include
a no-argument constructor that initializes an object to 0 (that is, to 0/1). Note that the numerator, the denominator,
or both may contain a minus sign. Define methods for addition, subtraction, multiplication, and division of objects
of your class Rational. These methods should be static methods that each have two parameters of type Rational and
return the result of adding the two rational numbers (two objects of the class Rational, r1 and r2). Define accessor
and mutator methods as well as the methods equals and toString. You should include a method to normalize the sign of
the rational number so that the denominator is positive and the numerator is either positive or negative. For example,
after normalization, 4/-8 would be represented the same as -4/8. Also write a test program to test your class.

Hints: Two rational numbers a/b and c/d are equal if a*d equals c*b.

Part Two: Add a second version of the methods for addition, subtraction, multiplication, and division. These methods
should have the same names as the static version but should use a calling object and a single argument. For example,
this version of the add method (for addition) has a calling object and one argument. So r1.add(r2) returns the result
of adding the rationals r1 and r2. Note that your class should have all these methods; for example, there should be two
methods named add.

*/

public class Rational {

  private int numerator, denominator;

  /** No-parameter ("default") constructor
   *
   */
  public Rational(){
    numerator = 0;
    denominator = 1;
  }

  /** One parameter constructor
   *
   * @param wholeNumber
   */
  public Rational(int wholeNumber){
    numerator = wholeNumber;
    denominator = 1;
  }

  /** Two parameter constructor
   *
   * @param n1
   * @param n2
   */
  public Rational(int n1, int n2){
    numerator = n1;
    denominator = n2;
  }

  /** Mutator; sets values
   *
   * @param n1
   * @param n2
   */
  public void setValues(int n1, int n2){
    numerator = n1;
    denominator = n2;
  }

  /** Accessor
   *
   * @return denominator variable of object
   */
  public int getDenominator(){
    return denominator;
  }

  /** Accessor
   *
   * @return numerator variable of object
   */
  public int getNumerator(){
    return numerator;
  }


  /** Move negative sign from denominator to numerator (if applicable)
   *
   */
  public void normalize(){

    if (
         (denominator < 0 && numerator < 0) ||
         (denominator < 0 && numerator >= 0)
       )
    {
      denominator *= -1;
      numerator *= -1;
    }

  }

  /**
   * Performs addition of Rational numbers
   * @param r1
   * @param r2
   * @return Rational computed from addition
   */
  public static Rational addition(Rational r1, Rational r2){

    int numeratorSum = (r1.numerator * r2.denominator) + (r2.numerator * r1.denominator);
    int commonDenominator = r1.denominator * r2.denominator;

    Rational sum = new Rational(numeratorSum, commonDenominator);

    sum.normalize(); // values are changed if denominator is negative or both portions are negative

    int normNumerator = sum.getNumerator();
    int normDenominator = sum.getDenominator();

    int counter = sum.getDenominator();

    while (counter > 0){
      if (normNumerator % counter == 0 &&
            normDenominator % counter == 0)
      {
        normNumerator /= counter;
        normDenominator /= counter;
      }

      counter--;
    }

    sum.setValues(normNumerator, normDenominator); // updates values
    return sum;
  }

  /**
   * Performs subtraction of Rational numbers
   *
   * @param r1
   * @param r2
   * @return Rational computed from subtraction
   */
  public static Rational subtraction(Rational r1, Rational r2){

    int numeratorDifference = (r1.numerator * r2.denominator) - (r2.numerator * r1.denominator);
    int commonDenominator = r1.denominator * r2.denominator;

    Rational difference = new Rational(numeratorDifference, commonDenominator);

    difference.normalize();

    int normNumerator = difference.getNumerator();
    int normDenominator = difference.getDenominator();

    int counter = difference.getDenominator();

    while (counter > 0){
      if (normNumerator % counter == 0 &&
              normDenominator % counter == 0)
      {
        normNumerator /= counter;
        normDenominator /= counter;
      }

      counter--;
    }

    difference.setValues(normNumerator, normDenominator); // updates values
    return difference;
  }

  /**
   * Performs multiplication of Rational numbers
   *
   * @param r1
   * @param r2
   * @return Rational computed from multiplication
   */
  public static Rational multiplication(Rational r1, Rational r2){

    Rational product = new Rational(r1.numerator * r2.numerator,
            r1.denominator * r2.denominator);

    product.normalize();

    int normNumerator = product.getNumerator();
    int normDenominator = product.getDenominator();

    int counter = product.getDenominator();

    while (counter > 0){
      if (normNumerator % counter == 0 &&
              normDenominator % counter == 0)
      {
        normNumerator /= counter;
        normDenominator /= counter;
      }

      counter--;
    }

    product.setValues(normNumerator, normDenominator); // updates values
    return product;
  }

  /**
   * Performs division of Rational numbers
   *
   * @param r1
   * @param r2
   * @return Rational computed from division
   */
  public static Rational division(Rational r1, Rational r2){

    Rational quotient = new Rational(r1.numerator * r2.denominator,
                         r2.numerator * r1.denominator);

    quotient.normalize();

    int normNumerator = quotient.getNumerator();
    int normDenominator = quotient.getDenominator();

    int counter = quotient.getDenominator();

    while (counter > 0){
      if (normNumerator % counter == 0 &&
              normDenominator % counter == 0)
      {
        normNumerator /= counter;
        normDenominator /= counter;
      }

      counter--;
    }

    quotient.setValues(normNumerator, normDenominator); // updates values
    return quotient;
  }

  public Rational addition(Rational anotherRational){
    return addition(this, anotherRational);
  }

  public Rational subtraction(Rational anotherRational){
    return subtraction(this, anotherRational);
  }

  public Rational multiplication(Rational anotherRational){
    return multiplication(this, anotherRational);
  }

  public Rational division(Rational anotherRational){
    return division(this, anotherRational);
  }




  /** Checks for equality between two Rational numbers
   *
   * @param anotherRational
   * @return Value from the boolean expression
   */
  public boolean equals(Rational anotherRational){
    return ( numerator * anotherRational.denominator ==
             denominator * anotherRational.numerator);
  }

  /** Converts object to string
   *
   * @return String representation of object
   */
  public String toString(){
    return numerator + "/" + denominator;
  }

}
