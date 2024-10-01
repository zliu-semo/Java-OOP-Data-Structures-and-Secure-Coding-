package res;

/**
 * Abstract class that implements Movable.
 */
public abstract class MovableClass implements Movable {
    private String name;
    private String wanderingVerb;
    
    public MovableClass(String name, String verb) {
        this.name = name;
        this.wanderingVerb = verb;
    }

    @Override
    public String wander() {
        String str = String.format("%s is %s.", name, wanderingVerb);
        System.out.println(str);
        return str;
    }
    
    // Add code for Knowledge Check 9 (Nested Classes) here, if applicable.
    /*public String getName() {
        return name;
    }*/
    
    // Add code for Knowledge Check 10 (Nested Classes) here, if applicable.
}