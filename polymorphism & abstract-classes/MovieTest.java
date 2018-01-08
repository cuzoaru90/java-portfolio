public class MovieTest {

  public static void main (String[] args){
    Drama aDrama = new Drama();
    Action actionFlick = new Action();
    Comedy aComedy = new Comedy();

    double dramaFee = aDrama.calcLateFees(3);
    double actionFee = actionFlick.calcLateFees(5);
    double comedyFee = aComedy.calcLateFees(5);

    System.out.println("Individual late fees: " + dramaFee + " " + actionFee + " " + comedyFee);


    Rental[] rentals = new Rental[3];
    rentals[0] = new Rental(aDrama, 51234, 3);
    rentals[1] = new Rental(actionFlick, 50369, 5);
    rentals[2] = new Rental(aComedy, 50369, 5);

    System.out.println("Total late fees owed: " + lateFeesOwed(rentals) );

  }

  public static double lateFeesOwed(Rental[] rentals){
    double result = 0;

    for (Rental r: rentals){
      result += r.calcLateFees( r.getDaysLate() );
    }

    return result;

  }

}
