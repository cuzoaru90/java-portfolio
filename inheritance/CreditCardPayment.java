public class CreditCardPayment extends Payment{

  private String name, expirationDate;
  private double number;

  public CreditCardPayment(){
    amount = 0;
  }

  public CreditCardPayment(double value){
    super(value);
    name = "John Doe";
    expirationDate = "12/31/2022";
    number = 2543945309548534L;
  }

  public void paymentDetails(){
    int bills = (int)amount;
    double cents = (amount - bills) * 100;

    System.out.printf("%d dollars and %.0f cents - ", bills, cents);
    System.out.printf("Name: %s, Number: %.0f, Expiration: %s\n",name, number, expirationDate);
  }

}
