public class Fraction2Test {
  public static void main(String[]args){

    Fraction2 frac1 = new Fraction2(45, 100);
    Fraction2 frac2 = new Fraction2(360, 800);

    boolean comparison = frac1.equals(frac2);

    System.out.println(comparison);

  }
}
