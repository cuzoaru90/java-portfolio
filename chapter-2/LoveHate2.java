/* Write a program that starts with a line of text and then outputs that line of text with the first occurrence of "hate"
changed to "love". For example, a possible sample output might be

The line of text to be changed is:
I hate you.
I have rephrased that line to read:
I love you.

You can assume that the word "hate" occurs in the input. If the word "hate" occurs more than once in the line, your
program will replace only the first occurrence of "hate". Since we will not discuss input until Chapter 2, use a defined
constant for the string to be changed. To make your program work for another string, you should only need to change
the definition of this defined constant.
*/

/*
Chapter 2 allows input
*/

import java.util.*;

public class LoveHate2 {

    public static void main (String[] args) {

        String input = "";
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a line of text.");

        input = keyboard.nextLine();
        input = input.replaceFirst("hate", "love");

        System.out.println("I have changed the line to read:\n" + input);

    }

}
