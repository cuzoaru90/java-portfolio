/**
 * The textfiles boynames.txt and girlnames.txt contain a list of the most popular boy and girl names in the United
 * States for the year 2016 as compiled by the Social Security Administration.
 *
 * These are blank-delimited files where the most popular name is listed first, the second most popular name is listed
 * second, and so on, to the 1,000th most popular name, which is listed last. Each line consists of the first name
 * followed by a blank space, then a character/String for gender, and number of registered births using that name in
 * the year. For example the girlnames.txt file begins with:
 *
 *    Emma, F, 19414
 *    Olivia, F, 19246
 *    Ava, F, 16237
 *
 * Write a program that reads both the girl's and boy's files into memory using arrays. Then, allow the user to input a
 * name. The program should search through both arrays. If there is a match, then it should output the popularity
 * ranking and the number of namings. The program should also indicate if there is no match.
 *
 * For example, if the user enters the name "Justice," then the program should output findings for both lists.
 *
 * Justice is ranked 477 in popularity among girls with 662 namings.
 * Justice is ranked 501 in popularity among boys with 595 namings.
 *
 * If user enters the name "Walter", then the program should output:
 *
 * Walter is not ranked among the top 1000 girl names.
 * Walter is ranked in popularity among boys with 1163 namings.
 *
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Names {

  public static final int RANKINGS = 3000; // Constant only needs to be changed for sake of input flexibility

  public static void main (String[] args){

    Entry[] boysList = new Entry[RANKINGS];
    Entry[] girlsList = new Entry[RANKINGS];

    readFileAndAdd("boynames.txt", boysList );
    readFileAndAdd("girlnames.txt", girlsList );

    Scanner keyboard = new Scanner(System.in);
    boolean validInput = false;

    System.out.println("Enter a baby's name");
    String nameInput = keyboard.next();

    Entry girlsQuery = findNameEntry(nameInput, girlsList);
    Entry boysQuery = findNameEntry(nameInput, boysList);

    outputSearchResult(girlsQuery, "girls");
    outputSearchResult(boysQuery, "boys");

  }

  public static void readFileAndAdd(String filename, Entry[] list){

    Scanner inputStream = null;

    try{
      inputStream = new Scanner(new FileInputStream(filename));
    }
    catch (FileNotFoundException e){
      System.out.println("Problem opening file.");
      System.exit(0);
    }

    String line = null;
    int ranking = 1;


    while (ranking <= RANKINGS){
      line = inputStream.nextLine();
      String[] fields = line.split(",");
      String name = fields[0];

      int births = Integer.parseInt(fields[2]);
      Entry anEntry = new Entry(name, ranking, births);

      list[ranking - 1] = anEntry;
      ranking++;
    }

    inputStream.close();
  }

  public static Entry findNameEntry(String target, Entry[] names){
    for (int i = 0; i < names.length; i++){
      String name = names[i].getName();
      if (target.equals(name)){
        return new Entry(names[i]);
      }
    }

    return null;
  }

  public static void outputSearchResult(Entry anEntry, String sex){
    if (anEntry != null) {
      System.out.printf("%s is ranked %d in popularity among %s names with %d namings\n", anEntry.getName(),
              anEntry.getRanking(), sex, anEntry.getNumberOfBirths());
    }
    else{
      System.out.printf("This name is not ranked among the top %d %s names\n", RANKINGS, sex);
    }

  }


}
