public class Circle implements Shape {

  private double radius;

  public Circle(double aRadius){
    radius = aRadius;
  }

  public double getArea(){
    return Math.PI * (radius * radius);
  };

}
