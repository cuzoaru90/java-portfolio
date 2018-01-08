/* You are interested in keeping track of the team members and competition information for your school's annual entries
in computer science programming competitions. Each team consists of exactly four team members. Every year your team
competes in two competitions. As an initial start for your database, create a class named Team that has the following
instance variables:

// Name for the team
String teamName;
// Names for each team members.
String name1, name2, name3, name4;
// Info on each competition
Competition competition1, competition2;

Note that there is a much better way to represent the team members and competitions using arrays; this is covered in a
subsequent chapter. The class should also have a method that outputs all the names of all team members and the
competition information to the console.

The Competition class contains variables to track the following:

String: Name of the competition, Name of the winning team, Name of the runner-up

Integer: Year of the competition

Implement the Team and Competition classes with appropriate constructor, accessor, and mutator methods. In entering
data for past competitions, you note that an entry is usually very similar to the previous year's entry. To help with
the data entry, create a deep copy constructor for the Team class. Test your copy constructor by creating a copy of an
existing team object, changing the competition information for the copy, and outputting the data for the original and
the copy. The original object should be unchanged if your deep copy constructor is working properly.

 */

public class Competition {

  private String name;
  private String winningTeam, runnerUp;
  private int year;


  public Competition(String compName, String winner, String runnerUp, int compYear){
    name = compName;
    winningTeam = winner;
    this.runnerUp = runnerUp;
    year = compYear;
  }

  public void displayCompetition(){
    System.out.printf("Competition: %s, %d\nWinner: %s, Runner-up: %s\n", name, year, winningTeam, runnerUp);
  }


}
