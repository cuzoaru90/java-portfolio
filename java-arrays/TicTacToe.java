import java.util.*;

public class TicTacToe {

  public static void main(String[] args){

    Position[] board = new Position[9];

    for (int i = 0; i < board.length; i++){
      board[i] = new Position( Integer.toString(i + 1), false);
    }

    boolean playerTurn = true;
    String marker = "X";

    boolean gameOver = false;

    displayBoard(board);

    while (!gameOver) {

      marker = getMarker(playerTurn);

      Scanner keyboard = new Scanner(System.in);

      System.out.println("Choose a number");

      String input = keyboard.next();

      makeMove(board, input, marker);

      displayBoard(board);

      gameOver = checkForWinner(board, marker);

      playerTurn = alternatePlayer(playerTurn);

    }

  }

  public static void makeMove(Position[] arr, String input, String marker){
    for (int i = 0; i < arr.length; i++){
      if ( arr[i].getPosition().equals(input) &&
              !arr[i].marked() ){
         System.out.println(input);
         arr[i].setValues(marker, true);
      }
    }
  }

  public static boolean alternatePlayer(boolean turn){
    if (turn){
      return false;
    }
    else{
      return true;
    }
  }

  public static String getMarker(boolean turn){
    if (turn){
      return "X";
    }
    else{
      return "O";
    }
  }

  public static void displayBoard(Position[] arr){
    for (int i = 0; i < arr.length; i++){
      System.out.print(arr[i].getPosition() + " ");
      if ( (i + 1) % 3 == 0){
        System.out.println();
      }
    }
    System.out.println();
  }

  public static boolean checkForWinner(Position[] arr, String marker){

    checkRows(arr, marker);
    checkColumns(arr, marker);
    checkDiagonals(arr, marker);

    return false;
  }

  public static boolean checkRows(Position [] arr, String marker){
    for (int index = 0; index < 9; index +=3){
      if (arr[index].getPosition().equals(marker) && arr[index + 1].getPosition().equals(marker) &&
              arr[index + 2].getPosition().equals(marker) ){
        System.out.println("Player " + marker + " wins");
        return true;
      }
    }
    return false;
  }

  public static boolean checkColumns(Position [] arr, String marker){
    for (int index = 0; index < 3; index++){
      if (arr[index].getPosition().equals(marker) && arr[index + 3].getPosition().equals(marker) &&
              arr[index + 6].getPosition().equals(marker) ){
        System.out.println("Player " + marker + " wins");
        return true;
      }
    }
    return false;
  }

  public static boolean checkDiagonals(Position [] arr, String marker){
    if (arr[0].getPosition().equals(marker) && arr[4].getPosition().equals(marker) &&
            arr[8].getPosition().equals(marker) ||
            arr[2].getPosition().equals(marker) && arr[4].getPosition().equals(marker) &&
                      arr[6].getPosition().equals(marker)
              ){
        System.out.println("Player " + marker + " wins");
        return true;
    }

    return false;
  }

}
