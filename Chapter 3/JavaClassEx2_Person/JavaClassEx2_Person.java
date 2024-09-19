import java.util.Scanner;

/**
 *
 * @author ziping
 */
public class JavaClassEx2_Person {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Outfit clothes1 = new Outfit();
        System.out.println(clothes1);

        // create a person object p1 using default constructor
        Person p1 = new Person();
        System.out.println(p1);

        Outfit clothes2 = new Outfit(Outfit.TYPES[2], "blue", Outfit.LARGE);

        // create second person object p2 using explicit constructor
        Person p2 = new Person("Peter", 18, 150.5, 5.8, clothes2, "Parents");
        System.out.printf(p2.toString());
        // Knowledge check 7:
        // draw the stack memory and heap memory diagram after p1 and p2 are created

        System.out.println("\nNumber of persons = " + Person.getCount());
        // call class method talk( )
        Person.talk(p2, "I am Peter again");
        // Knowledge check 6:
        // what will be the number of persons if you add the remaining code
        // from the JavaClassEx1_Person example?

        System.out.println("check if getOutfit( ) returns shallow copy: " + (clothes2 == p2.getOutfit()));
        System.out.println("Check if getOutfit( ) has the same contents as the person's outfit: " + clothes2.equals(p2.getOutfit()));

        // Knowledge check 8:
        // write the code to test setOutfit( ), setPerson( ) and getClone( ) methods
        clothes1.setOutfit(Outfit.TYPES[1], "green", Outfit.MEDIUM);
        System.out.println("\n\nclothes1 changed to:");
        System.out.println(clothes1.toString());

        p1.setPerson("Peter Senior", 98, 155.9, 5.75, clothes1);
        System.out.println("\n\nPeter is now a grandparent:");
        System.out.println(p1);

        Person p1Clone = p1.getClone();
        System.out.println("\n\nPeter's clone:");
        System.out.println(p1Clone);

    }

}


