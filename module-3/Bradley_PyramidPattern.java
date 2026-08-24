/**
 * Author: Justin Bradley
 * Date: August 23, 2026
 * Course: CSD 402
 * Professor Josh Guardino
 * Assignment: Module 3.2 - Nested Loop Pyramid Pattern
 *
 * Prints a pyramid pattern where each row's numbers start at 1, double
 * up to a middle value of 2^row, then mirror back down to 1. Each line
 * ends with a trailing @ symbol.
 */
public class PyramidPattern {

    // Number of rows in the pyramid (rows are numbered 0 through TOTAL_ROWS - 1)
    private static final int TOTAL_ROWS = 7;

    public static void main(String[] args) {
        for (int row = 0; row < TOTAL_ROWS; row++) {
            printRow(row);
        }
    }

    /**
     * Prints one row of the pyramid: leading spaces, the ascending and
     * descending number sequence, trailing spaces, then the @ symbol.
     *
     * @param row the current row index, 0 through TOTAL_ROWS - 1
     */
    private static void printRow(int row) {
        int middle = (int) Math.pow(2, row);

        int widestRowCount = 2 * (TOTAL_ROWS - 1) + 1;
        int thisRowCount = 2 * row + 1;
        int paddingSpaces = widestRowCount - thisRowCount;

        int thisRowWidth = getRowWidth(row);
        int targetWidth = getRowWidth(TOTAL_ROWS - 1) + 1;
        int trailingSpaces = targetWidth - paddingSpaces - thisRowWidth;

        printSpaces(paddingSpaces);

        boolean first = true;

        // Ascending half: 1, 2, 4, ... up to middle
        for (int value = 1; value <= middle; value = value * 2) {
            if (!first) {
                System.out.print(" ");
            }
            System.out.print(value);
            first = false;
        }

        // Descending half: back down from just past middle to 1
        for (int value = middle / 2; value >= 1; value = value / 2) {
            System.out.print(" ");
            System.out.print(value);
        }

        printSpaces(trailingSpaces);
        System.out.println("@");
    }

    /**
     * Calculates the number of characters used by the number sequence
     * in a row, including spaces between numbers.
     *
     * @param row the current row index
     * @return the character width of the number sequence
     */
    private static int getRowWidth(int row) {
        int middle = (int) Math.pow(2, row);
        int width = 0;
        int numberCount = 0;

        for (int value = 1; value <= middle; value = value * 2) {
            width += String.valueOf(value).length();
            numberCount++;
        }

        for (int value = middle / 2; value >= 1; value = value / 2) {
            width += String.valueOf(value).length();
            numberCount++;
        }

        // One space between each number, but none after the last number
        width += numberCount - 1;

        return width;
    }

    /**
     * Prints the given number of single space characters, with no newline.
     *
     * @param count how many spaces to print
     */
    private static void printSpaces(int count) {
        for (int space = 0; space < count; space++) {
            System.out.print(" ");
        }
    }
}