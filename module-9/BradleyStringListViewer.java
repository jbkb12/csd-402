import java.util.ArrayList;
import java.util.Scanner;

/*
 * Justin Bradley
 * September 27, 2026
 * CSD 402
 * Professor Josh Guardino
 * Module 9.2 Programming Assignment (Program 1)
 *
 * BradleyStringListViewer
 * Fills an ArrayList with 10 Strings, prints the collection with a for-each
 * loop, then asks the user which element they would like to see again. The
 * user's String input is converted to an index using autoboxing and
 * auto-unboxing, and the lookup is wrapped in a try/catch so an invalid
 * index displays an "Out of Bounds" exception message.
 */
public class BradleyStringListViewer {

    /**
     * Builds the list of Strings used by the program.
     *
     * @return an ArrayList holding 10 aircraft names
     */
    public static ArrayList<String> buildList() {
        ArrayList<String> aircraft = new ArrayList<>();
        aircraft.add("MQ-9 Reaper");
        aircraft.add("MQ-1 Predator");
        aircraft.add("RQ-4 Global Hawk");
        aircraft.add("C-17 Globemaster");
        aircraft.add("KC-135 Stratotanker");
        aircraft.add("F-16 Fighting Falcon");
        aircraft.add("F-35 Lightning II");
        aircraft.add("B-52 Stratofortress");
        aircraft.add("A-10 Thunderbolt II");
        aircraft.add("C-130 Hercules");
        return aircraft;
    }

    /**
     * Prints every element in the list along with its index.
     * A for-each loop is used as required by the assignment, so a separate
     * counter tracks the index being printed.
     *
     * @param list the ArrayList of Strings to display
     */
    public static void printList(ArrayList<String> list) {
        int index = 0;
        for (String item : list) {
            System.out.println("  [" + index + "] " + item);
            index++;
        }
    }

    /**
     * Displays the list, prompts the user for an element to view again, and
     * attempts to print that element inside a try/catch block.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> aircraft = buildList();

        System.out.println("ArrayList contents (" + aircraft.size() + " elements):");
        printList(aircraft);

        // Read the choice as a String so the conversion to a number is
        // handled explicitly below.
        System.out.print("\nWhich element would you like to see again? Enter an index (0-"
                + (aircraft.size() - 1) + "): ");
        String userInput = input.nextLine().trim();

        try {
            // Autoboxing: Integer.parseInt returns a primitive int, which Java
            // automatically wraps in an Integer object on assignment.
            Integer requestedIndex = Integer.parseInt(userInput);

            // Auto-unboxing: get() expects a primitive int, so Java
            // automatically unwraps the Integer object here.
            String selected = aircraft.get(requestedIndex);

            System.out.println("Element " + requestedIndex + " is: " + selected);
        } catch (IndexOutOfBoundsException e) {
            // The number was valid, but it does not match a position in the list.
            System.out.println("An Exception has been thrown: Out of Bounds");
            System.out.println("\"" + userInput + "\" is not a valid index for a list of "
                    + aircraft.size() + " elements.");
        } catch (NumberFormatException e) {
            // The input could not be converted to a whole number at all.
            System.out.println("An Exception has been thrown: \"" + userInput
                    + "\" is not a whole number, so no element could be displayed.");
        } finally {
            input.close();
        }
    }
}
