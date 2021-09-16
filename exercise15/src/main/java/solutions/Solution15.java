/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.util.Scanner;

/*
Create a simple program that validates user login credentials. The program must prompt the user for a username and
password. The program should compare the password given by the user to a known password. If the password matches, the
program should display "Welcome!" If it doesn’t match, the program should display "I don’t know you."
    Use an if/else statement for this problem.
    Make sure the program is case-sensitive.

    1. Prompt user for username
    2. Prompt user for password
    3. If password is abc$123, print "Welcome!"
    4. Else, print "I don't know you."
 */

public class Solution15 {
    static final String PASSWORD = "abc$123";
    private static final Scanner userInput = new Scanner(System.in);

    static void promptusername(){
        System.out.println("What is your username? ");
        userInput.nextLine();
    }

    static String promptpassword(){
        System.out.println("What is the password? ");
        return userInput.nextLine();
    }

    static boolean passwordcheck(String inputPassword){
        return inputPassword.equals(Solution15.PASSWORD);
    }

    static void output(boolean passwordValid){
        if(passwordValid){
            System.out.println("Welcome!");
        }
        else{
            System.out.println("I don't know you.");
        }
    }

    public static void main(String[] args)
    {
        promptusername();

        String inputPassword = promptpassword();

        boolean passwordValid = passwordcheck(inputPassword);

        output(passwordValid);
    }
}
