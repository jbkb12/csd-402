import java.util.ArrayList;
import java.util.Scanner;

/*
 * Justin Bradley
 * September 20, 2026
 * CSD 402
 * Professor Josh Guardino
 * Module 8.2 Programming Assignment
 *
 * BradleyArrayListTest
 * Collects integers from the user into an ArrayList until 0 is entered,
 * then finds and displays the largest value stored in the list.
 */
public class BradleyArrayListTest {

    /**
     * Finds the largest Integer stored in the given ArrayList.
     *
     * @param list the ArrayList of Integer values to search
     * @return the largest value in the list, or 0 if the list is empty
     */
    public static Integer max(ArrayList list) {
        // Per the spec, an empty list returns 0.
        if (list.isEmpty()) {
            return 0;
        }

        // Start by assuming the first element is the largest, then
        // compare it against every remaining element.
        Integer largest = (Integer) list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Integer current = (Integer) list.get(i);
            if (current > largest) {
                largest = current;
            }
        }
        return largest;
    }

    /**
     * Prompts the user for integers, stores them in an ArrayList until a 0
     * is entered, then reports the largest value. Also tests the empty case.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers one at a time. Enter 0 to finish.");

        // Read entries until the user types 0. The 0 is added to the list too.
        int entry;
        do {
            System.out.print("Enter an integer: ");
            entry = input.nextInt();
            numbers.add(entry);
        } while (entry != 0);

        // Pass the populated list to max and display the result.
        Integer largest = max(numbers);
        System.out.println("The largest value entered is: " + largest);

        // Additional test: confirm an empty list returns 0.
        ArrayList<Integer> emptyList = new ArrayList<>();
        System.out.println("Empty list test (expected 0): " + max(emptyList));

        input.close();
    }
}