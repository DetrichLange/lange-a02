/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.util.Scanner;

/*
Write a program that converts a number from 1 to 12 to the corresponding month. Prompt for a number and display the
corresponding calendar month, with 1 being January and 12 being December. For any value outside that range, display an
appropriate error message.
    Use a switch or case statement for this program.
    Use a single output statement for this program.

    1. Prompt user for number.
    2. Use switch statement to set string value to name of corresponding month.
    3. Print output.
 */


public class Solution21 {
    private static final Scanner userInput = new Scanner(System.in);

    int promptinteger(){
        System.out.printf("Please enter the number of the month:%n");

        while(true) {
            String inputMonth = userInput.nextLine();

            try {
                Integer.parseInt(inputMonth);
            } catch (NumberFormatException nfe) {
                System.out.printf("Please enter an integer.%n");
                continue;
            }

            if(Integer.parseInt(inputMonth) < 13 && Integer.parseInt(inputMonth) > 0){
                return Integer.parseInt(inputMonth);
            }

            System.out.printf("Please enter an integer between 1 and 12 inclusive.%n");
        }
    }

    String converttomonth(int numberOfMonth){
        String nameOfMonth = "";

        switch(numberOfMonth){
            case 1: nameOfMonth = "January";
                break;
            case 2: nameOfMonth = "February";
                break;
            case 3: nameOfMonth = "March";
                break;
            case 4: nameOfMonth = "April";
                break;
            case 5: nameOfMonth = "May";
                break;
            case 6: nameOfMonth = "June";
                break;
            case 7: nameOfMonth = "July";
                break;
            case 8: nameOfMonth = "August";
                break;
            case 9: nameOfMonth = "September";
                break;
            case 10: nameOfMonth = "October";
                break;
            case 11: nameOfMonth = "November";
                break;
            case 12: nameOfMonth = "December";
                break;
            default: System.out.printf("Invalid input.%n");
                System.exit(1);
        }

        return nameOfMonth;
    }

    void output(String nameOfMonth){
        System.out.printf("The name of the month is %s.%n", nameOfMonth);
    }

    public static void main(String[] args){
        Solution21 solutionApp = new Solution21();

        int numberOfMonth = solutionApp.promptinteger();

        String nameOfMonth = solutionApp.converttomonth(numberOfMonth);

        solutionApp.output(nameOfMonth);
    }
}
