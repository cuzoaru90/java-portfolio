/* Write a grading program for a class with the following grading policies:

a. There are three quizzes, each graded on the basis of 10 points.
b. There is one midterm exam, graded on the basis of 100 points.
c. There is one final exam, graded on the basis of 100 points.

The final exam counts for 40 percent of the grade. The midterm counts for 35 percent of the grade. The three quizzes
together count for a total of 25 percent of the grade. (Do not forget to convert the quiz scores to percentages before
they are averaged in.)

Any grade of 90 or more is an A, any grade of 80 or more (but less than 90) is a B, any grade of 70 or more
(but less than 80) is a C, any grade of 60 or more (but less than 70) is a D, and any grade below 60 is an F. The
program should read in the student's scores and output the student's record, which consists of three quiz scores,
two exams, as well as the student's overall numeric score for the entire course and final letter grade.

Define and use a class for the student record. The class should have instance variables for the quizzes, midterm, final,
overall numeric score for the course, and final letter grade. The overall numeric score is a number in the range 0
to 100, which represents the weighted average of the student's work. The class should have methods to compute the
overall numeric grade and the final letter grade. These last methods should be void methods that set the appropriate
instance variables. Your class should have a reasonable set of accessor and mutator methods, an equals method, and a
toString method, whether or not your program uses them. You may add other methods if you wish.
 */

public class StudentRecord {

  private int quiz1, quiz2, quiz3, midtermScore, finalExamScore;
  private double overallScore;
  private char letterGrade;

  public StudentRecord(int q1, int q2, int q3, int midterm, int finalExam){
    quiz1 = q1;
    quiz2 = q2;
    quiz3 = q3;

    midtermScore = midterm;
    finalExamScore = finalExam;
  }

  public double getOverallScore(){
    return overallScore;
  }

  public void printScore(){
    System.out.println(overallScore);
  }

  public void printLetterGrade(){
    System.out.println(letterGrade);
  }

  public void calculateOverallScore(){
    double quizTotal = ( (quiz1 + quiz2 + quiz3 * 1.0 )/30 ) * 25;
    double midTotal = (midtermScore * 1.0/100) * 35;
    double finalTotal = (finalExamScore * 1.0/100) * 45;

    overallScore = (quizTotal + midTotal + finalTotal);
  }

  public void assignLetterGrade(){

   if (overallScore >= 90){
     letterGrade = 'A';
   }
   else if (overallScore >= 80){
     letterGrade = 'B';
   }
   else if (overallScore >= 70){
     letterGrade = 'C';
   }
   else if (overallScore >= 60){
     letterGrade = 'D';
   }
   else
     letterGrade = 'F';
  }

}
