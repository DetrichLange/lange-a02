/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Detrich Lange
 */

package solutions;
import java.util.Scanner;

/*
Write a program to evenly divide pizzas. Prompt for the number of people, the number of pizzas, and the number of
slices per pizza. Ensure that the number of pieces comes out even. Display the number of pieces of pizza each person
should get. If there are leftovers, show the number of leftover pieces.
    1. Prompt for number of people, save as int.
    2. Prompt for number of pizzas, save as int.
    3. Prompt for number of slices per pizza, save as int.
    4. Calculate total slices by multiplying no. of pizzas * no. of slices per pizza, save as int
    5. Output that each person gets (total slices / number of people), with (total slices % number of people) remaining.
 */

public class Solution08 {
    private static Scanner userInput = new Scanner(System.in);

    static int promptguests(){
        System.out.println("How many people? ");
        String inputGuests = userInput.nextLine();
        return Integer.parseInt(inputGuests);
    }

    static int promptpizzas(){
        System.out.println("How many pizzas do you have? ");
        String inputPizzas = userInput.nextLine();
        return Integer.parseInt(inputPizzas);
    }

    static int promptslices(){
        System.out.println("How many slices per pizza? ");
        String inputSlices = userInput.nextLine();
        return Integer.parseInt(inputSlices);
    }

    static int multiplyslices(int partyPizzas, int partySlices){
        return partyPizzas * partySlices;
    }

    static int divideslices(int totalSlices, int partyGuests){
        return totalSlices / partyGuests;
    }

    static int remainderslices(int totalSlices, int partyGuests){
        return totalSlices % partyGuests;
    }

    static void output(int partyGuests, int partyPizzas, int totalSlices, int slicesPerPerson, int leftoverSlices){
        System.out.printf("""
                %d people with %d pizzas (%d slices)%nEach person gets %d pieces of pizza%nThere are %d leftover \
                pieces""", partyGuests, partyPizzas, totalSlices, slicesPerPerson, leftoverSlices);
    }

    public static void main(String[] args)
    {
        int partyGuests = promptguests();
        int partyPizzas = promptpizzas();
        int partySlices = promptslices();

        int totalSlices = multiplyslices(partyPizzas, partySlices);

        int slicesPerPerson = divideslices(totalSlices, partyGuests);

        int leftoverSlices = remainderslices(totalSlices, partyGuests);

        output(partyGuests, partyPizzas, totalSlices, slicesPerPerson, leftoverSlices);
    }
}
