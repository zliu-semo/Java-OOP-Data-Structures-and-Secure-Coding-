/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacollectionsdeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Java Collections Deque example
 * @author ziping
 */
public class JavaCollectionsDeque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Deque<Book> dq = new ArrayDeque<Book>(); 
        dq.addFirst(new Book(111, "bbbb")); 
        dq.addLast(new Book(131, "aaaa")); 
        dq.addFirst(new Book(121, "cccc")); 
        dq.addLast(new Book(151, "abc1"));
        dq.addFirst(new Book(111, "abbb"));
        System.out.println("The ArrayDeque of books:\n" + dq);
  
        Deque<Book> dq2 = new ArrayDeque<Book>(); 
        dq2.offerFirst(new Book(211, "BBBBB")); 
        dq2.offerLast(new Book(231, "AAAAA")); 
        dq2.add(new Book(221, "CCCCC")); 
        System.out.println("The second ArrayDeque of books:\n" + dq2);

        dq.addAll(dq2);
        
        System.out.println("The ArrayDeque added books from the second ArrayDeque"); 
        System.out.println(dq.toString());
        
        System.out.println("get the first element of the deque: " + dq.getFirst());
        System.out.println("get the last element of the deque: " + dq.getLast());
  
        System.out.println("peek the first element of the deque: " + dq.peekFirst());
        System.out.println("peek the last element of the deque: " + dq.peekLast());
        
        
        System.out.println("The ArrayList contains the book abbb? " + dq.contains(new Book(111, "abbb")));
        System.out.println("dq contains dq2? " + dq.containsAll(dq2));
        System.out.println("dq is equal to dq2? " + dq.equals(dq2));
        
        Iterator<Book> itr = dq.iterator();
        System.out.println("iteration with iterator for dq:");
        while(itr.hasNext()){
            System.out.print(itr.next() + ", ");
        }
        System.out.println();
        
        Iterator<Book> revItr = dq.descendingIterator();
        System.out.println("iteration with reverse iterator for dq:");
        while(revItr.hasNext()){
            System.out.print(revItr.next() + ", ");
        }
        System.out.println();
        
        System.out.println("Item abbc removed? " + dq.removeFirstOccurrence(new Book(111, "abbc")));
       
        Book b1 = dq.pollFirst();
        Book b2 = dq.pollLast();
        System.out.println("The deque of books after removing first and last:\n" + dq);
        
        dq.push(b2);
        System.out.println("The deque of books after pushing another book:\n" + dq);
        dq.pop();
        System.out.println("The deque of books after poping a book:\n" + dq);
        System.out.println("The front of the deque: " + dq.peek());
        System.out.println("The deque of books after peeking:\n" + dq);
        Book b3 = dq.poll();
        System.out.println("The book polled: " + b3);
        System.out.println("The deque of books after polling:\n" + dq);
    }    
}
