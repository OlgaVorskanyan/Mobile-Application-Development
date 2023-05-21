import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task3 {
    private static final double EPSILON = 1e-6;
    private static final int M = 10;

    public static void main(String[] args) {
        double L = 2.0; // Length of the straight line segments
        double xcLeft = 0.0; // x-coordinate of the center of the left semicircle
        double xcRight = L; // x-coordinate of the center of the right semicircle
        int n = 10; // Number of reflections
        double[] xOverLValues = generateRandomSequence(n);

        List<Point> reflectionPoints = simulateStadiumBilliard(L, xcLeft, xcRight, n, xOverLValues);
        testUniformity(xOverLValues);

        System.out.println("Reflection Points:");
        for (Point point : reflectionPoints) {
            System.out.println(point);
        }
    }

    private static List<Point> simulateStadiumBilliard(double L, double xcLeft, double xcRight, int n,
                                                       double[] xOverLValues) {
        List<Point> reflectionPoints = new ArrayList<>();
        Random random = new Random();

        Point initialPoint = generatePointInsideCircle();
        Point initialMomentum = generatePointInsideCircleWithMagnitude(1.0);

        Point point = initialPoint;
        Point momentum = initialMomentum;

        for (int i = 0; i < n; i++) {
            Point nextPoint;
            if (point.getX() < L / 2) {
                nextPoint = calculateIntersectionWithLineSegment(point, momentum, 0, L / 2, 0, 1);
                reflectionPoints.add(nextPoint);
                momentum = new Point(momentum.getX(), -momentum.getY());
            } else {
                double xc = (i % 2 == 0) ? xcLeft : xcRight;
                nextPoint = calculateIntersectionWithSemicircle(point, momentum, xc, 0, 1);
                reflectionPoints.add(nextPoint);
                momentum = calculateNewMomentumSemicircle(point, momentum, xc, 0);
            }

            point = nextPoint;
        }

        return reflectionPoints;
    }

    private static void testUniformity(double[] xOverLValues) {
        int[] binCounts = new int[M];
        for (double value : xOverLValues) {
            int binIndex = (int) (value * M);
            binCounts[binIndex]++;
        }

        int minCount = Integer.MAX_VALUE;
        int maxCount = Integer.MIN_VALUE;
        double mean = 0.0;
        double variance = 0.0;

        for (int count : binCounts) {
            minCount = Math.min(minCount, count);
            maxCount = Math.max(maxCount, count);
            mean += count;
            variance += Math.pow(count, 2);
        }

        mean /= M;
        variance = (variance / M) - Math.pow(mean, 2);

        System.out.println("Bin Counts:");
        for (int i = 0; i < M; i++) {
            System.out.printf("Bin %d: %d%n", i, binCounts[i]);
        }

        System.out.println("Min Count: " + minCount);
        System.out.println("Max Count: " + maxCount);
        System.out.println("Mean: " + mean);
        System.out.println("Variance: " + variance);
    }

    private static Point calculateIntersectionWithSemicircle(Point point, Point momentum, double xc, double yc, double radius) {
        double x = point.getX();
        double y = point.getY();
        double px = momentum.getX();
        double py = momentum.getY();

        double a = Math.pow(y - yc, 2) - Math.pow(x - xc, 2);
        double b = -2 * (x - xc) * y;
        double c = Math.pow(x - xc, 2) - Math.pow(radius, 2);

        double discriminant = Math.pow(b, 2) - 4 * a * c;

        double ix1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double ix2 = (-b - Math.sqrt(discriminant)) / (2 * a);

        double iy1 = Math.sqrt(radius * radius - (ix1 - xc) * (ix1 - xc));
        double iy2 = Math.sqrt(radius * radius - (ix2 - xc) * (ix2 - xc));

        double intersectionX = (x < xc) ? Math.max(ix1, ix2) : Math.min(ix1, ix2);
        double intersectionY = (x < xc) ? Math.max(iy1, iy2) : Math.min(iy1, iy2);

        return new Point(intersectionX, intersectionY);
    }

    private static Point calculateNewMomentumSemicircle(Point point, Point momentum, double xc, double yc) {
        double x = point.getX();
        double y = point.getY();
        double px = momentum.getX();
        double py = momentum.getY();

        double ppx = (Math.pow(y, 2) - Math.pow(x - xc, 2)) * px - 2 * (x - xc) * y * py;
        double ppy = -2 * (x - xc) * y * px + (Math.pow(x - xc, 2) - Math.pow(y, 2)) * py;

        return new Point(ppx, ppy);
    }

    private static Point calculateIntersectionWithLineSegment(Point point, Point momentum, double x1, double x2,
                                                              double y1, double y2) {
        double x = point.getX();
        double y = point.getY();
        double px = momentum.getX();
        double py = momentum.getY();

        double t = ((x2 - x1) * (y - y1) - (y2 - y1) * (x - x1)) / ((y2 - y1) * py - (x2 - x1) * px);

        double intersectionX = x + t * px;
        double intersectionY = y + t * py;

        return new Point(intersectionX, intersectionY);
    }

    private static Point generatePointInsideCircle() {
        Random random = new Random();
        double angle = random.nextDouble() * 2 * Math.PI;
        double radius = Math.sqrt(random.nextDouble());

        double x = radius * Math.cos(angle);
        double y = radius * Math.sin(angle);

        return new Point(x, y);
    }

    private static Point generatePointInsideCircleWithMagnitude(double magnitude) {
        Point point = generatePointInsideCircle();
        point.normalize();
        point.scale(magnitude);
        return point;
    }

    private static double[] generateRandomSequence(int n) {
        double[] sequence = new double[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            sequence[i] = random.nextDouble();
        }

        return sequence;
    }
}

