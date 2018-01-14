public class Rectangle extends Figure {

  public Rectangle(int aHeight, int aWidth){
    height = aHeight;
    width = aWidth;
  }

  public String[][] getRectangle(){
    String[][] rect = new String[height][width];

     for (int row = 0; row < height; row++){
       for (int column = 0; column < width; column++ ){
         if (row > 0 && row < (height - 1) && column > 0 && column < width - 1 ){
           rect[row][column] = "  ";
         }
         else{
           rect[row][column] = "* ";
         }
       }
     }

    return rect;

  }

  public void draw(){

    String [][] figure = getRectangle();

    for (String[] row: figure){
      for(String s: row){
        System.out.print(s);
      }
      System.out.println();
    }

  }

  public void center(Point aCenter){

  }

}
