/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package Solutions;
import java.util.Scanner;

/*
Create a program that computes simple interest. Prompt for the principal amount, the rate as a percentage, and the time,
and display the amount accrued (principal + interest).
The formula for simple interest is A = P(1 + rt) where P is the principal amount, r is the annual rate of interest, t
is the number of years the amount is invested, and A is the amount at the end of the investment.
    Prompt for the rate as a percentage (like 15, not .15). Divide the input by 100 in your program.
    Ensure that fractions of a cent are rounded up to the nearest penny.
    Ensure that the output is formatted as money.

    1. Prompt user for principal amount
    2. Prompt user for interest rate
    3. Prompt user for time of investment
    4. Calculate A = P(1 + rt)
    5. Multiply result by 100, take ceiling, divide by 100
    6. Display output
 */

public class Solution12 {
    private static Scanner userInput = new Scanner(System.in);

    static int promptprincipal(){
        System.out.println("How much money are you investing? ");
        String inputPrincipal = userInput.nextLine();
        int investPrincipal = Integer.parseInt(inputPrincipal);
        return investPrincipal;
    }

    static double promptrate(){
        System.out.println("At what percent interest annually? ");
        String inputRate = userInput.nextLine();
        double investRate = Double.parseDouble(inputRate) / 100;
        return investRate;
    }

    static int prompttime(){
        System.out.println("For how many years? ");
        String inputTime = userInput.nextLine();
        int investTime = Integer.parseInt(inputTime);
        return investTime;
    }

    static double calculateinterest(int investPrincipal, double investRate, int investTime){
        double investFinal = investPrincipal * (1 + (investRate * investTime));
        System.out.println(investFinal);
        return investFinal;
    }

    static double rounding(double investFinal){
        double investRounded = Math.ceil(investFinal * 100) / 100;
        return investRounded;
    }

    static void output(int investTime, double investRate, double investRounded){
        System.out.printf("After %d years at %s%%, the investment will be worth $%.2f.",
                investTime, String.valueOf(investRate * 100), investRounded);
    }

    public static void main(String[] args)
    {
        int investPrincipal = promptprincipal();

        double investRate = promptrate();

        int investTime = prompttime();

        double investFinal = calculateinterest(investPrincipal, investRate, investTime);

        double investRounded = rounding(investFinal);

        output(investTime, investRate, investRounded);
    }
}
