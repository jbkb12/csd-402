import java.util.ArrayList;
import java.util.List;

/**
 * Author: Justin Bradley
 * Date: September 16, 2026
 * Course: CSD 402
 * Professor Josh Guardino
 * CSD402 - Module 7.2 Programming Assignment
 *
 * Builds a collection of Fan objects and displays them without using
 * Fan's toString() method.
 */
public class UseFans {

    /**
     * Displays one Fan's state, read entirely through its getters.
     * @param fan the Fan to display; must not be null
     * @throws IllegalArgumentException if fan is null
     */
    public static void displayFan(Fan fan) {
        if (fan == null) {
            throw new IllegalArgumentException("Fan cannot be null.");
        }

        String speedLabel;
        switch (fan.getSpeed()) {
            case Fan.SLOW:   speedLabel = "Slow";    break;
            case Fan.MEDIUM: speedLabel = "Medium";  break;
            case Fan.FAST:   speedLabel = "Fast";    break;
            default:         speedLabel = "Stopped"; break;
        }
        System.out.println((fan.isOn() ? "On" : "Off") + ", " + speedLabel
            + ", " + fan.getRadius() + " in, " + fan.getColor());
    }

    /**
     * Displays every Fan in a collection by delegating to displayFan.
     * @param fans the collection of Fans to display
     */
    public static void displayFans(List<Fan> fans) {
        for (Fan fan : fans) {
            displayFan(fan);
        }
    }

    /**
     * Test driver: builds a small collection of Fans and displays them,
     * then demonstrates displayFan's error handling against a null Fan.
     */
    public static void main(String[] args) {
        List<Fan> fans = new ArrayList<>();
        fans.add(new Fan());
        fans.add(new Fan(Fan.FAST, true, 10.5, "black"));
        fans.add(new Fan(Fan.MEDIUM, true, 8, "silver"));

        displayFans(fans);

        System.out.println();
        System.out.println("--- Demonstrating error handling for a null Fan ---");
        try {
            displayFan(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
