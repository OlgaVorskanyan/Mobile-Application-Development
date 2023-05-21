public class Point {

    double x;
    double y;
    private double Px;
    private double Py;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getPy() {
        return Py;
    }

    public double getPx() {
        return Px;
    }

    public void setPy(double py) {
        Py = py;
    }

    public void setPx(double px) {
        Px = px;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void scale(double factor) {
        x *= factor;
        y *= factor;
    }

    public void normalize() {
        double magnitude = Math.sqrt(x * x + y * y);
        if (magnitude > 0) {
            x /= magnitude;
            y /= magnitude;
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
