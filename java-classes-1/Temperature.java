/* Write a Temperature class that has two instance variables: a temperature value (a floating-point number) and a
character for the scale, either C for Celsius or F for Fahrenheit. The class should have four constructor methods: one
for each instance variable (assume zero degrees if no value is specified and Celsius if no scale is specified), one with
two parameters for the two instance variables, and a no-argument constructor (set to zero degrees Celsius). Include the
following: (1) two accessor methods to return the temperature--one to return the degrees Celsius, the other to return
the degrees Fahrenheit--use the following formulas to write the two methods, and round to the nearest tenth of a degree:

DegreesC = 5(degreesF - 32)/9
DegreesF = 9(degreesC)/5 + 32

(2) three mutator methods: one to set the value, one to set the scale (F or C), and one to set both; (3) three
comparison methods: an equals method to test whether two temperatures are equal, one method to test whether one
temperature is greater than another, and one method to test whether one temperature is less than another (note that
a Celsius temperature can be equal to a Fahrenheit temperature as indicated by the above formulas); and (4) a suitable
toString method. Then write a driver program (or programs) that tests all the methods. Be sure to use each of the
constructors, to include at least one true and one false case for each of the comparison methods, and to test ay least
the following temperature equalities: 0.0 degrees C = 32.0 degrees F, -40.0 degrees C = -40.0 degrees F, and 100.0
degrees C = 212.0 degrees F.

 */

public class Temperature {

  private double degrees;
  private char scale;

  /**
   * Constructor
   */
  public Temperature(){
    degrees = 0;
    scale = 'C';
  }

  /**
   * Constructor
   * @param inputVal
   */
  public Temperature(int inputVal){
    degrees = inputVal;
  }

  /**
   * Constructor
   * @param scale
   */
  public Temperature(char scale){
    this.scale = scale;
  }

  /**
   * Constructor
   * @param inputVal
   * @param scale
   */
  public Temperature(int inputVal, char scale){
    degrees = inputVal;
    this.scale = scale;
  }

  /**
   * Accessor
   * @return degrees in Celsius
   */
  public double getDegreesC(){
    if (scale == 'C') {
      return degrees;
    }

    return (5.0 * (degrees - 32) )/9;
  }

  /**
   * Accessor
   * @return degrees in Fahrenheit
   */
  public double getDegreesF(){
    if (scale == 'F') {
      return degrees;
    }

    return (9.0 * degrees)/5 + 32;
  }

  /**
   * Comparison
   * @param otherTemp
   * @return value of boolean expression
   */
  public boolean equals(Temperature otherTemp){

    double convertedDegrees = 0;

    if (scale == 'F'){
      convertedDegrees = otherTemp.getDegreesF();
    }
    else if (scale == 'C'){
      convertedDegrees = otherTemp.getDegreesC();
    }

    return (this.degrees == convertedDegrees);
  }

  /**
   * Comparison
   * @param otherTemp
   * @return value of boolean expression
   */
  public boolean lessThan(Temperature otherTemp){

    double convertedDegrees = 0;

    if (scale == 'F'){
      convertedDegrees = otherTemp.getDegreesF();
    }
    else if (scale == 'C'){
      convertedDegrees = otherTemp.getDegreesC();
    }

    return (degrees < convertedDegrees);
  }

  /**
   * Comparison
   * @param otherTemp
   * @return value of boolean expression
   */
  public boolean greaterThan(Temperature otherTemp){

    double convertedDegrees = 0;

    if (scale == 'F'){
      convertedDegrees = otherTemp.getDegreesF();
    }
    else if (scale == 'C'){
      convertedDegrees = otherTemp.getDegreesC();
    }

    return (degrees > convertedDegrees);
  }

}
