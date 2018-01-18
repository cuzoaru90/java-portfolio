/**
 * Write a program that can serve as a simple calculator. This calculator keeps track of a single number (of type
 * double) that is called result and that starts out as 0.0. Each cycle allows the user to repeatedly add, subtract,
 * multiply, or divide by a second number. The result of one of these operations becomes the new value of result. The
 * calculation ends when the user enters the letter R for "result" (either in uppercase or lowercase). The user is
 * allowed to do another calculation from the beginning as often as desired.
 *
 * The input format is shown in the following sample dialogue. If the user enters any operator symbol other than +, -,
 * *, or /, then an UnknownOperatorException is thrown and the user is asked to reenter that line of input. Defining
 * the class UnknownOperatorException is part of this project.
 *
 *
 *
 */
import java.util.*;

public class Calculator {

  public static void main (String[] args){

    Scanner keyboard = new Scanner(System.in);
    double result = 0.0;

    System.out.println("Calculator is on");
    System.out.printf("result = %.2f\n", result );

    double inputValue = 0.0;
    String strInput = "";

    do {

      try {
        strInput = keyboard.next();

        validInput(strInput);

        if (strInput.equals("r")){
          restartOption(result);
          result = 0.0;
        }
        else{
          inputValue = keyboard.nextDouble();
          result = operationResult(strInput, result, inputValue);
        }

        System.out.printf("Updated result = %.2f\n",result);

      } catch (UnknownOperatorException e) {
        System.out.println(strInput + e.getMessage());
      } catch (InputMismatchException e) {
        System.out.println("Numerical input must be a double");
        keyboard.next();
      }

    } while(true);

  }

  public static boolean validInput(String operator) throws UnknownOperatorException{

    if (operator.equals("+") || operator.equals("-")
         || operator.equals("*") || operator.equals("/")
         || operator.equals("r")   )
    {
      return true;
    }

    throw new UnknownOperatorException();

  }

  public static double operationResult(String operator, double total, double value){

    if (operator.equals("+")){
      return total + value;
    }
    else if (operator.equals("-")){
      return total - value;
    }
    else if (operator.equals("*")){
      return total * value;
    }
    else if (operator.equals("/")){
      return total / value;
    }

    return total;

  }

  public static void restartOption(double result){

    System.out.printf("Final result = %.2f\n", result);
    System.out.println("Again? (y/n)");

    Scanner keyboard = new Scanner(System.in);

    boolean flag = false;

    while (!flag){
      String choice = keyboard.next().toLowerCase();

      if (choice.equals("y")){
        flag = true;
      }
      else if (choice.equals("n")){
        System.out.println("End of program");
        System.exit(0);
      }
      else{
        System.out.println("Choose yes or no.");
      }

    }

  }

}
