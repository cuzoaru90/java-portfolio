import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 */
public class Network {
  public static void main(String[] args){

    HashMap<String, User> users = new HashMap<String, User>();

    readFileAndAdd("links.txt", users);

    Scanner keyboard = new Scanner(System.in);

    String input = "";

    while (!input.equals("q")) {

      System.out.println("Search for a username");
      input = keyboard.next();
      User target = users.get(input);

      if (target == null) {
        System.out.println("That username does not exist in the network");
      } else {
        target.outputLinks();
      }
    }

  }

  public static void readFileAndAdd(String filename, HashMap<String, User> map){

    Scanner inputStream = null;

    try{
      inputStream = new Scanner(new FileInputStream(filename));
    }
    catch (FileNotFoundException e){
      System.out.println("Problem opening file.");
      System.exit(0);
    }

    String line = "";
    while (inputStream.hasNextLine() ){

      line = inputStream.nextLine();
      String[] fields = line.split(" ");
      String username = fields[0];
      String link = fields[1];

      if (!map.containsKey(username)) {
        User newUser = new User(username);
        map.put(username, newUser);
        newUser.addLink( new User(link) );
      }
      else{
        User currentUser = map.get(username);
        currentUser.addLink( new User(link));
      }

    }

    inputStream.close();

  }

}
