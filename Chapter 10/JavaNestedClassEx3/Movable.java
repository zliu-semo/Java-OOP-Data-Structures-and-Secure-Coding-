package res;

/**
 * Functional interface
 */
public interface Movable {
    // Versions 1 and 2: independent concrete class and static nested class
    // public void move(String name, String verb);
    
    // Versions 3, 4, and 5: local class, anonymous class, and lambda expression
    public void move();
}