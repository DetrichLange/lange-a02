/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.util.Scanner;

/*
Create a simple self-checkout system. Prompt for the prices and quantities of three items. Calculate the subtotal of
the items. Then calculate the tax using a tax rate of 5.5%. Print out the line items with the quantity and total, and
then print out the subtotal, tax amount, and total.
    Keep the input, processing, and output parts of your program separate. Collect the input, then do the math
    operations and string building, and then print the output.
    Be sure you explicitly convert input to numerical data before doing any calculations.

    1. Prompt user for price of item 1
    2. Prompt user for quantity of item 1
    3. Repeat steps 1 and 2 for item 2 and item 3
    4. Multiply price of item 1 by quantity of item 1, price of 2 by quantity of 2, etc, then add the three products
    together to find subtotal
    4. Calculate subtotal * 0.055 to find tax
    5. Calculate subtotal + tax to find total
    6. Build string
    7. Print output
 */

public class Solution10 {
    static final double TAXRATE = 0.055;
    private static final Scanner userInput = new Scanner(System.in);

    static double promptitemprice(int itemNumber){
        System.out.printf("Enter the price of item %d:%n", itemNumber);
        String inputPrice = userInput.nextLine();
        return Double.parseDouble(inputPrice);
    }

    static double promptitemquantity(){
        System.out.println("Enter the quantity of item:");
        String inputQuantity = userInput.nextLine();
        return Double.parseDouble(inputQuantity);
    }

    static double itemtotal(double itemPrice, double itemQuantity){
        return itemPrice * itemQuantity;
    }

    static double addsubtotal(double item1Total, double item2Total, double item3Total){
        return item1Total + item2Total + item3Total;
    }

    static double calculatetax(double subtotal){
        return subtotal * Solution10.TAXRATE;
    }

    static double calculatetotal(double subtotal, double salesTax){
        return subtotal + salesTax;
    }

    static void output(double subtotal, double salesTax, double totalPrice){
        System.out.printf("Subtotal: $%.2f%nTax: $%.2f%nTotal: $%.2f", subtotal, salesTax, totalPrice);
    }

    public static void main(String[] args)
    {
        double item1Price = promptitemprice(1);
        double item1Quantity = promptitemquantity();
        double item1Total = itemtotal(item1Price, item1Quantity);

        double item2Price = promptitemprice(2);
        double item2Quantity = promptitemquantity();
        double item2Total = itemtotal(item2Price, item2Quantity);

        double item3Price = promptitemprice(3);
        double item3Quantity = promptitemquantity();
        double item3Total = itemtotal(item3Price, item3Quantity);

        double subtotal = addsubtotal(item1Total, item2Total, item3Total);

        double salesTax = calculatetax(subtotal);

        double totalPrice = calculatetotal(subtotal, salesTax);

        output(subtotal, salesTax, totalPrice);
    }
}
