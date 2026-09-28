import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/*
 * Justin Bradley
 * September 27, 2026
 * CSD 402
 * Professor Josh Guardino
 * Module 9.2 Programming Assignment (Program 2)
 *
 * BradleyRandomDataFile
 * Creates a file named data.file if it does not already exist, then writes
 * 10 randomly generated integers to it separated by spaces. If the file
 * already exists, the new numbers are appended to the existing data. The
 * file is closed, reopened for reading, and its full contents are displayed.
 */
public class BradleyRandomDataFile {

    /** Name of the data file used by the program. */
    private static final String FILE_NAME = "data.file";

    /** How many random numbers are written on each run. */
    private static final int NUMBER_COUNT = 10;

    /** Upper bound (exclusive) for each random number. */
    private static final int MAX_VALUE = 100;

    /**
     * Writes NUMBER_COUNT random integers to the given file. The FileWriter
     * is opened in append mode, which creates the file when it is missing
     * and adds to the end of it when it already exists.
     *
     * @param file the file to write to
     * @throws IOException if the file cannot be created or written
     */
    public static void writeRandomNumbers(File file) throws IOException {
        Random random = new Random();

        // try-with-resources closes the writer automatically when done.
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            for (int i = 0; i < NUMBER_COUNT; i++) {
                writer.print(random.nextInt(MAX_VALUE) + " ");
            }
        }
    }

    /**
     * Reopens the file and prints every integer stored in it.
     *
     * @param file the file to read from
     * @throws FileNotFoundException if the file cannot be opened
     */
    public static void displayFile(File file) throws FileNotFoundException {
        int count = 0;

        try (Scanner reader = new Scanner(file)) {
            // Read one integer at a time until the end of the file.
            while (reader.hasNextInt()) {
                System.out.print(reader.nextInt() + " ");
                count++;
            }
        }
        System.out.println("\nTotal numbers stored in " + file.getName() + ": " + count);
    }

    /**
     * Reports whether the file is new or existing, writes the random numbers,
     * then reads the file back and displays it.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        File dataFile = new File(FILE_NAME);

        // Let the user know whether this run creates or appends.
        if (dataFile.exists()) {
            System.out.println(FILE_NAME + " already exists. Appending "
                    + NUMBER_COUNT + " new random numbers.");
        } else {
            System.out.println(FILE_NAME + " does not exist. Creating it and writing "
                    + NUMBER_COUNT + " random numbers.");
        }

        try {
            writeRandomNumbers(dataFile);

            System.out.println("\nContents of " + FILE_NAME + ":");
            displayFile(dataFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + FILE_NAME + " could not be opened for reading. "
                    + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: could not write to " + FILE_NAME + ". "
                    + e.getMessage());
        }
    }
}
