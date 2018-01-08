/** In the sport of diving, seven judges award a score between 0 and 10, where each score may be a floating-point value.
 * The highest and lowest scores are thrown out and the remaining scores are added together. The sum is then multiplied
 * by the degree of difficulty for that dive. The degree of difficulty ranges from 1.2 to 3.8 points. The total is then
 * multiplied by 0.6 to determine the diver's score.
 *
 * Write a computer program that inputs a degree of difficulty and seven judges' scores and outputs the overall score
 * for that dive. The program should ensure that all inputs are within the allowable data ranges.
 *
 */

import java.util.*;

public class Diving {

  public static void main (String [] args){

    double [] judgeScores = new double[7];
    boolean validDifficulty = false;

    double difficulty = 0;

    Scanner keyboard = new Scanner(System.in);

    while (!validDifficulty) {
      System.out.println("Input the difficulty of the dive:");
      difficulty = keyboard.nextDouble();
      keyboard.nextLine();

      if (difficulty >= 1.2 && difficulty <= 3.8) {
        validDifficulty = true;
      } else {
        System.out.println("Invalid dive difficulty. Enter a value (between 1.2 and 3.8):");
      }

    }

    boolean validScores = false;

    System.out.println("Please enter judges scores:");

    while (!validScores){

      for (int i = 0; i < judgeScores.length; i++){
        judgeScores[i] = keyboard.nextDouble();
      }

      validScores = validateJudgeInput(judgeScores);
    }

    Arrays.sort(judgeScores);

    double overallScore = calculateScore(judgeScores, difficulty);
    System.out.println(overallScore);

  }

  public static boolean validateJudgeInput(double [] scores){
    for (double score : scores) {
      if (score < 0 || score > 10) {
        System.out.println("Detected invalid judge input. Try again.");
        return false;
      }
    }
    return true;
  }

  public static double calculateScore(double[] scores, double difficulty){
    double judgeSum = 0;

    for (int i = 1; i < scores.length - 1; i++){
      judgeSum += scores[i];
    }

    return judgeSum * difficulty * 0.6;
  }

}
