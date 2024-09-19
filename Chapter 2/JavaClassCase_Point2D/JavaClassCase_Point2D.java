/**
 * Inspect method behaviors of the Point2D class using JavaFX Point2D class as well as reverse engineered Point2D class
 * @author ziping
 */
//import javafx.geometry.Point2D;

public class JavaClassCase_Point2D {
    public static void main(String[] args) {
        // examine constructor and toString() behavior
        Point2D p1 = new Point2D(1, 2);
        Point2D p2 = new Point2D(3, 5);
        System.out.println("p1 is " + p1.toString());
        System.out.println("p2 is " + p2.toString());

        // examine distance and midpoint behavior
        double dist = p1.distance(p2);
        System.out.printf("The distance between p1 and p2 is %.2f\n", dist);
        Point2D pMid = p1.midpoint(p2);
        System.out.println("The midpoint between p1 and p2 is " + pMid.toString());

        //Knowledge check 4 and 5
        System.out.println("The dot product of p1 and p2 is: " + p1.dotProduct(p2));
        System.out.println("Is p1 equals p2? " + p1.equals(p2));
    }
}