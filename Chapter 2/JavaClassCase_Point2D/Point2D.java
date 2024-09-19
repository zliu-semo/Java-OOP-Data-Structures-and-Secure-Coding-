/**
 * Define a Point class in 2D Cartesian coordinate system. The point is defined by its x and y coordinates.
 * @author ziping
 */
public class Point2D {
    private double x;   //x coordinate
    private double y;   //y coordinate

    /**
     * Constructor to create a Point2D object with specified x and y coordinates
     * @param x     point's x coordinate
     * @param y     point's y coordinate
     */
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * output a point in the format of [x = x_coordinate, y = y_coordinate]
     * @return      a String representation of the point
     */
    @Override
    public String toString(){
        return String.format("Point2D [x = %.1f, y = %.1f]", this.x, this.y);
    }

    /**
     * accessor for point's x coordinate
     * @return      a double value for the point's x coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * accessor for point's y coordinate
     * @return      a double value for the point's y coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * calculate the distance between two points
     * @param p     a Point2D object for another point
     * @return      the distance between the point itself and point p
     */
    public double distance(Point2D p) {
        double xTerm = Math.pow((this.x - p.getX()), 2);
        double yTerm = Math.pow((this.y - p.getY()), 2);
        return (Math.sqrt(xTerm + yTerm));
    }

    /**
     * calculate the midpoint between two points
     * @param p     a Point2D object for another point
     * @return      the midpoint between the point itself and point p
     */
    public Point2D midpoint(Point2D p) {
        double newX = (this.x + p.getX())/2;
        double newY = (this.y + p.getY())/2;
        return (new Point2D(newX, newY));
    }

    // Knowledge Check 5: dot product
    public double dotProduct(Point2D p) {
        return this.x * p.x + this.y * p.y;
    }

    // Knowledge Check 6: override equals here
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other instanceof Point2D) {
            Point2D o = (Point2D) other;
            return (this.x == o.getX() && this.y == o.getY());
        }
        return false;
    }
}
