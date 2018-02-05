public class Rectangle implements Shape {

  private double height, width;

  public Rectangle(double aHeight, double aWidth){
    height = aHeight;
    width = aWidth;
  }

  public double getArea(){
    return height * width;
  }

}
