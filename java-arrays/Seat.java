public class Seat {

  private String letter;
  private boolean assigned;

  public Seat(String letter, boolean assignment ){
    this.letter = letter;
    assigned = assignment;
  }

  public String getLetter(){
    return letter;
  }

  public void setValues(String letter, boolean assignment){
    this.letter = letter;
    assigned = assignment;
  }

  public void makeAssignment(){
    if (!assigned){
      assigned = true;
      letter = "X";
    }
    else{
      System.out.println("\nSeat has been taken, please make another choice");
    }
  }

  public boolean occupied(){
    return assigned;
  }



}
