
public class Entry {

  private int value;
  private int occurrences;

  public Entry(int num, int occurrences){
    value = num;
    this.occurrences = occurrences;
  }

  public void incrementOccurences(){
    occurrences++;
  }

  public int getValue() {
    return value;
  }

  public String toString(){
    return value + " " + occurrences;
  }

}
