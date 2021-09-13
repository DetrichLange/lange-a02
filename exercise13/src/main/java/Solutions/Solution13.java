/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package Solutions;
import java.util.Scanner;
import java.lang.Math;

/*
Write a program to calculate the value of an investment compounded over time. The program should ask for the starting
amount, the number of years to invest, the interest rate, and the number of periods per year to compound. The formula
you'll use for this is A = P((1 + r/n)^(n*t)) where P is the principal, r is the annual rate, t is the number of years
the amount is invested, n is the number of times the interest is compounded per year, and A is the amount at the end of
the investment.
    Prompt for the rate as a percentage (like 15, not .15). Divide the input by 100 in your program.
    Ensure that fractions of a cent are rounded up to the next penny.
    Ensure that the output is formatted as money.

 */



public class Solution13 {
    private static Scanner userInput = new Scanner(System.in);

    static double promptprincipal(){
        System.out.println("How much money are you investing? ");
        String inputPrincipal = userInput.nextLine();
        double investPrincipal = Double.parseDouble(inputPrincipal);
        return investPrincipal;
    }

    static double promptrate(){
        System.out.println("At what percent interest annually? ");
        String inputRate = userInput.nextLine();
        double investRate = Double.parseDouble(inputRate) / 100;
        return investRate;
    }

    static double prompttime(){
        System.out.println("For how many years? ");
        String inputTime = userInput.nextLine();
        double investTime = Double.parseDouble(inputTime);
        return investTime;
    }

    static double promptcompounds(){
        System.out.println("How many times is this interest compounded per year? ");
        String inputCompounds = userInput.nextLine();
        double investCompounds = Double.parseDouble(inputCompounds);
        return investCompounds;
    }

    static double calculateinterest(double investPrincipal, double investRate, double investTime, double investCompounds){
        double investFinal = investPrincipal * Math.pow((1 + investRate / investCompounds), (investCompounds * investTime));
        System.out.println(investFinal);
        return investFinal;
    }

    static double rounding(double investFinal){
        double investRounded = Math.ceil(investFinal * 100) / 100;
        return investRounded;
    }

    static void output(double investPrincipal, double investRate, double investTime, double investCompounds,
                       double investRounded){
        System.out.printf("$%.2f invested at %s for %.0f years compounded %.0f times per year is $%.2f.",
                investPrincipal, String.valueOf(investRate * 100), investTime,
                investCompounds, investRounded);
    }

    public static void main(String[] args)
    {
        double investPrincipal = promptprincipal();

        double investRate = promptrate();

        double investTime = prompttime();

        double investCompounds = promptcompounds();

        double investFinal = calculateinterest(investPrincipal, investRate, investTime, investCompounds);

        double investRounded = rounding(investFinal);

        output(investPrincipal, investRate, investTime, investCompounds, investRounded);
    }
}
