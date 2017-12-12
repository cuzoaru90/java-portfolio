public class TeamCompetitionTest {

  public static void main(String[]args){

    Team team1 = new Team();

    Team team1Copy = new Team(team1);
    team1Copy.changeName("Deep Copy");

    team1.changeName("Original Team");

    Competition comp1 = new Competition("First competition", team1.getName(),
            team1Copy.getName(), 2012);
    Competition comp2 = new Competition("Second competition", team1Copy.getName(),
            team1.getName(), 2012);

    comp1.displayCompetition();
    comp2.displayCompetition();

  }

}
