/**
 * Author: Justin Bradley
 * Date: September 6, 2026
 * Course: CSD 402
 * Professor Josh Guardino
 * CSD402 - Module 6.2 Programming Assignment
 *
 * Models an electric fan with a speed, an on/off state, a blade radius,
 * and a color. Speed is restricted to one of four named levels (STOPPED,
 * SLOW, MEDIUM, FAST) instead of an arbitrary number, and invalid values
 * passed to any setter are rejected with a clear error message rather
 * than being silently accepted.
 */
public class Fan {

    // Named speed levels a Fan can be set to
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed;      // current speed level: one of the four constants above
    private boolean on;     // whether the fan is powered on
    private double radius;  // blade radius, in inches
    private String color;   // fan color

    /**
     * No-argument constructor. Builds a Fan with the default state: stopped,
     * off, a 6-inch radius, and white in color.
     */
    public Fan() {
        speed = STOPPED;
        on = false;
        radius = 6;
        color = "white";
    }

    /**
     * Constructs a Fan with the given speed, power state, radius, and color.
     * Reuses the setters below so the same validation rules apply no matter
     * which constructor is used.
     *
     * @param speed  initial speed level; must be STOPPED, SLOW, MEDIUM, or FAST
     * @param on     initial power state
     * @param radius initial blade radius; must be greater than zero
     * @param color  initial color; cannot be null or blank
     */
    public Fan(int speed, boolean on, double radius, String color) {
        setSpeed(speed);
        this.on = on;
        setRadius(radius);
        setColor(color);
    }

    /**
     * Returns the fan's current speed level.
     * @return the speed, one of STOPPED, SLOW, MEDIUM, or FAST
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the fan's speed level.
     * @param speed the new speed; must be STOPPED, SLOW, MEDIUM, or FAST
     * @throws IllegalArgumentException if speed is not one of the four allowed levels
     */
    public void setSpeed(int speed) {
        if (speed != STOPPED && speed != SLOW && speed != MEDIUM && speed != FAST) {
            throw new IllegalArgumentException(
                "Speed must be STOPPED, SLOW, MEDIUM, or FAST (0-3); received " + speed + ".");
        }
        this.speed = speed;
    }

    /**
     * Returns whether the fan is currently on.
     * @return true if the fan is on, false if it is off
     */
    public boolean isOn() {
        return on;
    }

    /**
     * Turns the fan on or off.
     * @param on true to turn the fan on, false to turn it off
     */
    public void setOn(boolean on) {
        this.on = on;
    }

    /**
     * Returns the fan's blade radius, in inches.
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the fan's blade radius.
     * @param radius the new radius, in inches; must be greater than zero
     * @throws IllegalArgumentException if radius is not positive
     */
    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(
                "Radius must be greater than zero; received " + radius + ".");
        }
        this.radius = radius;
    }

    /**
     * Returns the fan's color.
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the fan's color.
     * @param color the new color; cannot be null or blank
     * @throws IllegalArgumentException if color is null or blank
     */
    public void setColor(String color) {
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Color cannot be null or blank.");
        }
        this.color = color;
    }

    /**
     * Builds a human-readable description of the fan's current state,
     * showing the speed as a word (Stopped/Slow/Medium/Fast) rather than
     * its underlying numeric constant.
     *
     * @return a description of the fan's state
     */
    @Override
    public String toString() {
        String speedLabel;
        switch (speed) {
            case SLOW:
                speedLabel = "Slow";
                break;
            case MEDIUM:
                speedLabel = "Medium";
                break;
            case FAST:
                speedLabel = "Fast";
                break;
            default:
                speedLabel = "Stopped";
                break;
        }

        return "Fan{power=" + (on ? "On" : "Off")
            + ", speed=" + speedLabel
            + ", radius=" + radius + " in"
            + ", color=" + color + "}";
    }

    /**
     * Test driver: builds one Fan with the no-argument constructor and one
     * with the argument constructor, exercises every getter/setter, and
     * demonstrates the validation each setter performs against bad input.
     */
    public static void main(String[] args) {
        System.out.println("--- Default-constructor Fan ---");
        Fan defaultFan = new Fan();
        System.out.println(defaultFan);

        System.out.println();
        System.out.println("--- Argument-constructor Fan ---");
        Fan customFan = new Fan(Fan.FAST, true, 10.5, "black");
        System.out.println(customFan);

        System.out.println();
        System.out.println("--- Exercising setters/getters on defaultFan ---");
        defaultFan.setOn(true);
        defaultFan.setSpeed(Fan.MEDIUM);
        defaultFan.setRadius(8);
        defaultFan.setColor("silver");
        System.out.println("On? " + defaultFan.isOn());
        System.out.println("Speed: " + defaultFan.getSpeed());
        System.out.println("Radius: " + defaultFan.getRadius());
        System.out.println("Color: " + defaultFan.getColor());
        System.out.println(defaultFan);

        System.out.println();
        System.out.println("--- Slowing customFan down one step at a time ---");
        customFan.setSpeed(Fan.SLOW);
        System.out.println(customFan);
        customFan.setOn(false);
        System.out.println(customFan);

        System.out.println();
        System.out.println("--- Demonstrating error handling for invalid input ---");
        try {
            customFan.setSpeed(9);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            customFan.setRadius(-2.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            customFan.setColor("");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Fan unaffected by the rejected input above: " + customFan);
    }
}
