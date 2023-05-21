import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    private static final double EPSILON = 1e-10;
    public static void main(String[] args) {
        int reflections = 5; // Number of reflections

        // List to store reflection points
        List<Point> reflectionPoints = new ArrayList<>();

        Random random = new Random();
        for (int run = 1; run <= reflections; run++) {
            double x = random.nextDouble() * 2 - 1; // Random initial position inside the circle (-1 to 1)
            double y = Math.sqrt(1 - x * x); // Corresponding y-coordinate on the circle
            double px = random.nextDouble() * 2 - 1; // Random initial momentum (-1 to 1)
            double py = Math.sqrt(1 - px * px); // Corresponding y-component of momentum

            for (int i = 0; i < run; i++) {
                // Calculate next position using current momentum
                double nextX = x + px;
                double nextY = y + py;

                reflectionPoints.add(new Point(x, y));

                double angleOfIncidence = Math.atan2(py, px);

                double angleOfReflection = Math.atan2(nextY, nextX);

                double newX = (nextY * nextY - nextX * nextX) * px - 2 * nextX * nextY * py;
                double newY = -2 * nextX * nextY * px + (nextX * nextX - nextY * nextY) * py;

                x = nextX;
                y = nextY;
                px = newX;
                py = newY;
            }
        }

        // Test reversibility of motion
        boolean isReversible = true;
        int deviationIndex = -1;

        for (int run = 1; run <= reflections; run++) {
            int startIndex = (run - 1) * run / 2;
            int endIndex = startIndex + run;

            // Reverse the momentum for the given number of reflections
            for (int i = startIndex; i < endIndex; i++) {
                int index = i + endIndex;
                Point point = reflectionPoints.get(index);

                point.setPx(-point.getPx());
                point.setPy(-point.getPy());

                point.x += point.getPx();
                point.y += point.getPy();

                // Calculate the distance between the original and reversed path
                double distance = Math.sqrt(Math.pow(reflectionPoints.get(i).x - point.x, 2) +
                        Math.pow(reflectionPoints.get(i).y - point.y, 2));

                // Check if the paths deviate more than the threshold
                if (distance > EPSILON) {
                    isReversible = false;
                    deviationIndex = index;
                    break;
                }
            }
        }

        System.out.println("Reflection Points:");
        for (Point point : reflectionPoints) {
            System.out.println(point);
        }

        if (isReversible) {
            System.out.println("The motion is reversible.");
        } else {
            System.out.println("The motion is not reversible. Deviation occurred at reflection index " + deviationIndex + ".");
        }
    }
}