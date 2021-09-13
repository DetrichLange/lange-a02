/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.util.Scanner;
import java.util.Calendar;

/*
Exercise 6, Retirement Calculator
Create a program tht determines how many years you have left until retirement and the year you can retire.
It should prompt for your current age and the age you want to retire and display the output as shown in the example.
    Be sure to convert the input to numerical data before doing any math.
    Don't hard-code the current year into your program. Get it from the system time via your programming language.

    1. Prompt user for age
    2. Save age to string inputAge
    3. Prompt user for year of retirement
    4. Save year to string inputRetirement
    5. Get current year from calendar
    6. Subtract current age from retirement age for how many years until retirement, add to current year to determine retirement year
    7. Output the statement
 */

public class Solution06 {
    private static Scanner userInput = new Scanner(System.in);

    static int promptage(){
        System.out.println("What is your current age? ");
        String inputAge = userInput.nextLine();
        return Integer.parseInt(inputAge);
    }

    static int promptretirement(){
        System.out.println("At what age would you like to retire? ");
        String inputRetirement = userInput.nextLine();
        return Integer.parseInt(inputRetirement);
    }

    static int getyear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    static void output(int userAge, int userRetirement, int currentYear){
        System.out.printf("You have %d years left until you can retire.%nIt's %d, so you can retire in %d.",
                userRetirement - userAge, currentYear, currentYear + userRetirement - userAge);
    }

    public static void main(String[] args)
    {
        int userAge = promptage();

        int userRetirement = promptretirement();

        int currentYear = getyear();

        output(userAge, userRetirement, currentYear);
    }
}
