/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
Write a program that asks for three numbers. Check first to see that all numbers are different. If they’re not
different, then exit the program. Otherwise, display the largest number of the three.
    Write the algorithm manually. Don’t use a built-in function for finding the largest number in a list.
    1. Prompt user for first number.
    2. Prompt user for second number.
    3. If second number is equal to first number, exit program.
    4. Prompt user for third number.
    5. If third number is equal to first number or third number is equal to second number, exit program.
    6. Compare first number to second number and set biggestNumber = whichever one is bigger.
    7. Compare third number to biggestNumber and set biggestNumber = whichever one is bigger.
 */

public class Solution22 {
    private static final Scanner userInput = new Scanner(System.in);

        double promptnumber(String whichNumber){
            while(true) {
                System.out.printf("Enter the %s number:%n", whichNumber);
                try {
                    return Double.parseDouble(userInput.nextLine());
                } catch (NumberFormatException nfe) {
                    System.out.printf("Please enter a number.%n");
                }
            }
        }

        void checkIfEqual(double number1, double number2){
            if(number1 == number2){
                System.out.printf("Numbers are equal, exiting program.%n");
                System.exit(1);
            }
        }

        double findBiggerNumber(double number1, double number2){
            return Math.max(number1, number2);
        }

        void output(double biggestNumber){
            DecimalFormat numberFormat;

            if(biggestNumber % 1 == 0){
                numberFormat = new DecimalFormat("#####");
            }
            else{
                numberFormat = new DecimalFormat("#####.#####");
            }
            System.out.printf("The largest number is %s.%n", numberFormat.format(biggestNumber));
        }


    public static void main(String[] args){
        Solution22 solutionApp = new Solution22();

        double firstNumber = solutionApp.promptnumber("first");
        double secondNumber = solutionApp.promptnumber("second");
        solutionApp.checkIfEqual(firstNumber, secondNumber);

        double thirdNumber = solutionApp.promptnumber("third");
        solutionApp.checkIfEqual(firstNumber, thirdNumber);
        solutionApp.checkIfEqual(secondNumber, thirdNumber);

        double biggerNumber = solutionApp.findBiggerNumber(firstNumber, secondNumber);
        double biggestNumber = solutionApp.findBiggerNumber(biggerNumber, thirdNumber);

        solutionApp.output(biggestNumber);
    }
}