/**
 * Client driver for JavaInterfaceEx2
 */
import res.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

public class JavaInterfaceEx2 {

    public static void main(String[] args) {
        // Invoke clone() method of House class.
        Date date1 = (new GregorianCalendar(2002, 6, 15)).getTime();
        House house1 = new House("100 Main St", 2360, date1);
        House clonedHouse = (House) house1.clone();
        
        System.out.println("house != clone: " + (house1 != clonedHouse));
        System.out.println("same dynamic class: " + 
                (house1.getClass() == clonedHouse.getClass()));
        System.out.println("structurally equal: " + house1.equals(clonedHouse));
        System.out.println("shared constructionDate reference: " + 
                house1.sharedConstructionDateReference(clonedHouse));
        
        /* Knowledge Check 1 for Pre-Defined Interfaces:
         * Check that the clone() method produces a deep copy.
         *  
         * Changing the values of fields of the clone/original should not change the
         * values of the fields of the other. 
         */

        System.out.println();
        
        // Invoke compareTo() method of House class.
        House[] houses = new House[3];
        houses[0] = house1;
        Date date2 = (new GregorianCalendar(2006, 1, 10)).getTime();
        House house2 = new House("201 Bakerfield Ln", 1890, date2);
        houses[1] = house2;
        Date date3 = (new GregorianCalendar(2000, 6, 15)).getTime();
        House house3 = new House("100 Main St", 2360, date3);
        houses[2] = house3;
        
        Arrays.sort(houses);
        System.out.println("Sorting House[]:");
        for (House h: houses) 
            System.out.println(h.toString());
        System.out.println();
        ArrayList<House> housesList = new ArrayList<House>();
        housesList.add(house1);
        housesList.add(house2);
        housesList.add(house3);
        Collections.sort(housesList);
        System.out.println("Sorting ArrayList<House>:");
        for (House h: houses) 
            System.out.println(h.toString());
        
        System.out.println();
        
        System.out.println("housesList contains house2? " + 
                housesList.contains(house2));
        System.out.println("housesList contains clone of house2? " + 
            housesList.contains((House) house2.clone()));
        System.out.println("size of housesList: " + housesList.size());
        House[] housesListAsArray = housesList.toArray(new House[housesList.size()]);
        System.out.println("houses array structurally equal to housesListAsArray? " + 
            Arrays.deepEquals(houses, housesListAsArray));
        
        /* Knowledge Check 4 for Pre-Defined Interfaces:
         * Create a clone of the housesList ArrayList. Check whether the elements are shallow
         * copies or deep copies. Is the ArrayList clone a shallow copy or deep copy?
         */
        
        /* Knowledge Check 5 for Pre-Defined Interfaces:
         * Create a new ArrayList object. Fill the ArrayList with all the elements of housesList
         * three times. What should the sorted ArrayList look like? Perform the sorting to
         * check your intuition.
         */
        
        System.out.println();
        
        // Invoke compare() method of a Comparator-type class.
        housesList.clear();
        housesList.addAll(Arrays.asList(houses));
        Date date4 = (new GregorianCalendar(2010, 0, 28)).getTime();
        House house4 = new House("1501 Lexington Ave", 3150, date4);
        Date date5 = (new GregorianCalendar(2000, 6, 15)).getTime();
        House house5 = new House("1501 Lexington Ave", 1890, date5);
        housesList.add(house4);
        housesList.add(house5);
        Collections.sort(housesList, new LivableAreaComparator());
        for (House h: housesList) 
            System.out.println(h.toString());
        
        /* Knowledge Checks 6 and 7 for Pre-Defined Interfaces:
         * Define a Comparator that allows us to compare House objects by their address 
         * and constructionDate fields. Your class should align with the equals() method.
         * Test the behavior of your Comparators here.
         */
    }
}
