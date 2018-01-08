public class Month {

  private String name;
  private double rainfall;

  public Month(){
    name = "";
    rainfall = 0;
  }

  public Month(String name, double rain){
    this.name = name;
    rainfall = rain;
  }

  public String getName(){
    return name;
  }

  public double getRainfall(){
    return rainfall;
  }

  public void setName(String name){
     this.name = name;
  }

  public void setRainfall(double rain){
    rainfall = rain;
  }

  public String toString(){
    return name + ": " + rainfall;
  }


}
