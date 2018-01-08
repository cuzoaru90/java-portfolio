public class Card {

  private int value;
  private boolean faceUp;

  public Card(int value, boolean face){
    this.value = value;
    faceUp = face;
  }

  public int getValue(){
    return value;
  }

  public boolean getFace(){
    return faceUp;
  }

  public void setValue(int value){
    this.value = value;
  }

  public void setFace(boolean face){
    faceUp = face;
  }

  public void swap(Card anotherCard){
    int tempValue = anotherCard.value;
    boolean tempFace = anotherCard.faceUp;

    anotherCard.setValue(value);
    anotherCard.setFace(faceUp);

    setValue(tempValue);
    setFace(tempFace);
  }

  public static void makeMatch(Card c1, Card c2){

    if (c1.equals(c2) ){
      System.out.println("Cannot match card with itself, please try again.");
    }
    else if (c1.faceUp || c2.faceUp){
      System.out.println("Invalid match, please select two face down cards.");
    }
    else if (c1.value == c2.value){
      System.out.printf("Matched %d and %d\n", c1.value, c2.value);
      c1.setFace(true);
      c2.setFace(true);
    }
    else{
      System.out.printf("Matching %d and %d\n", c1.value, c2.value);
    }
  }

  public boolean equals(Card anotherCard){
    return ( value == anotherCard.value &&
             faceUp == anotherCard.faceUp);
  }

  public String toString(){
    if (!faceUp){
      return "*";
    }
    else{
      return "" + value;
    }

  }

}
