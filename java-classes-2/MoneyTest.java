public class MoneyTest {
  public static void main (String[]args){

    Money firstMoney = new Money(53, 84);
    Money secondMoney = new Money( 49, 62);

    Money sum = Money.add(firstMoney, secondMoney);
    Money difference = Money.minus(firstMoney, secondMoney);

    System.out.println(sum);
    System.out.println(difference);

  }
}
