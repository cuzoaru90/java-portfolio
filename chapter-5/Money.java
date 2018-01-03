/* Define a class named Money whose objects represent amounts of U.S. money. The class should have two instance variables
of type int for the dollars and cents in the amount of money. Include a constructor with two parameters of type int for
the dollars and cents, one with one constructor of type int for an amount of dollars with zero cents, and a no-argument
constructor. Include the methods add for addition and minus for subtraction of amounts of money. These methods should
be static methods and should each have two parameters of type Money and return a value of type Money. Include a
reasonable set of accessor and mutator methods as well as the methods equals and toString. Write a test program for
your class.

Part Two: Add a second version of the methods for addition and subtraction. These methods should have the same names as
the static version but should use a calling object and a single argument. For example, this version of the add method
(for addition) has a calling object and one argument. So m1.add(m2) returns the result of adding the Money objects m1
and m2. Note that your class should have all these methods; for example, there should be two methods name add.

*/

public class Money {

  private int dollars, cents;

  /**
   * No-parameter ("default") constructor
   */
  public Money(){
    dollars = 0;
    cents = 0;
  }

  /**
   * One parameter constructor
   * @param bills
   */
  public Money(int bills){
    dollars = bills;
    cents = 0;
  }

  /**
   * Two parameter constructor
   * @param bills
   * @param coins
   */
  public Money(int bills, int coins){
    dollars = bills;
    cents = coins;
  }


  /**
   * Adds money objects
   * @param amount1
   * @param amount2
   * @return Money object from addition
   */
  public static Money add(Money amount1, Money amount2){

    int sumCents = 0;

    sumCents = ( amount1.cents + (amount1.dollars * 100) ) +
            ( amount2.cents + (amount2.dollars * 100) );

    return new Money(sumCents / 100,  sumCents % 100 );

  }

  /**
   * Subtracts money objects
   * @param amount1
   * @param amount2
   * @return Money object from subtraction
   */
  public static Money minus(Money amount1, Money amount2){

    int differenceCents = 0;

    differenceCents = ( amount1.cents + (amount1.dollars * 100) ) -
            ( amount2.cents + (amount2.dollars * 100) );

    return new Money(differenceCents / 100,  differenceCents % 100 );

  }

  public Money add(Money anotherMoney){
    return add(this, anotherMoney);
  }

  public Money minus(Money anotherMoney){
    return minus(this, anotherMoney);
  }

  /**
   * Converts money object to String
   * @return String representation of Money
   */
  public String toString(){
    return dollars + " dollars " + cents + " cents";
  }

  /**
   * Checks for equality
   * @param anotherMoney
   * @return Value of boolean expression
   */
  public boolean equals(Money anotherMoney){
    return (dollars == anotherMoney.dollars &&
       cents == anotherMoney.cents);
  }


}
