/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
Write a simple program to compute the tax on an order amount. The program should prompt for the order amount and the
state. If the state is "WI", then the order must be charged 5.5% tax. The program should display the subtotal, tax, and
total for Wisconsin residents but display just the total for non-residents.
    Implement this program using only a simple if statement, don't use an else clause.
    Ensure that all money is rounded up to the nearest cent.
    Use a single output statement at the end of the program to display the program results.

    1. Prompt user for order amount
    2. Prompt user for state
    3. Create string with total
    4. If state is WI, add subtotal and tax readouts to string and add tax to value of total.
    5. Print string
 */

public class Solution14 {
    static final double TAXRATE = 0.055;
    private static final Scanner userInput = new Scanner(System.in);

    static double promptprice(){
        System.out.println("What is the order amount? ");
        String inputPrice = userInput.nextLine();
        return Double.parseDouble(inputPrice);
    }

    static String promptstate(){
        System.out.println("What is the state? ");
        return userInput.next();
    }

    static String writereceipt(String orderState, double orderPrice){
        DecimalFormat moneyFormat = new DecimalFormat("###,##0.00");

        double orderTotal = orderPrice;
        String receipt = "";

        if (orderState.equals("WI")){
            orderTotal = Math.ceil((orderTotal + (orderPrice * Solution14.TAXRATE))*100) / 100;
            receipt = "The subtotal is $" + moneyFormat.format(orderPrice) + ".\nThe tax is $" +
                    moneyFormat.format((orderPrice * 0.055)) + ".\n";
        }

        receipt = receipt + "The total is $" + moneyFormat.format(orderTotal) + ".";

        return receipt;
    }

    static void output(String receipt){
        System.out.print(receipt);
    }

    public static void main(String[] args)
    {
        double orderPrice = promptprice();

        String orderState = promptstate();

        String receipt = writereceipt(orderState, orderPrice);

        output(receipt);
    }
}
