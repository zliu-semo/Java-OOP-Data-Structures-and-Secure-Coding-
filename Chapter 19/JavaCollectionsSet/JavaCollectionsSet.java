/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacollectionsset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Java Collections Set example
 * @author ziping
 */
public class JavaCollectionsSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // calling methods from Set interface
        Set<Book> st = new HashSet<>(); 
        st.add(new Book(111, "bbbb")); 
        st.add(new Book(131, "aaaa")); 
        st.add(new Book(121, "cccc")); 
        st.add(new Book(151, "abc1"));
        System.out.println("The Set of books: " + st);
  
        Set<Book> st2 = new TreeSet<>((Book a, Book b) -> a.getName().compareTo(b.getName())); 
        st2.add(new Book(211, "BBBBB")); 
        st2.add(new Book(231, "AAAAA")); 
        st2.add(new Book(221, "CCCCC")); 
        System.out.println("The second set of books: " + st2);

        st.addAll(st2);
        
        System.out.println("The set added books from the second set"); 
        System.out.println(st.toString());
        
        Book b0 = new Book(111, "abbb");
        st.add(b0);
        // calling methods from Collection interface
        // set contains() check is different from list, where list uses equals and set uses reference
        System.out.println("The Set contains the book abbb? " + st.contains(new Book(111, "abbb")));
        System.out.println("The set contains the book b0? " + st.contains(b0));
        System.out.println("st contains st2? " + st.containsAll(st2));
        System.out.println("st is equal to st2? " + st.equals(st2));
        
        Iterator<Book> itr = st.iterator();
        System.out.println("iteration with iterator for st:");
        while(itr.hasNext()){
            System.out.print(itr.next() + ", ");
        }
        System.out.println();
        
        // calling methods in SortedSet interface
        SortedSet<Book> sortedSt = new TreeSet<>((Book a, Book b) -> a.getName().compareTo(b.getName()));
        sortedSt.addAll(st);
        Book b1 = sortedSt.first();
        Book b2 = sortedSt.last();
        System.out.println("The first book in the sortedset: " + b1);
        System.out.println("The last book in the sortedset: " + b2);
        System.out.println("The sortedset of books:");
        System.out.println(sortedSt);
        
        SortedSet<Book> sortedStSub1 = sortedSt.headSet(b0);
        System.out.println("The first sub set of books:");
        System.out.println(sortedStSub1);
        
        SortedSet<Book> sortedStSub2 = sortedSt.tailSet(b0);
        System.out.println("The second sub set of books:");
        System.out.println(sortedStSub2);
        
        SortedSet<Book> sortedStSub3 = sortedSt.subSet(b0, b2);
        System.out.println("The third sub set of books:");
        System.out.println(sortedStSub3);
        
        // calling methods in NavigableSet interface
        NavigableSet<Book> nvSt = new TreeSet<>((Book a, Book b) -> a.getName().compareTo(b.getName()));
        nvSt.addAll(st);
        Book bc1 = nvSt.ceiling(new Book(132, "YYYY"));
        Book bc2 = nvSt.floor(new Book(132, "YYYY"));
        System.out.println("The ceiling book(up to book id132) in the navigableset: " + bc1);
        System.out.println("The floor book(up to book id132) in the navigableset: " + bc2);
        System.out.println("The navigableset of books:");
        System.out.println(nvSt);
        bc1 = nvSt.higher(new Book(131, "aaaa"));
        bc2 = nvSt.lower(new Book(131, "aaaa"));
        System.out.println("The higher book(up to book id131) in the navigableset: " + bc1);
        System.out.println("The lower book(up to book id131) in the navigableset: " + bc2);
        NavigableSet<Book> nvStRev = nvSt.descendingSet();
        System.out.println("The reverse view of the navigableSet: ");
        System.out.println(nvStRev);
        System.out.println("The first book in the navigableSet: " + nvSt.pollFirst());
        System.out.println("The last book in the navigableSet: " + nvSt.pollLast());
        nvSt.remove(b0);
        System.out.println("The navigableSet is now:");
        System.out.println(nvSt);
        System.out.println("The original Set is:");        
        System.out.println(st);
        
        // calling methods in Collection interface
        Book[] bArray = st.toArray(new Book[st.size()]);
        System.out.println("The list of books converted to an array of books:");
        for(Book b: bArray)
            System.out.print(b + ", ");
        
        System.out.println("\nCalling collection's stream method to filter out starting with A:");
        st.stream().filter(e -> !e.getName().startsWith("A"))
                   .forEach(e->System.out.print(e + ", "));
    }   
}
