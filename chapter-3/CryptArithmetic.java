/* In cryptarithmetic puzzles, mathematical equations are written using letters. Each letter can be a digit from 0 to
9, but no two letters can be the same. Here is a sample problem:

SEND + MORE = MONEY

A solution to the puzzle is S = 9, R = 8, O = 0, M = 1, Y = 2, E = 5, N = 6, D = 7

Write a program that finds a solution to the cryptarithmetic puzzle of:

TOO + TOO + TOO + TOO = GOOD

The simplest technique is to use a nested loop for each unique letter (in this case T, O, G, D). The loops would
systematically assign the digits from 0 to 9 to each letter. For example, it might first try T=0, O=0, G=0, D=0, then
T=0, O=0, G=0, D=1, then T=0, O=0, G=0, D=2, etc., up to T=9, O=9, G=9, D=9. In the loop body, test that each variable
is unique and that the equation is satisfied. Output the values for the letters that satisfy the equation.

*/

public class CryptArithmetic {
  public static void main (String[] args){

    int t, o, g, d;

    for (int i = 0; i <= 9; i++){
      t = i;
      for (int j = 0; j <= 9; j++){
        o = j;
        for (int k = 0; k <= 9; k++){
          g = k;
          for (int l = 0; l <= 9; l++){
            d = l;

            int valueOfToo = t * 100 + o * 10 + o;
            int valueOfGood = g * 1000 + o * 100 + o * 10 + d;

            // determines if sum of TOO + TOO + TOO + TOO is equal to GOOD
            if ( valueOfToo * 4 == valueOfGood &&
                   (t != o && t != g && t != d &&
                     o != g && o != d &&
                     g != d)
               )
            {
              System.out.printf("A solution to this puzzle is t = %d, o = %d, g = %d, d = %d\n", t,o,g,d );
            }

          }
        }
      }
    }

  }
}
