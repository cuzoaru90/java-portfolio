/**
 * Write a program that will allow two users to play tic-tac-toe. The program should ask for moves alternately from
 * player X and player O. The program displays the game positions as follows:
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * The players enter their moves by entering the position number they wish to mark. After each move, the program
 * displays the changed board. A sample board configuration is
 * X X 0
 * 4 5 6
 * 0 8 9
 *
 *
 */

public class Position {
  private String position;
  private boolean marked;

  public Position(String value, boolean mark){
    position = value;
    marked = mark;
  }

  public boolean marked(){
    return marked;
  }

  public void setValues(String value, boolean mark){
    position = value;
    marked = true;
  }

  public String getPosition(){
    return position;
  }


}
