public class MoneyTest {
  public static void main (String[]args){

    Money firstMoney = new Money(53, 84);
    Money secondMoney = new Money( 49, 62);

    Money sum = Money.add(firstMoney, secondMoney);
    Money difference = Money.minus(firstMoney, secondMoney);

    System.out.println( sum.toString() );
    System.out.println( difference.toString() );

    Money sum2 = firstMoney.add(secondMoney);
    Money difference2 = firstMoney.minus(secondMoney);

    System.out.println( sum2.toString() );
    System.out.println( difference2.toString() );

  }
}
