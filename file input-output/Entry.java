import java.io.Serializable;
public class Entry implements Serializable {

  private String name;
  private int ranking;
  private int numberOfBirths;

  public Entry(){
    name = null;
    ranking = 0;
    numberOfBirths = 0;
  }

  public Entry(String aName, int rank, int births){
    name = aName;
    ranking = rank;
    numberOfBirths = births;
  }

  public Entry(Entry anotherEntry){
    name = anotherEntry.name;
    ranking = anotherEntry.ranking;
    numberOfBirths = anotherEntry.numberOfBirths;
  }

  public int getNumberOfBirths(){
    return numberOfBirths;
  }

  public int getRanking(){
    return ranking;
  }

  public String getName(){
    return name;
  }

  public String toString(){
    return "Name: " + name + ", Rank: " + ranking + ", Births: " + numberOfBirths;
  }


}
