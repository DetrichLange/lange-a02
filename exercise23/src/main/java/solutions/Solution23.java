/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.util.Scanner;

/*
Create a program that walks the user through troubleshooting issues with a car. Use the following decision tree to
build the system
    Ask only questions that are relevant to the situation and to the previous answers. Don’t ask for all inputs at once.

    0. Initialize questionOne through questionSix == 0.
    1. Ask "Is the car silent when you turn the key?" If yes, questionOne = 1. If no, questionOne = 2.
    2. If questionOne == 1, ask "Are the battery terminals corroded?" If yes, questionTwo = 1. If no, questionTwo = 2.
    3. If questionOne == 2, ask "Does the car make a slicking noise?" If yes, questionThree = 1. If no,
    questionThree = 2.
    4. If questionOne == 1 and questionTwo == 1, print "Clean terminals and try starting again."
    5. If questionOne == 1 and questionTwo == 2, print
 */


public class Solution23 {
    private static final String ERROR1 = "Please enter yes or no.";
    private static final Scanner userInput = new Scanner(System.in);

    int askQuestionOne(){
        while(true) {
            System.out.printf("Is the car silent when you turn the key?%n");

            switch (userInput.nextLine()) {
                case "yes":
                    return 1;
                case "no":
                    return 2;
                default:
                    System.out.println(Solution23.ERROR1);
            }
        }
    }

    int askQuestionTwo(int questionOne){
        if(questionOne == 1){
            while(true){
                System.out.printf("Are the battery terminals corroded?%n");

                switch(userInput.nextLine()){
                    case "yes":
                        return 1;
                    case "no":
                        return 2;
                    default:
                        System.out.println(Solution23.ERROR1);
                }
            }
        }
        else{
            while(true){
                System.out.printf("Does the car make a slicking noise?%n");

                switch(userInput.nextLine()){
                    case "yes":
                        return 3;
                    case "no":
                        return 4;
                    default:
                        System.out.println(Solution23.ERROR1);
                }
            }
        }
    }

    int askQuestionThree(int questionTwo){
        if(questionTwo == 4){
            while(true){
                System.out.printf("Does the car crank up but fail to start?%n");
                switch(userInput.nextLine()){
                    case "yes":
                        return 1;
                    case "no":
                        return 2;
                    default:
                        System.out.println(Solution23.ERROR1);
                }
            }
        }
        else{
            return 0;
        }
    }

    int askQuestionFour(int questionThree){
        if(questionThree == 2){
            while(true){
                System.out.printf("Does the engine start and then die?%n");
                switch(userInput.nextLine()){
                    case "yes":
                        return 1;
                    case "no":
                        return 2;
                    default:
                        System.out.println(Solution23.ERROR1);
                }
            }
        }
        else{
            return 0;
        }
    }

    int askQuestionFive(int questionFour){
        if(questionFour == 1){
            while(true){
                System.out.printf("Does your car have fuel injection?%n");
                switch(userInput.nextLine()){
                    case "yes":
                        return 1;
                    case "no":
                        return 2;
                    default:
                        System.out.println(Solution23.ERROR1);
                }
            }
        }
        else{
            return 0;
        }
    }

    String decideSolution(int questionTwo, int questionThree, int questionFour, int questionFive){
        if(questionFive == 1){
            return "Get it in for service.";
        }
        else if(questionFive == 2){
            return "Check to ensure the choke is opening and closing.";
        }
        else if(questionFour == 2){
            return "This should not be possible.";
        }
        else if(questionThree == 1){
            return "Check spark plug connections.";
        }
        else if(questionTwo == 3){
            return "Replace the battery.";
        }
        else if(questionTwo == 2){
            return "Replace cables and try again.";
        }
        else if(questionTwo == 1){
            return "Clean terminals and try starting again.";
        }
        else{
            return "Something has gone wrong with the flowchart.";
        }
    }

    void printSolution(String solution){
        System.out.print(solution);
    }

    public static void main(String[] args) {
        Solution23 solutionApp = new Solution23();

        int questionOne = solutionApp.askQuestionOne();

        int questionTwo = solutionApp.askQuestionTwo(questionOne);

        int questionThree = solutionApp.askQuestionThree(questionTwo);

        int questionFour = solutionApp.askQuestionFour(questionThree);

        int questionFive = solutionApp.askQuestionFive(questionFour);

        String solution = solutionApp.decideSolution(questionTwo, questionThree, questionFour, questionFive);

        solutionApp.printSolution(solution);
    }
}
