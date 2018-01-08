public class PaymentsTest {

  public static void main (String[] args){

    Payment payment = new Payment(50.25);
    CashPayment cashPayment = new CashPayment(50.25);
    CreditCardPayment creditPayment = new CreditCardPayment(50.25);

    payment.paymentDetails();
    cashPayment.paymentDetails();
    creditPayment.paymentDetails();

  }
}
