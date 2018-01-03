/* Write a program that outputs the lyrics for "Ninety-nine Bottles of Beer on the Wall." Your program should print
the number of bottles in English, not as a number. For example:

Ninety-nine bottles of beer on the wall,
Ninety-nine bottles of beer,
Take one down, pass it around,
Ninety-eight bottles of beer on the wall.
...
One bottle of beer on the wall,
One bottle of beer,
Take one down, pass it around,
Zero bottles of beer on the wall.

Your program should not use ninety-nine output statements!

Design your program with a class name BeerSong whose constructor takes an integer parameter that is the number of
bottles of beer initially on the wall. If the parameter is less than zero, set the number of bottles to zero. Similarly,
if the parameter is greater than 99, set the number of beer bottles to 99. Then make a public method called printSong
that outputs all stanzas from the number of bottles of beer down to zero. Add any additional private methods you find
helpful.
 */

public class BeerSong {

  private int beerBottles;

  /**
   * Constructor
   * @param bottles
   */
  public BeerSong(int bottles){
    beerBottles = bottles;
  }

  /**
   * Accessor
   * @return Number of beer bottles (integer)
   */
  public int getBottles(){
    return beerBottles;
  }

  /**
   * Mutator
   */
  public void passBottleDown(){
    beerBottles--;
  }

  /**
   * Prints BeerSong
   */
  public void printSong(){

    int numberOfStanzas = beerBottles;

    while (numberOfStanzas > 0){

      String bottleString = this.convertToString();

      System.out.printf("\n %s bottles of beer on the wall,\n ", bottleString );
      System.out.printf("%s bottles of beer,\n ", bottleString );
      System.out.printf("Take one down, pass it around,\n ");

      passBottleDown();

      if (beerBottles > 0)
        bottleString = this.convertToString();
      else if (beerBottles == 0)
        bottleString = "Zero";

      System.out.printf("%s bottles of beer on the wall.\n ", bottleString );

      numberOfStanzas--;
    }

  }

  /**
   * Converts all numbers from 0-99
   * @return String value from conversion
   */
  private String convertToString(){

    String result = "";

    if (beerBottles >= 20)
    {
      result = tensConversion() + onesConversion();
    }
    else if (beerBottles >= 10)
    {
      result = teenConversion();
    }
    else if (beerBottles >=1)
    {
      result = onesConversion();
    }

    return result;

  }

  /**
   * Converts from 20-99
   * @return String value from conversion
   */
  private String tensConversion(){

    int tensPlace = 0;
    String tensString = " ";

    tensPlace = beerBottles / 10;

      switch (tensPlace) {
        case 9:
          tensString = "Ninety-";
          break;
        case 8:
          tensString = "Eighty-";
          break;
        case 7:
          tensString = "Seventy-";
          break;
        case 6:
          tensString = "Sixty-";
          break;
        case 5:
          tensString = "Fifty-";
          break;
        case 4:
          tensString = "Forty-";
          break;
        case 3:
          tensString = "Thirty-";
          break;
        case 2:
          tensString = "Twenty-";
          break;
        default:
          break;
      }

    return tensString;
  }

  /**
   * Converts from 10-19
   * @return String value from conversion
   */
  private String teenConversion() {

    int value = 0;
    String result = "";
    value = beerBottles;

    switch (value) {
      case 19:
        result = "Nineteen";
        break;
      case 18:
        result = "Eighteen";
        break;
      case 17:
        result = "Seventeen";
        break;
      case 16:
        result = "Sixteen";
        break;
      case 15:
        result = "Fifteen";
        break;
      case 14:
        result = "Fourteen";
        break;
      case 13:
        result = "Thirteen";
        break;
      case 12:
        result = "Twelve";
        break;
      case 11:
        result = "Eleven";
        break;
      case 10:
        result = "Ten";
        break;
    }
    return result;
  }

  /**
   * Converts ones place
   * @return String value from conversion
   */
  private String onesConversion(){

    int onesPlace = 0;
    String onesString = " ";

    onesPlace = beerBottles % 10;

      switch (onesPlace) {
        case 9:
          onesString = "nine";
          break;
        case 8:
          onesString = "eight";
          break;
        case 7:
          onesString = "seven";
          break;
        case 6:
          onesString = "six";
          break;
        case 5:
          onesString = "five";
          break;
        case 4:
          onesString = "four";
          break;
        case 3:
          onesString = "three";
          break;
        case 2:
          onesString = "two";
          break;
        case 1:
          onesString = "one";
          break;
        default:
          break;
      }

    return onesString;
  }

}
