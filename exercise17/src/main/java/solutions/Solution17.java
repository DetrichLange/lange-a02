/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.util.Scanner;

/*
Create a program that prompts for your weight, gender, total alcohol consumed (in ounces), and the amount of time since
your last drink. Calculate your blood alcohol content (BAC) using this formula: BAC = (A × 5.14 / W × r) − .015 × H
where A is total alcohol consumed, in ounces (oz); W is body weight in pounds; r is the alcohol distribution ratio,
0.73 for men and 0.66 for women; H is number of hours since the last drink. Display whether it’s legal to drive
by comparing the blood alcohol content to 0.08.
    Prevent the user from entering non-numeric values.

    1. Prompt user for gender.
    2. Prompt user for ounces of alcohol consumed.
    3. Prompt user for weight.
    4. Prompt user for time since last drink.
    5. Calculate BAC.
    6. Compare BAC to legal limit.
    7. Return whether it's legal to drive.
 */

public class Solution17 {
    static final double LEGALLIMIT = 0.08;
    static final double DISTRIBUTIONRATIOMALE = 0.73;
    static final double DISTRIBUTIONRATIOFEMALE = 0.66;
    static final String ERROR1 = "Please enter a numeric amount.";
    static final String ERROR2 = "Please enter a positive number.";
    private static final Scanner userInput = new Scanner(System.in);

    static String promptgender()
    {
        while(true) {
            System.out.println("Please enter 1 if you are male and 2 if you are female: ");
            String inputGender = userInput.nextLine();
            if (inputGender.equals("1")) {
                return "male";
            }
            else if (inputGender.equals("2")) {
                return "female";
            }
            else {
                System.out.println("Please enter 1 or 2.");
            }
        }
    }

    static double promptounces(){
        while(true){
            System.out.println("How many ounces of alcohol have you consumed? ");
            String inputOunces = userInput.nextLine();
            try{
                Double.parseDouble(inputOunces);
            } catch (NumberFormatException nfe) {
                System.out.println(Solution17.ERROR1);
                continue;
            }
            if(Double.parseDouble(inputOunces) < 0){
                System.out.println(Solution17.ERROR2);
            }
            else{
                return Double.parseDouble(inputOunces);
            }
        }
    }

    static double promptweight(){
        while(true){
            System.out.println("How many pounds do you weigh? ");
            String inputWeight = userInput.nextLine();
            try{
                Double.parseDouble(inputWeight);
            } catch (NumberFormatException nfe) {
                System.out.println(Solution17.ERROR1);
                continue;
            }
            if(Double.parseDouble(inputWeight) < 0){
                System.out.println(Solution17.ERROR2);
            }
            else{
                return Double.parseDouble(inputWeight);
            }
        }
    }

    static double prompttime(){
        while(true){
            System.out.println("How many hours since your last drink? ");
            String inputHours = userInput.nextLine();
            try{
                Double.parseDouble(inputHours);
            } catch (NumberFormatException nfe) {
                System.out.println(Solution17.ERROR1);
                continue;
            }
            if(Double.parseDouble(inputHours) < 0){
                System.out.println(Solution17.ERROR2);
            }
            else{
                return Double.parseDouble(inputHours);
            }
        }
    }

    static double calculatebac(String userGender, double userWeight, double userOunces, double userHours){
        //BAC = (A × 5.14 / W × r) − .015 × H
        //where A is total alcohol consumed, in ounces (oz); W is body weight in pounds; r is the alcohol distribution ratio,
        //0.73 for men and 0.66 for women; H is number of hours since the last drink
        double userADR;
        if(userGender.equals("male")){
            userADR = Solution17.DISTRIBUTIONRATIOMALE;
        }
        else{
            userADR = Solution17.DISTRIBUTIONRATIOFEMALE;
        }
        return (userOunces * 5.14 / userWeight * userADR) - 0.015 * userHours;
    }

    static boolean candrive(double userBAC){
        return (userBAC < Solution17.LEGALLIMIT);
    }

    static void output(double userBAC, boolean userCanDrive){
        System.out.printf("Your BAC is %f.%n", userBAC);
        if(userCanDrive){
            System.out.print("It is legal for you to drive.");
        }
        else{
            System.out.print("It is not legal for you to drive.");
        }
    }

    public static void main(String[] args)
    {
        String userGender = promptgender();
        double userOunces = promptounces();
        double userWeight = promptweight();
        double userHours = prompttime();

        double userBAC = calculatebac(userGender, userWeight, userOunces, userHours);

        boolean userCanDrive = candrive(userBAC);

        output(userBAC, userCanDrive);

    }
}
