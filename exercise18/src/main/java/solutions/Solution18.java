/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
Create a program that converts temperatures from Fahrenheit to Celsius or from Celsius to Fahrenheit. Prompt for the
starting temperature. The program should prompt for the type of conversion and then perform the conversion. The
formulas are C = (F - 32) * 5/9, and F = (C * 9/5) + 32.
    Ensure that you allow upper or lowercase values for C and F.
    Use as few output statements as possible and avoid repeating output strings.

    1. Prompt user for type of conversion.
    2. Prompt user for temperature.
    3. Convert temperature using specified conversion formula.
    4. Output result.
 */

public class Solution18 {
    static final String ERROR1 = "Please enter a numeric amount.";
    private static final Scanner userInput = new Scanner(System.in);

    static String prompttype()
    {
        while(true) {
            System.out.printf("Press C to convert from Fahrenheit to Celsius.%nPress F to convert from Celsius to " +
                    "Fahrenheit.%n");
            String inputType = userInput.nextLine();
            if (inputType.equalsIgnoreCase("C")) {
                return "Celsius";
            }
            else if (inputType.equalsIgnoreCase("F")) {
                return "Fahrenheit";
            }
            else {
                System.out.println("Please enter F or C.");
            }
        }
    }

    static String conversionfromtype(String conversionType){
        if(conversionType.equals("Celsius")){
            return "Fahrenheit";
        }
        else{
            return "Celsius";
        }
    }

    static double prompttemperature(String conversionFrom){
        while(true){
            System.out.printf("Please enter the temperature in %s:%n", conversionFrom);
            String inputTemperature = userInput.nextLine();
            try{
                Double.parseDouble(inputTemperature);
            } catch (NumberFormatException nfe) {
                System.out.println(Solution18.ERROR1);
                continue;
            }
            return Double.parseDouble(inputTemperature);
        }
    }

    static double converttemperature(String conversionType, double conversionTemperature){
        if(conversionType.equals("Fahrenheit")){
            return (conversionTemperature * 9 / 5) + 32;
        }
        else{
            return (conversionTemperature - 32) * 5 / 9;
        }
    }

    static void output(String conversionType, double convertedTemperature){
        DecimalFormat tempFormat;

        if(convertedTemperature % 1 == 0){
            tempFormat = new DecimalFormat("###");
        }
        else{
            tempFormat = new DecimalFormat("###.#");
        }
        System.out.printf("The temperature in %s is %s.", conversionType, tempFormat.format(convertedTemperature));
    }

    public static void main(String[] args)
    {
        String conversionType = prompttype();
        String conversionFrom = conversionfromtype(conversionType);
        double conversionTemperature = prompttemperature(conversionFrom);

        double convertedTemperature = converttemperature(conversionType, conversionTemperature);

        output(conversionType, convertedTemperature);
    }
}
