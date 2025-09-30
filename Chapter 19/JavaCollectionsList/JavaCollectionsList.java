/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacollectionslist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Java Collections List example
 * @author ziping
 */
public class JavaCollectionsList {

    /**
     * Example on Java Collections List
     */
    public static void main(String[] args) {        
        List<Book> ar = new ArrayList<Book>(); 
        ar.add(new Book(111, "bbbb")); 
        ar.add(new Book(131, "aaaa")); 
        ar.add(new Book(121, "cccc")); 
        ar.add(new Book(151, "abc1"));
        ar.add(new Book(111, "abbb"));
        System.out.println("The ArrayList of books: " + ar);
  
        List<Book> ar2 = new LinkedList<Book>(); 
        ar2.add(new Book(211, "BBBBB")); 
        ar2.add(new Book(231, "AAAAA")); 
        ar2.add(new Book(221, "CCCCC")); 
        System.out.println("The LinkedList of books: " + ar2);

        ar.addAll(ar2);
        
        System.out.println("The ArrayList added books from LinkedList"); 
        System.out.println(ar.toString());
        
        System.out.println("The ArrayList contains the book abbb? " + ar.contains(new Book(111, "abbb")));
        System.out.println("ar contains ar2? " + ar.containsAll(ar2));
        System.out.println("ar is equal to ar2? " + ar.equals(ar2));
        
        Iterator<Book> itr = ar.iterator();
        System.out.println("iteration with iterator for ar:");
        while(itr.hasNext()){
            System.out.print(itr.next() + ", ");
        }
        System.out.println();
        
        System.out.println("Item abbb removed? " + ar.remove(new Book(111, "abbb")));
        System.out.println("The book CCCC removed? " + ar.removeIf(e->e.getID() == 221));
        
        Book[] bArray = ar.toArray(new Book[ar.size()]);
        System.out.println("The list of books converted to an array of books:");
        for(Book b: bArray)
            System.out.print(b + ", ");
        
        System.out.println("\nCalling collection's stream method to filter out starting with A:");
        ar.stream().filter(e -> !e.getName().startsWith("A"))
                   .forEach(e->System.out.print(e + ", "));

        System.out.println("The element at index 2: " + ar.get(2));
        System.out.println("The index of the book: " + ar.indexOf(new Book(211, "BBBBB")));
        System.out.println("Books sorted by name:");
        ar.sort((Book a, Book b) -> a.getName().compareTo(b.getName()));
        for(Book b: ar)
            System.out.print(b + ", ");
        
        List<Book> lsub = ar.subList(1, 3);
        System.out.println("\nThe sublist view of the book list:");
        System.out.println(lsub);
    }   
}
