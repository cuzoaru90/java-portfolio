import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DuelistTest {
  public static void main(String[]args){
    Duelist aaron = new Duelist("Aaron", 0.33);
    Duelist bob = new Duelist("bob", 0.5);
    Duelist charlie = new Duelist("Charlie", 1.0);

    int duelistsStanding = Duelist.duelistsAlive;

    int totalDuels = 0;
    int aaronWins = 0, bobWins = 0, charlieWins = 0;


    // simulates 10000 duels
    for (int i = 0; i < 10000; i++) {

      // duelists shoot at target with highest accuracy until one man standing in duel loop
      while (duelistsStanding > 1) {

        // Aaron's turn
        if (aaron.isAlive() && charlie.isAlive()) {
          aaron.shootAtTarget(charlie);
        }
        else if (aaron.isAlive() && !charlie.isAlive()) {
          aaron.shootAtTarget(bob);
        }

        // Bob's turn
        if (bob.isAlive() && charlie.isAlive()) {
          bob.shootAtTarget(charlie);
        }
        else if (bob.isAlive() && !charlie.isAlive()) {
          bob.shootAtTarget(aaron);
        }

        // Charlie's turn
        if (charlie.isAlive() && bob.isAlive()) {
          charlie.shootAtTarget(bob);
        }
        else if (charlie.isAlive() && !bob.isAlive()) {
          charlie.shootAtTarget(aaron);
        }

        duelistsStanding = Duelist.duelistsAlive; // updates value when duelist falls

      } // end of dueling loop

      // Determines the last man standing; revives losers for next round
      if (aaron.isAlive()){
        aaronWins++;
        bob.revive();
        charlie.revive();
      }
      else if (bob.isAlive()){
        bobWins++;
        aaron.revive();
        charlie.revive();
      }
      else{
        charlieWins++;
        aaron.revive();
        bob.revive();
      }

      duelistsStanding = Duelist.duelistsAlive; // update to allow for more simulations after losers are revived

      totalDuels++;

    } // end of simulations

    // Simulation results

    NumberFormat percent = new DecimalFormat("0.00%");

    double aaronPercentage = aaronWins * 1.0 / totalDuels;
    System.out.printf("Aaron won %d out of %d duels, or ", aaronWins, totalDuels);
    System.out.println(percent.format(aaronPercentage));

    double bobPercentage = bobWins * 1.0 / totalDuels;
    System.out.printf("Bob won %d out of %d duels, or ", bobWins, totalDuels);
    System.out.println(percent.format(bobPercentage));

    double charliePercentage = charlieWins * 1.0 / totalDuels;
    System.out.printf("Charlie won %d out of %d duels, or ", charlieWins, totalDuels);
    System.out.println(percent.format(charliePercentage));

  }
}
