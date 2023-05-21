import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task2 {
    private static final double GRAVITY = 10.0;

    private static final double DELTA = 0.001;
    public static void main(String[] args) {
        int reflections = 5;
        double deltaThreshold = 0.01;

        List<Point> reflectionPoints = new ArrayList<>();

        // Run the simulation
        Random random = new Random();
        for (int run = 1; run <= reflections; run++) {
            double x = random.nextDouble() * 2 - 1; // Random initial position inside the circle (-1 to 1)
            double y = Math.sqrt(1 - x * x); // Corresponding y-coordinate on the circle
            double px = random.nextDouble() * 5 + 5;
            double py = Math.sqrt(px * px - GRAVITY * y * 2); // Corresponding y-component of momentum

            for (int i = 0; i < run; i++) {
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

        boolean isReversible = true;
        int deviationIndex = -1;

        for (int run = 1; run <= reflections; run++) {
            int startIndex = (run - 1) * run / 2;
            int endIndex = startIndex + run;

            for (int i = startIndex; i < endIndex; i++) {
                int index = i + endIndex;
                Point point = reflectionPoints.get(index);

                point.setPx(-point.getPx());
                point.setPy(-point.getPy());

                point.setX(point.getX() + point.getPx());
                point.setY(point.getY() + point.getPy());

                double distance = Math.sqrt(Math.pow(reflectionPoints.get(i).getX() - point.getX(), 2) +
                        Math.pow(reflectionPoints.get(i).getY() - point.getY(), 2));

                if (distance > deltaThreshold) {
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
            System.out.println("The paths deviate more than the threshold after " + (deviationIndex + 1) + " reflections.");
        }

    }

}