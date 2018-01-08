public class Person {

  private String name;

  public Person(){
    name = "";
  }

  /**
   * Constructor
   * @param theName
   */
  public Person(String theName){
    name = theName;
  }

  /**
   * Copy constructor
   * @param theObject
   */
  public Person(Person theObject){
    name = theObject.name;
  }

  /**
   * Accessor
   * @return name String
   */
  public String getName(){
    return name;
  }

  /**
   * Mutator
   * @param theName
   */
  public void setName(String theName){
    name = theName;
  }

  /**
   * String conversion
   * @return String
   */
  public String toString(){
    return "" + name;
  }

  public boolean equals(Person other){
    return name.equals(other.name);
  }


}
