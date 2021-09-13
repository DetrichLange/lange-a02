/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package Solutions;
import java.util.Scanner;

/*
Write a program that converts currency. Specifically, convert euros to US dollars. Prompt for the amount of money in
euros you have, and prompt for the current exchange rate of the euro. Print out the new amount in US dollars. The
formula for currency conversion is derived from: c_to / c_from = rate
where: c_to is the amount in dollars, c_from is the amount in euros, rate is the current exchange rate from c_from to
c_to
    Ensure that fractions of a cent are rounded up to the next penny
    Use a single output statement

    1. Prompt for amount of euros, convert to double
    2. Prompt for exchange rate of euro, convert to double
    3. Multiply amount of euros by exchange rate
    4. Round value up to next cent by multiplying by 100, take ceiling, then divide by 100
    5. Print output
 */

public class Solution11 {
    private static Scanner userInput = new Scanner(System.in);

    static double prompteuros(){
        System.out.println("How many euros are you exchanging? ");
        String inputEuros = userInput.nextLine();
        double exchangeEuros = Double.parseDouble(inputEuros);
        return exchangeEuros;
    }

    static double promptrate(){
        System.out.println("What is the exchange rate? ");
        String inputRate = userInput.nextLine();
        double exchangeRate = Double.parseDouble(inputRate);
        return exchangeRate;
    }

    static double convertvalues(double exchangeEuros, double exchangeRate){
        double exchangeDollarsUnrounded = exchangeEuros * exchangeRate;
        return exchangeDollarsUnrounded;
    }

    static double rounddollars(double exchangeDollarsUnrounded){
        double exchangeDollarsRounded = Math.ceil(exchangeDollarsUnrounded * 100) / 100;
        return exchangeDollarsRounded;
    }

    static void output(double exchangeEuros, double exchangeRate, double exchangeDollarsRounded){
        System.out.printf("%.0f euros at an exchange rate of %s is %.2f US dollars.", exchangeEuros, String.valueOf(exchangeRate),
                exchangeDollarsRounded);
    }

    public static void main(String[] args)
    {
        double exchangeEuros = prompteuros();
        double exchangeRate = promptrate();

        double exchangeDollarsUnrounded = convertvalues(exchangeEuros, exchangeRate);

        double exchangeDollarsRounded = rounddollars(exchangeDollarsUnrounded);

        output(exchangeEuros, exchangeRate, exchangeDollarsRounded);
    }
}
