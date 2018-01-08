/**
 * Write a program to assign passengers seats in an airplane. Assume a small airplane with seat numberings as follows:
 *
 * 1  A B   C D
 * 2  A B   C D
 * 3  A B   C D
 * 4  A B   C D
 * 5  A B   C D
 * 6  A B   C D
 * 7  A B   C D
 *
 * The program should display the seat pattern, with an 'X' marking the seats already assigned. For example, after seats
 * 1A, 2B, and 4C are taken, the display should look like:
 *
 * 1  X B   C D
 * 2  A X   C D
 * 3  A B   C D
 * 4  A B   X D
 * 5  A B   C D
 * 6  A B   C D
 * 7  A B   C D
 *
 * After displaying the seats available, the program should prompt for the seat desired, the user can type in a seat,
 * and then the display of available seats should be updated. This continues until all seats are filled or until the
 * user signals that the program should end. If the user types in a seat that is already assigned, the program should
 * say that that seat is occupied and ask for another choice.
 *
 *
 *
 */
import java.util.*;

public class Airplane {

  public static final int ROWS = 7;
  public static final int COLUMNS = 4;

  public static void main (String[] args){

    Seat[][] airplane = new Seat[ROWS][COLUMNS];

    for (int rows = 0; rows < ROWS; rows++){
      for (int columns = 0; columns < COLUMNS; columns++){
        String letter = assignLetter(columns);
        airplane[rows][columns] = new Seat(letter, false);
      }
    }

    displaySeats(airplane);

    Scanner keyboard = new Scanner(System.in);

    boolean seatsFilled = false;

    while (!seatsFilled) {

      System.out.println("Please choose a seat to be filled (e.g. 2A) or 'q' to quit");

      String input = keyboard.next();

      if (input.toLowerCase().equals("q")){
        System.out.println("Goodbye");
        System.exit(0);
      }

      occupySeat(input, airplane);

      displaySeats(airplane);

      seatsFilled = allSeatsFilled(airplane);

    }

  }

  public static String assignLetter(int column){

    switch (column){
      case 0:
        return "A";
      case 1:
        return "B";
      case 2:
        return "C";
      case 3:
        return "D";
    }

    return " ";

  }

  public static void displaySeats(Seat[][] seats){

    int rowNumber = 1;

    for (Seat[] row: seats){
      System.out.print(rowNumber + "  ");
      displayRow(row);
      rowNumber++;
    }

    System.out.println();

  }

  public static void displayRow(Seat[] row){
    System.out.println(row[0].getLetter() + " " + row[1].getLetter() + "   " +
            row[2].getLetter() + " " + row[3].getLetter());
  }

  public static void occupySeat(String input, Seat[][] seats){

    String rowInput = input.substring(0, 1);
    String letterInput = input.substring(1, 2);

    int rowNumber = Integer.parseInt(rowInput);

    Seat seat = findSeat(letterInput, rowNumber, seats);
    seat.makeAssignment();
  }

  public static Seat findSeat(String letter, int rowNum, Seat[][] seats){

    int letterIndex = 0;

    if (letter.equals("A")) {
      letterIndex = 0;
    }
    else if (letter.equals("B")) {
      letterIndex = 1;
    }
    else if (letter.equals("C")) {
      letterIndex = 2;
    }
    else if (letter.equals("D")) {
      letterIndex = 3;
    }

    return seats[rowNum - 1][letterIndex];
  }

  public static boolean allSeatsFilled (Seat[][] seats){

    for (int rows = 0; rows < ROWS; rows++){
      for (int columns = 0; columns < COLUMNS; columns++){
        Seat seat = seats[rows][columns];
        if ( !seat.occupied() ){
          return false;
        }
      }
    }

    return true;

  }


}
