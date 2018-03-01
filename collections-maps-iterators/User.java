import java.util.HashSet;

public class User {

  private String name;
  private HashSet<User> links;
  private HashSet<User> secondaryLinks;

  public User(String newName){
    name = newName;
    links = new HashSet<User>();
    secondaryLinks = new HashSet<User>();
  }

  public void addLink(User newUser){
    links.add(newUser);
  }

  public void outputLinks(){
    for (User link: links){
      System.out.println(link.name);
    }
  }

  public String toString(){
    return name;
  }


}
