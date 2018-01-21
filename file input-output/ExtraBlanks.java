/**
 * Write a program to edit text files for extra blanks. The program will replace any string of two or more blanks with
 * a single blank. Your program should works as follows: Create a temporary file. Copy from the file to the temporary
 * file but do not copy extra blanks. Copy the contents of the temporary file back into the original file. Use a method
 * (or methods) in the class File to remove the temporary file.
 *
 * You will also want to use the class File for other things in your program. The temporary file should have a name
 * different from all existing files so that the existing files are not affected (except for the file being edited).
 * Your program will ask for the name of the file to be edited. However, it will not ask the user for the name of the
 * temporary file but instead will generate the name within the program. You can generate the name any way that is clear
 * and efficient. One possible way to generate the temporary file is to start with an unlikely name, such as "TempX",
 * and to append a character, such as 'X', until a name is found that does not name an existing file.
 *
 *
 */

import java.util.*;
import java.io.*;

public class ExtraBlanks {

  public static void main (String[] args){

    ArrayList<String> fileLines = new ArrayList<String>();

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Choose file to be edited");
    String filename = keyboard.next();

    readFileAndGetLines(filename, fileLines);

    PrintWriter outputStream = null;

    try{
      outputStream = new PrintWriter(new FileOutputStream("edited_" + filename))  ;
    }
    catch(FileNotFoundException e){
      System.out.println("Error opening the file ");
      System.exit(0);
    }

    for (String line: fileLines) {
      outputStream.println(line);
    }

    outputStream.close();

  }

  public static void readFileAndGetLines(String filename, ArrayList<String> lines){

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
      line = line.replaceAll("\\s+", " "); // replace one or more spaces with a single space
      lines.add(line);
    }

    inputStream.close();

  }

}
