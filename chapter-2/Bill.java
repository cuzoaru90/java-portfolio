/* Write a program that inputs the name, quantity, and price of three items. The name may contain spaces. Output a bill
with a tax rate of 6.25%. All prices should be output to two decimal places. The bill should be formatted in columns
with 30 characters for the name, 10 characters for the quantity, 10 characters for the price, and 10 characters for the
total.
 */

import java.util.*;

public class Bill {
  public static void main (String[] args){

    String item1, item2, item3;
    int quantity1, quantity2, quantity3;
    double price1, price2, price3, subTotal, tax, total;

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Input name of item 1:");
    item1 = keyboard.nextLine();

    System.out.println("Input quantity of item 1:");
    quantity1 = keyboard.nextInt();
    keyboard.nextLine(); // Inserted after nextInt and nextDouble to resolve input issues

    System.out.println("Input price of item 1:");
    price1 = keyboard.nextDouble();
    keyboard.nextLine();

    System.out.println("Input name of item 2:");
    item2 = keyboard.nextLine();

    System.out.println("Input quantity of item 2:");
    quantity2 = keyboard.nextInt();
    keyboard.nextLine();

    System.out.println("Input price of item 2:");
    price2 = keyboard.nextDouble();
    keyboard.nextLine();

    System.out.println("Input name of item 3:");
    item3 = keyboard.nextLine();

    System.out.println("Input quantity of item 3:");
    quantity3 = keyboard.nextInt();

    System.out.println("Input price of item 3:");
    price3 = keyboard.nextDouble();

    System.out.println("Your bill:");

    System.out.printf("%-30s %-10s %-10s %-10s\n", "Item", "Quantity", "Price", "Total");
    System.out.printf("%-30s %-10d %-10.2f %-10.2f\n", item1, quantity1, price1, quantity1 * price1);
    System.out.printf("%-30s %-10d %-10.2f %-10.2f\n", item2, quantity2, price2, quantity2 * price2);
    System.out.printf("%-30s %-10d %-10.2f %-10.2f\n", item3, quantity3, price3, quantity3 * price3);

    subTotal = quantity1 * price1 + quantity2 * price2 + quantity3 * price3;

    tax = subTotal * .0625;

    total = subTotal + tax;

    System.out.printf("\n%-30s %10s %10s %-10.2f\n", "Subtotal", "", "", subTotal);
    System.out.printf("%-30s %10s %10s %-10.2f\n", "6.25% sales tax", "", "", tax);
    System.out.printf("%-30s %10s %10s %-10.2f\n", "Total", "", "", total);


  }
}
