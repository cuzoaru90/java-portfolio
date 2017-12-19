public class ComplexTest {
  public static void main(String[] args){

    Complex c1 = new Complex(6, -5);
    Complex c2 = new Complex( 8, 11);

    System.out.println("Sum: " + Complex.addition(c1, c2) );
    System.out.println("Difference: " + Complex.subtraction(c1, c2) );
    System.out.println("Product: " + Complex.multiplication(c1, c2) );

  }
}
