package res;

import java.util.ArrayList;

public class Processor {
    private static final ArrayList<Movable> ELEMENTS = new ArrayList<Movable>();
    
    /*
     * Version 2: using a static nested class
     */
    /*public static class MovableClass implements Movable {
        private String name;
        private String verb;
        
        public MovableClass(String name, String verb) {
            this.name = name;
            this.verb = verb;
        }
            
        @Override
        public void move(String name, String verb) {
            System.out.println(String.format("%s is %s.", name, verb));
        }
    }*/
    
    public static void addElement(String name, String verb) {
        /*
         * Version 3: local class
         */
        /*class MovableClass implements Movable {
            private String name;
            private String verb;
            
            public MovableClass(String name, String verb) {
                this.name = name;
                this.verb = verb;
            }
            
            @Override
            public void move() {
                System.out.println(String.format("%s is %s.", name, verb));
            }
        }*/
        
        // Versions 1, 2, and 3: independent concrete class, static nested class,
        // and local class used the following line.
        // MovableClass tmp = new MovableClass(name, verb);
        
        /*
         * Version 4: instantiating an anonymous class as a variable declaration
         */
        /*Movable tmp = new Movable() {
            @Override
            public void move() {
                System.out.println(String.format("%s is %s.", name, verb));
            }
        };*/
        
        /*
         * Version 5: using a lambda expression to satisfy the functional interface
         */
        Movable tmp = () -> System.out.println(String.format("%s is %s.", name, verb));
        ELEMENTS.add(tmp);
    }
    
    public static void moveAll() {
        for (Movable element: ELEMENTS) {
            // Versions 1 and 2: independent concrete class and static nested class
            // if (element instanceof MovableClass) {
                // MovableClass tmp = (MovableClass) element;
                // Version 1: independent concrete class; needs accessors for fields
                // tmp.move(tmp.getName(), tmp.getVerb());
                
                // Version 2: static nested class; can directly access members of nested class
                // tmp.move(tmp.name, tmp.verb);
            // }
            
            // Versions 3, 4, and 5: local class, anonymous class, and lambda expression
            element.move();
        }
    }
    
    // Knowledge Check 11 code here.
    /*public static void addElement() {
        ELEMENTS.add(() -> System.out.println("Moving..."));
    }*/
}