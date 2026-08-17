/**
 * Author: Justin Bradley
 * Date: August 16, 2026
 * Course: CSD 402
 * Assignment: Module 1.3 - Water Heating Energy Calculator
 *
 * Calculates the energy (in Joules) needed to heat a given mass of water
 * from an initial temperature to a final temperature, using:
 *     Q = waterMass * (finalTemperature - initialTemperature) * 4184
 */
import java.util.Scanner;

public class WaterHeatingEnergy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt for the mass of water in kilograms
        System.out.print("Enter the mass of water in kilograms: ");
        double waterMass = input.nextDouble();

        // Prompt for initial and final temperatures in Celsius
        System.out.print("Enter the initial temperature in Celsius: ");
        double initialTemperature = input.nextDouble();

        System.out.print("Enter the final temperature in Celsius: ");
        double finalTemperature = input.nextDouble();

        // Apply the energy formula
        double q = waterMass * (finalTemperature - initialTemperature) * 4184;

        // Display the result
        System.out.println("The energy needed is " + q + " Joules.");

        input.close();
    }
}