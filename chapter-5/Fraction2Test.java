public class Fraction2Test {
  public static void main(String[]args){

    Fraction2 frac1 = new Fraction2(2000, 100);
    Fraction2 frac2 = new Fraction2(340, 17);

    boolean comparison = frac1.equals(frac2);
    System.out.println(comparison);

    Fraction2 reducedFrac = Fraction2.evaluateLowestTerms(3852, 4576);
    System.out.print(reducedFrac);

  }
}
