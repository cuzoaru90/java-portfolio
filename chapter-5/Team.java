/*As an initial start for your database, create a class named Team that has the following
        instance variables:

// Name for the team
        String teamName;
// Names for each team members.
        String name1, name2, name3, name4;
// Info on each competition
        Competition competition1, competition2;
*/

public class Team {

    private String teamName;
    private String name1, name2, name3, name4;
    private Competition competition1, competition2; // unused for now

    /**
     * Constructor
     */
    public Team(){
      teamName = "The Team";
      name1 = "Alpha";
      name2 = "Omega";
      name3 = "Delta";
      name4 = "Epsilon";
    }

    /**
     * Copy constructor
     * @param otherTeam
     */
    public Team(Team otherTeam){
      teamName = otherTeam.teamName;
      name1 = otherTeam.name1;
      name2 = otherTeam.name2;
      name3 = otherTeam.name3;
      name4 = otherTeam.name4;
    }

    /**
     * Accessor
     * @return Name of team
     */
    public String getName(){
      return teamName;
    }

    /**
     * Mutator
     * @param newName
     */
    public void changeName(String newName){
      teamName = newName;
    }

    /**
     * Mutator
     * @param firstComp
     * @param secondComp
     */
    public void setCompetition(Competition firstComp, Competition secondComp){
      competition1 = firstComp;
      competition2 = secondComp;
    }

    /**
     * Mutator
     * @param member1
     * @param member2
     * @param member3
     * @param member4
     */
    public void changeMembers(String member1, String member2, String member3, String member4){
      name1 = member1;
      name2 = member2;
      name3 = member3;
      name4 = member4;
    }

    /**
     * Display method
     */
    public void displayTeam(){
      System.out.printf("Team: %s\nMember: %s, %s, %s, %s\n", teamName, name1, name2, name3, name4);
    }


}
