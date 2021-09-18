/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
Create a tax calculator that handles multiple states and multiple counties within each state. The program prompts the
user for the order amount and the state where the order will be shipped.
Wisconsin residents must be changed 5% sales tax with an additional county-level charge. For Wisconsin residents,
prompt for the county of residence. For Eau Claire county residents, add an additional 0.5% tax. For Dunn county
residents, add an additional 0.4% tax.
Illinois residents must be charged 8% sales tax with no additional county-level charge.
All other states are not charged tax.
The program then displays the tax and the total for Wisconsin and Illinois residents but just the total for everyone
else.
    Ensure that all money is rounded up to the nearest cent.
    Use a single output statement at the end of the program to display the program results.

    1. Prompt user for order amount.
    2. Prompt user for state.
    3. If state is Wisconsin, prompt user for county.
    4. Calculate tax based on state and county.
    5. Assemble output string based on state, county, and calculated tax.
    6. Print output statement.
 */

public class Solution20 {
    static final String ERROR1 = "Please enter a numeric amount.%n";
    static final String ERROR2 = "Please enter a positive value.%n";
    static final String WI = "Wisconsin";
    static final String IL = "Illinois";

    private static final Scanner userInput = new Scanner(System.in);

    double promptprice(){
        while(true){
            System.out.printf("What is the order amount?%n");
            String inputPrice = userInput.nextLine();
            try{
                Double.parseDouble(inputPrice);
            } catch (NumberFormatException nfe) {
                System.out.printf(Solution20.ERROR1);
                continue;
            }
            if(Double.parseDouble(inputPrice) < 0){
                System.out.printf(Solution20.ERROR2);
            }
            else{
                return Double.parseDouble(inputPrice);
            }
        }
    }

    String promptState(){
            System.out.printf("What state do you live in?%n");
            return userInput.nextLine();
    }

    String promptCounty(String orderState){
        if(orderState.equalsIgnoreCase(Solution20.WI)){
            System.out.printf("What county do you live in?%n");
            return userInput.nextLine();
        }
        else {
            return "null";
        }
    }

    double calculateTax(String orderState, String orderCounty, double orderPrice){
        double orderTax = 0;
        if(orderState.equalsIgnoreCase(Solution20.IL)){
            orderTax += orderPrice * 0.08;
        }
        else if(orderState.equalsIgnoreCase(Solution20.WI)){
            orderTax += orderPrice * 0.05;
            if(orderCounty.equalsIgnoreCase("Eau Claire")){
                orderTax += orderPrice * 0.005;
            }
            else if(orderCounty.equalsIgnoreCase("Dunn")){
                orderTax += orderPrice * 0.004;
            }
        }

        return orderTax;
    }

    double moneyRounding(double moneyUnrounded){
        return Math.ceil((moneyUnrounded*100))/100;
    }

    double calculatetotal(double orderTaxRounded, double orderPriceRounded){
        return orderTaxRounded + orderPriceRounded;
    }

    String assembleOutput(String orderState, double orderTaxRounded, double orderPriceRounded){
        DecimalFormat moneyFormat = new DecimalFormat("###0.00");

        String output = "The total is " + moneyFormat.format(orderPriceRounded + orderTaxRounded) + ".%n";

        if(orderState.equalsIgnoreCase(Solution20.IL) || orderState.equalsIgnoreCase(Solution20.WI)){
            output = "The tax is " + moneyFormat.format(orderTaxRounded) + ".%n" + output;
        }

        return output;
    }

    void printOutput(String output){
        System.out.printf(output);
    }

    public static void main(String[] args){
        Solution20 solutionApp = new Solution20();

        double orderPrice = solutionApp.promptprice();
        String orderState = solutionApp.promptState();
        String orderCounty = solutionApp.promptCounty(orderState);
        double orderTax = solutionApp.calculateTax(orderState, orderCounty, orderPrice);

        double orderTaxRounded = solutionApp.moneyRounding(orderTax);
        double orderPriceRounded = solutionApp.moneyRounding(orderPrice);

        String output = solutionApp.assembleOutput(orderState, orderTaxRounded, orderPriceRounded);

        solutionApp.printOutput(output);

    }
}