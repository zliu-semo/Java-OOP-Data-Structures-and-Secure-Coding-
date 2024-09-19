/**
 *
 * @author ziping
 */
import java.util.ArrayList;
public class JavaClassEx4_arrayofobj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] colors = new String[5];
        colors[0] = "green";
        colors[1] = "blue";
        colors[2] = "pink";
        colors[3] = "gray";
        colors[4] = "magenta";

        /* create an array of Outfit objects:
           first, need to create an array of type of Outfit
           next, for each outfit array element, need to create an outfit object */
        Outfit[] arrOutfits = new Outfit[5];
        for(int i = 0; i < 5; i++)
            arrOutfits[i] = new Outfit(Outfit.TYPES[i], colors[i], i % 3);

        Person[] arrPersons = new Person[5];
        for(int i = 0; i < 5; i++)
            arrPersons[i] = new Person("student"+ i, 10+i, 100.0+i*10,
                    5.0+i*0.1, arrOutfits[i], "parents" + i);

        for(Person var: arrPersons)
            System.out.println(var);

        System.out.println("the average age is: " + calcAverageAge(arrPersons));

        // Call your Knowledge check 9 method here.
        System.out.println("the tallest person is: " + findTallestPerson(arrPersons));

        // Call your Knowledge check 10 method here.
        Outfit sm = findSmallestSizeOutfit(arrPersons);
        System.out.println("the smallest outfit is: " + sm);

        // Call your Knowledge check 11 method here.
        System.out.println("who wears the smallest outfit:\n" + findAllWithSmallestOutfit(arrPersons, sm));

    }

    public static double calcAverageAge(Person[] ppl){
        double avgAge = 0.0;
        for(Person var: ppl)
            avgAge += var.getAge();

        return avgAge / ppl.length;
    }

    // Knowledge check 9: write a method to find the tallest Person
    public static Person findTallestPerson(Person[] ppl){
        Person p = ppl[0];
        for(Person var: ppl)
            if(var.getHeight() > p.getHeight())
                p = var;
        return p;
    }

    // Knowledge check 10: write a method to find the smallest size of
    // Outfit worn
    public static Outfit findSmallestSizeOutfit(Person[] ppl){
        Person p = ppl[0];
        for(Person var: ppl)
            if(var.getOutfit().getSize() < p.getOutfit().getSize())
                p = var;

        return p.getOutfit();
    }

    // Knowledge check 11: write a method to find all the Person
    // objects who wear the smallest size of Outfit
    public static ArrayList<Person> findAllWithSmallestOutfit(Person[] ppl, Outfit s){
        ArrayList<Person> al = new ArrayList<Person>();
        for(Person var: ppl)
            if(var.getOutfit().equals(s))
                al.add(var);
       return al;
    }

}

