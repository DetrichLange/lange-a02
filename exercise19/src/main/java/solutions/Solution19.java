/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
Create a program to calculate the body mass index (BMI) for a person using the person's height in inches and weight in
pounds. The program should prompt the user for height and weight. Calculate the BMI using the following formula:
bmi = (weight / (height * height)) * 703. If the BMI is between 18.5 and 25, display that the person is at a normal
weight. If they are out of that range, tell them if they are underweight or overweight and tell them to consult their
doctor.
    Ensure your program takes only numeric data. Don't let the user continue unless the data is valid.

    1. Prompt user for their height.
    2. Prompt user for their weight.
    3. Calculate user's BMI.
    4. Compare to 18.5-25 range.
    5. Output under/over/ideal weight.
 */

public class Solution19 {
    static final String ERROR1 = "Please enter a numeric amount.";
    static final String ERROR2 = "Please enter a positive number.";
    private static final Scanner userInput = new Scanner(System.in);

    static double promptheight(){
        String inputHeight;
        while(true){
            System.out.printf("Please enter your height in inches:%n");
            inputHeight = userInput.nextLine();
            try{
                Double.parseDouble(inputHeight);
            } catch (NumberFormatException nfe) {
                System.out.println(Solution19.ERROR1);
                continue;
            }
            if(Double.parseDouble(inputHeight) < 0){
                System.out.println(Solution19.ERROR2);
            }
            else{
                return Double.parseDouble(inputHeight);
            }
        }
    }

    static double promptweight(){
        String inputWeight;
        while(true){
            System.out.printf("Please enter your weight in pounds:%n");
            inputWeight = userInput.nextLine();
            try{
                Double.parseDouble(inputWeight);
            } catch (NumberFormatException nfe) {
                System.out.println(Solution19.ERROR1);
                continue;
            }
            if(Double.parseDouble(inputWeight) < 0){
                System.out.println(Solution19.ERROR2);
            }
            else{
                return Double.parseDouble(inputWeight);
            }
        }
    }

    static double calculatebmi(double userHeight, double userWeight){
        return (userWeight / (userHeight * userHeight)) * 703;
    }

    static void output(double userBMI){
        DecimalFormat bmiFormat;

        if(userBMI % 1 == 0){
            bmiFormat = new DecimalFormat("###");
        }
        else{
            bmiFormat = new DecimalFormat("###.##");
        }

        System.out.printf("Your BMI is %s.%n", bmiFormat.format(userBMI));

        if(userBMI < 18.5){
            System.out.printf("You are underweight. You should see your doctor.%n");
        }
        else if(userBMI > 25){
            System.out.printf("You are overweight. You should see your doctor.%n");
        }
        else{
            System.out.printf("You are within the ideal weight range.%n");
        }
    }

    public static void main(String[] args) {
        double userHeight = promptheight();
        double userWeight = promptweight();

        double userBMI = calculatebmi(userHeight, userWeight);

        output(userBMI);
    }
}
