package res;

import java.util.ArrayList;

public class Processor {
    private static final ArrayList<Movable> ELEMENTS = new ArrayList<Movable>();
    
    
    
    public static void addElement(String name, String verb) {
        ELEMENTS.add(new MovableClass(name, verb) {            
            @Override
            public String moveTo(String location) {
                String str;
                if (ELEMENTS.size() <= 3) 
                    str = String.format("%s is %s, %s, %s to %s", 
                            name, verb, verb, verb, location);
                else
                    str = String.format("%s is %s to %s", name, verb, location);
                System.out.println(str);
                return str;
            }
        });
        System.out.println("Added new Movable element.");
    }
    
    public static void wanderAll() {
        for (Movable element: ELEMENTS) 
            element.wander();
    }
    
    public static void moveAllTo(String location) {
        for (Movable element: ELEMENTS) 
            element.moveTo(location);
    }
    
    // Add code for Knowledge Check 9 (Nested Classes) here, if applicable.
    
    /*public static void removeElementsWithName(String name) {
        ArrayList<Movable> toRemove = new ArrayList<Movable>();
        for (Movable element: ELEMENTS) {
            if (element instanceof MovableClass) {
                MovableClass temp = (MovableClass) element;
                if (temp.getName().equals(name))
                    toRemove.add(element);
            }
        }
        ELEMENTS.removeAll(toRemove);
        System.out.println(String.format("Movables with name %s removed", name));
    }*/
    
    // Add code for Knowledge Check 10 (Nested Classes) here, if applicable.
    
    /*public static void addElement() {
        ELEMENTS.add(new Movable() { 
            @Override
            public String wander() {
                String str = "Wandering...";
                System.out.println(str);
                return str;
            }
            @Override
            public String moveTo(String location) {
                String str = String.format("Movable --> %s", location);
                System.out.println(str);
                return str;
            }
        });
        System.out.println("Added new default Movable element.");
    }*/
}
