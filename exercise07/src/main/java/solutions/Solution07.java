/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package Solutions;
import java.util.Scanner;

/*
Create a program that calculates the area of a room. Prompt the user for the length and width of the room in feet.
Then display the area of the room in both square feet and square meters.
    Keep the calculations separate from the output.
    Use a constant to hold the conversion factor.

    1. Create constant of 0.09290304
    2. Prompt user for length of room in feet and convert to integer.
    3. Prompt user for width of room in feet and convert to integer.
    4. Multiply length times width to find area in square feet.
    5. Multiply area in square feet by conversion factor to find area in square meters.
    6. Print output
 */

public class Solution07 {
    static final double CONVERSIONFACTOR = 0.09290304;
    private static Scanner userInput = new Scanner(System.in);

    static int promptlength(){
        System.out.println("What is the length of the room in feet? ");
        String inputLength = userInput.nextLine();
        int roomLength = Integer.parseInt(inputLength);
        return roomLength;
    }

    static int promptwidth(){
        System.out.println("What is the width of the room in feet? ");
        String inputWidth = userInput.nextLine();
        int roomWidth = Integer.parseInt(inputWidth);
        return roomWidth;
    }

    static double areafeet(int roomLength, int roomWidth){
        double areaFeet = roomLength * roomWidth;
        return areaFeet;
    }

    static double areameters(double areaFeet, double CONVERSIONFACTOR){
        double areaMeters = areaFeet * CONVERSIONFACTOR;
        return areaMeters;
    }

    static void output(int roomLength, int roomWidth, double areaFeet, double areaMeters){
        System.out.printf("You entered dimensions of %d feet by %d feet.\nThe area is\n%.0f square feet\n%f square meters",
                roomLength, roomWidth, areaFeet, areaMeters);
    }

    public static void main(String[] args)
    {
        int roomLength = promptlength();

        int roomWidth = promptwidth();

        double areaFeet = areafeet(roomLength, roomWidth);

        double areaMeters = areameters(areaFeet, CONVERSIONFACTOR);

        output(roomLength, roomWidth, areaFeet, areaMeters);
    }
}
