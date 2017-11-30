public class TemperatureTest {
  public static void main(String[]args){

    Temperature temp = new Temperature(212, 'F');
    Temperature temp2 = new Temperature(120, 'C');

    System.out.println( temp.getDegreesC() );

    System.out.println(temp.equals(temp2));

    System.out.println(temp.lessThan(temp2));

    System.out.println(temp.greaterThan(temp2));

  }


}
