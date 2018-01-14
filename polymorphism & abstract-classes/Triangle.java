public class Triangle extends Figure {

  public Triangle(int aHeight, int aWidth){
    height = aHeight;
    width = aWidth;
  }

  public String[][] getTriangle(){
    String[][] triangle = new String[height][width];

    for (int row = 0; row < height; row++){
      for (int column = 0; column < width; column++ ){
        if (column == width/2 - row || column == width/2 + row ){
          triangle[row][column] = "*";
        }
        else{
          triangle[row][column] = " ";
        }
      }
    }

    return triangle;
  }

  public void draw(){
    String [][] figure = getTriangle();

    for (String[] row: figure){
      for (String s: row){
        System.out.print(s);
      }
      System.out.println();
    }

  }

  public void center(Point aCenter){

  }


}
