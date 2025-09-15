/**
 * Package for user-defined classes and interfaces for JavaInterfaceEx2
 */
package res;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.Comparable;

/**
 * Example of implementing Cloneable and Comparable interfaces
 */
public class House implements Cloneable, Comparable<House> {
    private String address;
    private double livableArea;
    private Date constructionDate;
    
    private static SimpleDateFormat FORMAT = new SimpleDateFormat("MMM dd, yyyy");
    
    /**
     * Explicit-value constructor
     * @param address Street address
     * @param livableArea Total square footage of livable area
     * @param date When the house was built
     */
    public House(String address, double livableArea, Date date) {
        this.address = address;
        this.livableArea = livableArea;
        this.constructionDate = (Date) date.clone();
    }
    
    /* Accessors */
    public String getAddress() {
        return address;
    }
    
    public double getLivableArea() {
        return livableArea;
    }
    
    public Date getConstructionDate() {
        return (Date) constructionDate.clone();
    }
    
    /* Overriding toString() and equals() from Object */
    @Override
    public String toString() {
        return String.format("{\n  address: %s,\n"
                + "  total livable area: %.1f,\n"
                + "  built on: %s\n}", 
                address, livableArea, FORMAT.format(constructionDate));
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        
        if (o.getClass() == getClass()) {
            House other = (House) o;
            return (address.equals(other.address) &&
                    livableArea == other.livableArea &&
                    constructionDate.equals(other.constructionDate));
        }
        
        return false;
    }
    
    /* Helps us determine shallow/deep copy status of two Houses */
    public boolean sharedConstructionDateReference(House h) {
        return constructionDate == h.constructionDate;
    }
    
    /* Overriding clone() from Object and making it public visibility */
    @Override
    public Object clone() {
        // Version 1: shallow copy via Object's default clone() method.
        /*try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }*/
        // Version 2: deep copy implementation
        Date currDate = new Date();  // current date
        return new House(address, livableArea, currDate);
        
        /* Knowledge Check 2 for Pre-Defined Interfaces: 
         * Write a third version of clone() that invokes super.clone() and resets
         * the appropriate fields. Your method should return a deep copy. It should 
         * NOT throw any exceptions.
         */
    }
    
    /* Knowledge Check 1 for Pre-Defined Interfaces:
     * Check that the clone() method produces a deep copy. 
     * 
     * Changing the values of fields of the clone/original should not change the
     * values of the fields of the other. You may need to add some methods here.
     */
    
    @Override
    public int compareTo(House other) {
        if (this.equals(other))
            return 0;
        
        if (address.compareTo(other.address) < 0)
            return -1;
        else if (address.compareTo(other.address) > 0) 
            return 1;
        else {
            if (livableArea < other.livableArea) 
                return -1;
            else if (livableArea > other.livableArea)
                return 1;
            else {
                if (constructionDate.compareTo(other.constructionDate) < 0) 
                    return -1;
                else 
                    return 1;
            }
        }
    }
}
