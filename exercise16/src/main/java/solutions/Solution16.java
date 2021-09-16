/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.util.Scanner;

/*
Write a program that asks the user for their age and compare it to the legal driving age of sixteen. If the user is
sixteen or older, then the program should display "You are old enough to legally drive." If the user is under sixteen,
the program should display "You are not old enough to legally drive."
    Use a single output statement.
    Use a ternary operator to write this program. If your language doesn’t support a ternary operator, use a regular
    if/else statement, and still use a single output statement to display the message.

    1. Prompt user for their age
    2. Use ternary operator to set string to "You are old enough to legally drive."/"You are not old enough to legally
    drive." if age is >= or < 16.
    3. Output string
 */

public class Solution16{
    private static final Scanner userInput = new Scanner(System.in);

    static int promptage(){
        System.out.println("What is your age? ");
        return Integer.parseInt(userInput.nextLine());
    }

    static String compareage(int inputAge){
        return (inputAge >= 16)?"You are old enough to legally drive.":"You are not old enough to legally drive.";
    }

    static void output(String outputMessage){
        System.out.println(outputMessage);
    }

    public static void main(String[] args){
        int inputAge = promptage();

        String outputMessage = compareage(inputAge);

        output(outputMessage);
    }

}