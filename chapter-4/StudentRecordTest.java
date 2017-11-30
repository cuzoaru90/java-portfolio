public class StudentRecordTest {
  public static void main(String[]args){
    StudentRecord tim = new StudentRecord(6, 8, 7, 78, 94);
    tim.calculateOverallScore();
    tim.printScore();

    tim.assignLetterGrade();
    tim.printLetterGrade();

  }
}
