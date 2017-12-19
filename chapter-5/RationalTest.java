public class RationalTest {

  public static void main(String[] args){

    Rational r1 = new Rational(1, 8);
    Rational r2 = new Rational(3, -8);

    Rational sum = Rational.addition(r1, r2);
    System.out.println(sum);

    Rational difference = Rational.subtraction(r1, r2);
    System.out.println(difference);

    Rational product = Rational.multiplication(r1, r2);
    System.out.println(product);

    Rational quotient = Rational.division(r1, r2);
    System.out.println(quotient);

  }

}
