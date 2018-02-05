public class ShapeTest {

  public static void main(String[] args){
    Circle aCircle = new Circle(12.5);

    Rectangle aRect = new Rectangle(11, 8.45);

    double circleArea = aCircle.getArea();
    double rectArea = aRect.getArea();

    System.out.printf("Area of the circle is %.2f\n", circleArea);
    System.out.printf("Area of the rectangle is %.2f\n", rectArea);


  }

}
