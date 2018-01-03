/** Define a class for complex numbers. A complex number of the form
 *
 * a + b*i
 *
 * where, for our purposes, a and b are numbers of type double, and i is a number that represents the quantity √(-1)
 * Represent a complex number as two values of type double. Name the instance variables real and imaginary. (The
 * instance variable for the number that is multiplied by i is the one called imaginary.) Call the class Complex.
 * Include a constructor with two parameters of type double that can be used to set the instance variables of an object
 * to any values. Also include a constructor that has only a single parameter of type double; call this parameter
 * realPart and define the constructor so that the object will be initialized to realPart + 0*i. Also include a
 * no-argument constructor that initializes an object to 0 (that is, to 0 + 0*i). Define accessor and mutator methods
 * as well as the methods equals and toString. Define static methods for addition, subtraction, and multiplication of
 * objects of your class Complex. For example, Complex.add(c1, c2) will return the result of adding the two complex
 * numbers (two objects of the class Complex) c1 and c2. Also write a test program to test your class.
 *
 * Hints: To add or subtract two complex numbers, you add or subtract the two instance variables of type double. The
 * product of two complex numbers is given by the following formula:
 *
 * (a + b*i)*(c + d*i) = (a*c - b*d) + (a*d + b*c)*i
 *
 * Part Two: Add a second version of the methods for addition, subtraction, and multiplication. They should use a
 * calling object and a single argument.
 *
 */

public class Complex {
  public static final double I = Math.sqrt(-1);

  private double real, imaginary;

  /**
   * No-parameter ("default") constructor
   */
  public Complex(){
    real = 0;
    imaginary = 0 * I;
  }

  /**
   * One parameter constructor
   * @param realPart
   */
  public Complex(double realPart){
    real = realPart;
    imaginary = 0 * I;
  }

  /**
   * Two parameter constructor
   * @param realPart
   * @param imaginaryPart
   */
  public Complex(double realPart, double imaginaryPart){
    real = realPart;
    imaginary = imaginaryPart;
  }

  /**
   * Mutator; sets values
   * @param realPart
   * @param imaginaryPart
   */
  public void setValues(double realPart, double imaginaryPart){
    real = realPart;
    imaginary = imaginaryPart;
  }

  /**
   * Performs addition
   * @param c1
   * @param c2
   * @return Complex number computed from addition
   */
  public static Complex addition(Complex c1, Complex c2){
    return new Complex(c1.real + c2.real,
                        c1.imaginary * I + c2.imaginary * I);
  }

  /**
   * Performs subtraction
   * @param c1
   * @param c2
   * @return Complex number computed from subtraction
   */
  public static Complex subtraction(Complex c1, Complex c2){
    return new Complex(c1.real - c2.real,
                         c1.imaginary * I - c2.imaginary * I );
  }

  /**
   * Performs multiplication
   * @param c1
   * @param c2
   * @return Complex number computed from multiplication
   */
  public static Complex multiplication(Complex c1, Complex c2){
    return new Complex(c1.real * c2.real - c1.imaginary * c2.imaginary,
            (c1.real * c2.imaginary + c1.imaginary * c2.real) * I ) ;
  }


  public Complex addition(Complex anotherComplex){
    return addition(this, anotherComplex);
  }

  public Complex subtraction(Complex anotherComplex){
    return subtraction(this, anotherComplex);
  }

  public Complex multiplication(Complex anotherComplex){
    return multiplication(this, anotherComplex);
  }

  /**
   * Tests for equality
   * @param anotherComplex
   * @return Value from boolean expression
   */
  public boolean equals(Complex anotherComplex){
    return (this.real == anotherComplex.real &&
               this.imaginary == anotherComplex.real);
  }

  /**
   * Converts object to string
   * @return String representation of object
   */
  public String toString(){
    return this.real + " + " + this.imaginary + I;
  }

}
