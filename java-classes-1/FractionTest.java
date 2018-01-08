public class FractionTest {
  public static void main (String[]args){

    Fraction frac = new Fraction(60324, 90000);

    double quotient = frac.getQuotient();
    System.out.println(quotient);

    frac.outputFraction();
    frac.getLowestTerms();
    frac.outputFraction();

    frac.setNumerator(3786);
    frac.setDenominator(7422);

    frac.getLowestTerms();
    frac.outputFraction();

  }
}
