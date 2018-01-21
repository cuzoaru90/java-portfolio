import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Write a program that gives and takes advice on program writing. The program starts by writing a piece of advice to
 * the screen and asking the user to type in a different piece of advice. The program then ends. The next person to
 * run the program receives the advice given by the person who last ran the program. The advice is kept in a text file
 * and the content of the file changes after each run of the program. You can use your editor to enter the initial
 * piece of advice in the file so that the first person who runs the program receives some advice. Allow the user to
 * type in advice of any length so that it can be any number of lines long. The user is told to end his or her advice
 * by pressing the Return key two times.
 *
 * Your program can then test to see that it has reached the end of the input by checking to see when it reads two
 * consecutive occurrences of the character '\n'.
 *
 */

public class Advice {

  public static void main (String[] args){

    readFileAndPrintAdvice("advice.txt");

    Scanner keyboard = new Scanner(System.in);

    PrintWriter outputStream = null;

    try{
      outputStream = new PrintWriter(new FileOutputStream("advice.txt", true));
    }
    catch(FileNotFoundException e){
      System.out.println("Error opening the file ");
      System.exit(0);
    }

    System.out.println("Enter a piece of advice");

    String input = keyboard.nextLine();

    while (!input.equals("")) {
      outputStream.println(input);
      input = keyboard.nextLine();
    }

    outputStream.close();

  }

  public static void readFileAndPrintAdvice(String filename){

    Scanner inputStream = null;

    try{
      inputStream = new Scanner(new FileInputStream(filename));
    }
    catch (FileNotFoundException e){
      System.out.println("Problem opening file.");
      System.exit(0);
    }

    String line = "";

    while (inputStream.hasNextLine()){
      line = inputStream.nextLine();
      System.out.println(line);
    }

    inputStream.close();

  }


}
