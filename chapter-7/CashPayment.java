public class CashPayment extends Payment {

  public  CashPayment(){
    amount = 0;
  }

  public CashPayment(double value){
    super(value);
  }

  public void paymentDetails(){ int bills = (int)amount;
    double cents = (amount - bills) * 100;

    System.out.printf("%d dollars and %.0f cents in cash\n", bills, cents);
  }

}
