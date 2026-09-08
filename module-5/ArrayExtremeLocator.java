/**
 * Author: Justin Bradley
 * CSD402 - Module 5.2 Programming Assignment
 * Locates the row/column position of the largest and smallest element in a
 * two-dimensional array, for both int and double array types. Works with
 * symmetrical (uniform row length) and asymmetrical (jagged, unequal row
 * length) arrays, since each row's own length is checked rather than
 * assuming every row is the same size.
 */
import java.util.Arrays;

public class ArrayExtremeLocator {

    /**
     * Locates the largest value in a 2D double array.
     * @param arrayParam the 2D array to search
     * @return a two-element int array: {row, column} of the largest value
     * @throws IllegalArgumentException if the array is null or contains no elements
     */
    public static int[] locateLargest(double[][] arrayParam) {
        validateArray(arrayParam);
        int largestRow = -1;
        int largestCol = -1;
        double largestValue = Double.NEGATIVE_INFINITY;
        boolean found = false;

        for (int row = 0; row < arrayParam.length; row++) {
            for (int col = 0; col < arrayParam[row].length; col++) {
                if (!found || arrayParam[row][col] > largestValue) {
                    largestValue = arrayParam[row][col];
                    largestRow = row;
                    largestCol = col;
                    found = true;
                }
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Cannot search an array with no elements");
        }
        return new int[] {largestRow, largestCol};
    }

    /**
     * Locates the largest value in a 2D int array.
     * @param arrayParam the 2D array to search
     * @return a two-element int array: {row, column} of the largest value
     * @throws IllegalArgumentException if the array is null or contains no elements
     */
    public static int[] locateLargest(int[][] arrayParam) {
        validateArray(arrayParam);
        int largestRow = -1;
        int largestCol = -1;
        int largestValue = Integer.MIN_VALUE;
        boolean found = false;

        for (int row = 0; row < arrayParam.length; row++) {
            for (int col = 0; col < arrayParam[row].length; col++) {
                if (!found || arrayParam[row][col] > largestValue) {
                    largestValue = arrayParam[row][col];
                    largestRow = row;
                    largestCol = col;
                    found = true;
                }
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Cannot search an array with no elements");
        }
        return new int[] {largestRow, largestCol};
    }

    /**
     * Locates the smallest value in a 2D double array.
     * @param arrayParam the 2D array to search
     * @return a two-element int array: {row, column} of the smallest value
     * @throws IllegalArgumentException if the array is null or contains no elements
     */
    public static int[] locateSmallest(double[][] arrayParam) {
        validateArray(arrayParam);
        int smallestRow = -1;
        int smallestCol = -1;
        double smallestValue = Double.POSITIVE_INFINITY;
        boolean found = false;

        for (int row = 0; row < arrayParam.length; row++) {
            for (int col = 0; col < arrayParam[row].length; col++) {
                if (!found || arrayParam[row][col] < smallestValue) {
                    smallestValue = arrayParam[row][col];
                    smallestRow = row;
                    smallestCol = col;
                    found = true;
                }
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Cannot search an array with no elements");
        }
        return new int[] {smallestRow, smallestCol};
    }

    /**
     * Locates the smallest value in a 2D int array.
     * @param arrayParam the 2D array to search
     * @return a two-element int array: {row, column} of the smallest value
     * @throws IllegalArgumentException if the array is null or contains no elements
     */
    public static int[] locateSmallest(int[][] arrayParam) {
        validateArray(arrayParam);
        int smallestRow = -1;
        int smallestCol = -1;
        int smallestValue = Integer.MAX_VALUE;
        boolean found = false;

        for (int row = 0; row < arrayParam.length; row++) {
            for (int col = 0; col < arrayParam[row].length; col++) {
                if (!found || arrayParam[row][col] < smallestValue) {
                    smallestValue = arrayParam[row][col];
                    smallestRow = row;
                    smallestCol = col;
                    found = true;
                }
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Cannot search an array with no elements");
        }
        return new int[] {smallestRow, smallestCol};
    }

    /**
     * Shared null/empty check for both int and double 2D arrays, run before
     * any locate method starts iterating rows.
     * @param arrayParam the array to validate
     * @throws IllegalArgumentException if the array is null or has no rows
     */
    private static void validateArray(Object[] arrayParam) {
        if (arrayParam == null || arrayParam.length == 0) {
            throw new IllegalArgumentException("Cannot search a null or empty array");
        }
    }

    public static void main(String[] args) {
        // Symmetrical (every row the same length) int array
        int[][] intSymmetrical = {
            {5, 12, 9},
            {30, 1, 18},
            {7, 22, 14}
        };

        // Asymmetrical (jagged, unequal row lengths) int array
        int[][] intAsymmetrical = {
            {4, 17},
            {25, 3, 11, 40},
            {6, 9, 2}
        };

        // Symmetrical double array
        double[][] doubleSymmetrical = {
            {3.5, 8.2, 6.1},
            {9.9, 2.4, 7.7},
            {5.6, 1.3, 4.8}
        };

        // Asymmetrical double array
        double[][] doubleAsymmetrical = {
            {2.2, 6.6},
            {9.1, 3.3, 8.8, 0.5},
            {4.4, 7.1, 1.9}
        };

        printExtremes("Int Symmetrical", intSymmetrical);
        printExtremes("Int Asymmetrical", intAsymmetrical);
        printExtremes("Double Symmetrical", doubleSymmetrical);
        printExtremes("Double Asymmetrical", doubleAsymmetrical);
    }

    /**
     * Prints an int[][] array plus the location and value of its largest
     * and smallest elements.
     */
    private static void printExtremes(String label, int[][] array) {
        int[] largestLoc = locateLargest(array);
        int[] smallestLoc = locateSmallest(array);

        System.out.println(label + ":");
        for (int[] row : array) {
            System.out.println("  " + Arrays.toString(row));
        }
        System.out.println("  Largest:  row " + largestLoc[0] + ", col " + largestLoc[1]
            + " -> " + array[largestLoc[0]][largestLoc[1]]);
        System.out.println("  Smallest: row " + smallestLoc[0] + ", col " + smallestLoc[1]
            + " -> " + array[smallestLoc[0]][smallestLoc[1]]);
        System.out.println();
    }

    /**
     * Prints a double[][] array plus the location and value of its largest
     * and smallest elements.
     */
    private static void printExtremes(String label, double[][] array) {
        int[] largestLoc = locateLargest(array);
        int[] smallestLoc = locateSmallest(array);

        System.out.println(label + ":");
        for (double[] row : array) {
            System.out.println("  " + Arrays.toString(row));
        }
        System.out.println("  Largest:  row " + largestLoc[0] + ", col " + largestLoc[1]
            + " -> " + array[largestLoc[0]][largestLoc[1]]);
        System.out.println("  Smallest: row " + smallestLoc[0] + ", col " + smallestLoc[1]
            + " -> " + array[smallestLoc[0]][smallestLoc[1]]);
        System.out.println();
    }
}