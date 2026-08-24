/**
 * Author: Justin Bradley
 * Date: August 23, 2026
 * Course: CSD 402
 * Professor Josh Guardino
 * Assignment: Module 2.2 - Assignment
 *
 * Plays rock, paper, & scissors with the user
 */
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int computerChoice = random.nextInt(3) + 1;
        int userChoice;

        do {
            System.out.print("Enter 1 for Rock, 2 for Paper, or 3 for Scissors: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                scanner.next();
                System.out.print("Enter 1 for Rock, 2 for Paper, or 3 for Scissors: ");
            }
            userChoice = scanner.nextInt();

            if (userChoice < 1 || userChoice > 3) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
            }
        } while (userChoice < 1 || userChoice > 3);

        String computerSelection;
        String userSelection;

        if (computerChoice == 1) {
            computerSelection = "Rock";
        } else if (computerChoice == 2) {
            computerSelection = "Paper";
        } else {
            computerSelection = "Scissors";
        }

        if (userChoice == 1) {
            userSelection = "Rock";
        } else if (userChoice == 2) {
            userSelection = "Paper";
        } else {
            userSelection = "Scissors";
        }

        System.out.println();
        System.out.println("Computer's selection: " + computerSelection);
        System.out.println("User's selection:     " + userSelection);

        if (computerChoice == userChoice) {
            System.out.println("Result: Tie!");
        } else if ((userChoice == 1 && computerChoice == 3)
                || (userChoice == 2 && computerChoice == 1)
                || (userChoice == 3 && computerChoice == 2)) {
            System.out.println("Result: You win!");
        } else {
            System.out.println("Result: Computer wins!");
        }

        scanner.close();
    }
}