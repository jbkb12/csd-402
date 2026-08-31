/**
 * Author: Justin Bradley
 * Date: August 30, 2026
 * Course: CSD 402
 * Professor Josh Guardino
 * CSD402 - Module 4.2 Programming Assignment
 * Demonstrates method overloading with four average() methods,
 * one for each numeric array type, plus error handling for empty arrays.
 */
import java.util.Arrays;

public class AverageCalculator {

    /**
     * Calculates the average of a short array.
     * @param array the array of short values to average
     * @return the average as a short (decimal portion is truncated)
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static short average(short[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Cannot average an empty array");
        }
        long sum = 0;
        for (short value : array) {
            sum += value;
        }
        return (short) (sum / array.length);
    }

    /**
     * Calculates the average of an int array.
     * @param array the array of int values to average
     * @return the average as an int (decimal portion is truncated)
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static int average(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Cannot average an empty array");
        }
        long sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (int) (sum / array.length);
    }

    /**
     * Calculates the average of a long array.
     * @param array the array of long values to average
     * @return the average as a long (decimal portion is truncated)
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static long average(long[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Cannot average an empty array");
        }
        long sum = 0;
        for (long value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    /**
     * Calculates the average of a double array.
     * @param array the array of double values to average
     * @return the average as a double
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static double average(double[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Cannot average an empty array");
        }
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    // Overloaded print helpers, one per array type, reused instead of repeating loops
    private static void printResult(String label, short[] array, short avg) {
        System.out.println(label + " array: " + Arrays.toString(array) + " | Average: " + avg);
    }

    private static void printResult(String label, int[] array, int avg) {
        System.out.println(label + " array: " + Arrays.toString(array) + " | Average: " + avg);
    }

    private static void printResult(String label, long[] array, long avg) {
        System.out.println(label + " array: " + Arrays.toString(array) + " | Average: " + avg);
    }

    private static void printResult(String label, double[] array, double avg) {
        System.out.println(label + " array: " + Arrays.toString(array) + " | Average: " + avg);
    }

    /**
     * Test driver that invokes each overloaded average() method with
     * differently sized arrays and displays the results.
     */
    public static void main(String[] args) {
        short[] shortArray = { 20, 40, 60 };
        int[] intArray = { 150, 300, 450, 600 };
        long[] longArray = { 1000L, 3000L, 6000L, 9000L, 12000L };
        double[] doubleArray = { 1.2, 2.4, 3.6, 4.8, 6.0, 7.2};

        try {
            printResult("Short", shortArray, average(shortArray));
        } catch (IllegalArgumentException e) {
            System.out.println("Error averaging short array: " + e.getMessage());
        }

        try {
            printResult("Int", intArray, average(intArray));
        } catch (IllegalArgumentException e) {
            System.out.println("Error averaging int array: " + e.getMessage());
        }

        try {
            printResult("Long", longArray, average(longArray));
        } catch (IllegalArgumentException e) {
            System.out.println("Error averaging long array: " + e.getMessage());
        }

        try {
            printResult("Double", doubleArray, average(doubleArray));
        } catch (IllegalArgumentException e) {
            System.out.println("Error averaging double array: " + e.getMessage());
        }
    }
}