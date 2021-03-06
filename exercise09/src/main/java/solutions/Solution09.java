/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.util.Scanner;

/*
Calculate gallons of paint needed to paint the ceiling of a room. Prompt for length and width, and assume one gallon
covers 350 square feet. Display the number of gallons needed to paint the ceiling as a whole number. Remember, you
can't buy a partial gallon of paint. You must round up to the next whole gallon.
    Use a constant to hold the conversion rate.
    Ensure that you round up to the next whole number.

    1. Create constant of 350
    2. Prompt user for length of room in feet and convert to integer.
    3. Prompt user for width of room in feet and convert to integer.
    4. Multiply length times width to find ceiling area in square feet.
    5. Multiply area in square feet by conversion factor to find number of gallons needed.
    6. Take ceiling of result
    7. Print output
 */

public class Solution09 {
    static final double CONVERSIONFACTOR = 350;
    private static final Scanner userInput = new Scanner(System.in);

    static double promptlength(){
        System.out.println("What is the length of the room in feet? ");
        String inputLength = userInput.nextLine();
        return Double.parseDouble(inputLength);
    }

    static double promptwidth(){
        System.out.println("What is the width of the room in feet? ");
        String inputWidth = userInput.nextLine();
        return Double.parseDouble(inputWidth);
    }

    static double areafeet(double roomLength, double roomWidth){
        return roomLength * roomWidth;
    }

    static double convertgallons(double areaFeet){
        return areaFeet / Solution09.CONVERSIONFACTOR;
    }

    static double roundgallons(double gallonsConverted){
        return Math.ceil(gallonsConverted);
    }

    static void output(double gallonsRounded, double areaFeet){
        System.out.printf("You will need to purchase %.0f gallons of paint to cover %.0f square feet.",
                gallonsRounded, areaFeet);
    }

    public static void main(String[] args)
    {
        double roomLength = promptlength();

        double roomWidth = promptwidth();

        double areaFeet = areafeet(roomLength, roomWidth);

        double gallonsConverted = convertgallons(areaFeet);

        double gallonsRounded = roundgallons(gallonsConverted);

        output(gallonsRounded, areaFeet);
    }
}
