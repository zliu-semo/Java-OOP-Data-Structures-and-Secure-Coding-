/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacollectionpriorityqueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author ziping
 */
public class JavaCollectionPriorityQueue {

    /**
     * Demonstrate PriorityQueue usage
     */
    public static void main(String[] args) {
        PriorityQueue<Book> bookq = new PriorityQueue<>(Comparator.comparing(Book::getID).
                thenComparing(Book::getName)); 
        bookq.add(new Book(151, "abc1"));
        bookq.add(new Book(111, "bbbb")); 
        bookq.add(new Book(131, "aaaa")); 
        bookq.add(new Book(121, "cccc")); 
        System.out.println("The priority queue of books: " + bookq);
  
        PriorityQueue<Book> bookq2 = new PriorityQueue<>(); 
        bookq2.offer(new Book(231, "AAAAA"));         
        bookq2.offer(new Book(221, "CCCCC"));         
        bookq2.offer(new Book(211, "BBBBB")); 
        System.out.println("The second priority queue of books: " + bookq2);

        bookq.addAll(bookq2);
        
        System.out.println("The priority queue added books from the second priority queue"); 
        System.out.println(bookq.toString());
        
        Book b0 = new Book(111, "abbb");
        bookq.add(b0);
        System.out.println("The priority queue contains the book abbb? " + bookq.contains(new Book(111, "abbb")));
        System.out.println("The priority queue contains the book b0? " + bookq.contains(b0));
        System.out.println("bookq contains bookq2? " + bookq.containsAll(bookq2));
        System.out.println("bookq is equal to bookq2? " + bookq.equals(bookq2));
        
        Iterator<Book> itr = bookq.iterator();
        System.out.println("iteration with iterator for bookq:");
        while(itr.hasNext()){
            System.out.print(itr.next() + ", ");
        }
        System.out.println();
        
        Book b1 = bookq.peek();
        Book b2 = bookq2.peek();
        System.out.println("The first book in the priority queue 1: " + b1);
        System.out.println("The first book in the priority queue 2: " + b2);
        
        Book[] bArray = bookq.toArray(new Book[bookq.size()]);
        System.out.println("The priority queue of books converted to an array of books:");
        for(Book b: bArray)
            System.out.print(b + ", ");
        
        System.out.println("\nCalling collection's stream method to filter out starting with A:");
        bookq.stream().filter(e -> !e.getName().startsWith("A"))
                   .forEach(e->System.out.print(e + ", "));
        
        b1 = bookq.poll();
        System.out.println("The front of the priority queue: " + b1);
        System.out.println("After calling poll to remove the front:");
        bookq.forEach(e->System.out.print(e + ", "));
        
        b1 = bookq.remove();
        System.out.println("\nThe front of the priority queue: " + b1);
        System.out.println("After calling remove to remove the front:");
        bookq.forEach(e->System.out.print(e + ", "));
    }
}
