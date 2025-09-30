/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacollectionsapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * The polymorphic algorithms(static methods) from the Collections class
 * @author ziping
 */
public class JavaCollectionsApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Book> ar = new ArrayList<Book>(); 
        ar.add(new Book(111, "bbbb")); 
        ar.add(new Book(131, "aaaa")); 
        ar.add(new Book(121, "cccc")); 
        ar.add(new Book(151, "abc1"));
        ar.add(new Book(111, "abbb"));        
        ar.add(new Book(211, "BBBBB")); 
        ar.add(new Book(231, "AAAAA")); 
        ar.add(new Book(221, "CCCCC")); 
        System.out.println("The ArrayList of books: " + ar);  
        
        /*System.out.println("sort without comparable implemented");
        Collections.sort(ar); //compilation error, Book doesn't implement Comparable interface
        System.out.println(ar.toString());*/      
                
        Collections.sort(ar, new Comparator<Book>(){ 
            // Used for sorting in ascending order of id 
            public int compare(Book a, Book b){ 
                return a.getID() - b.getID(); 
            } 
        });  
        System.out.println("\nSorted by id"); 
        for(Book b: ar)
            System.out.println(b);
 
        Collections.sort(ar, (Book a, Book b) -> a.getName().compareTo(b.getName()));  
        System.out.println("\nSorted by name"); 
        for(Book b: ar)
            System.out.println(b);  
        
        ar.add(new Book(101, "cccc"));
        Collections.sort(ar, (Book customer1, Book customer2) -> {   
            // for comparison 
            int NameCompare = customer1.getName().compareTo(customer2.getName()); 
            int idCompare = new Integer(customer1.getID()).compareTo(customer2.getID()); 
  
            // 2-level comparison using if-else block 
            if (NameCompare == 0) { 
                return ((idCompare == 0) ? NameCompare : idCompare); 
            } else { 
                return NameCompare; 
            } 
        });
        System.out.println("\nSorted customerized"); 
        for(Book b: ar)
            System.out.println(b); 
        
        int loc = Collections.binarySearch(ar, new Book(111, "bbbb"), (Book customer1, Book customer2) -> {   
            // for comparison 
            int NameCompare = customer1.getName().compareTo(customer2.getName()); 
            int idCompare = new Integer(customer1.getID()).compareTo(customer2.getID()); 
  
            // 2-level comparison using if-else block 
            if (NameCompare == 0) { 
                return ((idCompare == 0) ? NameCompare : idCompare); 
            } else { 
                return NameCompare; 
            } 
        });
        System.out.println("The item is at: " + loc); 
        
        Collections.reverse(ar);
        System.out.println("\nAfter Reversing"); 
        for(Book b: ar)
            System.out.println(b);

        List<Book> ar3 = new ArrayList<Book>();         
        Collections.addAll(ar3, new Book(111, "bbbb"), 
                                new Book(131, "aaaa"), 
                                new Book(121, "cccc"), 
                                new Book(151, "abc1"),
                                new Book(111, "abbb"), 
                                new Book(101, "cccc"),
                                new Book(105, "java"),
                                new Book(199, "java8"),
                                new Book(599, "java11"));
        System.out.println("\nBook list ar3"); 
        for(Book b: ar3)
            System.out.println(b); 

        Collections.fill(ar3, new Book(999, "book999"));
        System.out.println("\nBook list ar3 updated"); 
        for(Book b: ar3)
            System.out.println(b); 

        Collections.copy(ar3, ar);
        System.out.println("\nBook list ar3 after copied"); 
        for(Book b: ar3)
            System.out.println(b); 
        
        Collections.swap(ar3, 0, 5);
        System.out.println("\nBook list ar3 after swapped"); 
        for(Book b: ar3)
            System.out.println(b);         
        
        Collections.shuffle(ar, new Random());
        System.out.println("\nAfter Shuffling"); 
        for(Book b: ar)
            System.out.println(b); 
        
        Book bVar = Collections.max(ar, (Book customer1, Book customer2) -> {   
            // for comparison 
            int NameCompare = customer1.getName().compareTo(customer2.getName()); 
            int idCompare = new Integer(customer1.getID()).compareTo(customer2.getID()); 
  
            // 2-level comparison using if-else block 
            if (NameCompare == 0) { 
                return ((idCompare == 0) ? NameCompare : idCompare); 
            } else { 
                return NameCompare; 
            } 
        });
        System.out.println("\nThe max: " + bVar);  
        
        Collections.rotate(ar, 2);
        System.out.println("\nAfter rotating two positions"); 
        for(Book b: ar)
            System.out.println(b); 
    }
}
