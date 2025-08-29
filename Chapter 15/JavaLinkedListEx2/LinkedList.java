/*
 * implementation support deep copy and iterator
 */
package javalinkedlistex2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementing Iterable interface allows an object to be the target of the 
 * "for-each loop" statement
 * we are going to let our LinkedList support for-each loop
 * 
 * Iterator interface: An iterator over a collection.Iterator takes the place of 
 Enumeration in the Java Collections Framework. Iterators differ from enumerations in two ways:
 - Iterators allow the caller to remove elements from the underlying collection 
 during the iteration with well-defined semantics.
 - Method names have been improved.
 * @author ziping
 * @param <T>
 */
public class LinkedList<T extends TCloneable> implements Iterable<T> {
    private static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next){
           this.data = data;
           this.next = next;
        }
    }
    
    private Node<T> first;
    
    public LinkedList(){
        first = null;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    // add a new item after a specified item. if the specified item not found,
    // add the new item at the back
    public void insertAfter(T theItem, T newItem){
        if(first == null){
            first = new Node(newItem, null);
            return;
        }
            
        Node<T> cursor = first, preCursor = null;
        while(cursor != null && !cursor.data.equals(theItem)){
            preCursor = cursor;
            cursor = cursor.next;
        }

        if(cursor != null)
           cursor.next = new Node<>(newItem, cursor.next);
        else
            preCursor.next = new Node<>(newItem, null);
    }
 
    /*
    * Knowledge Check 1 for Java LinkedList Class Using Iterable 
    */     
    public void insertAsSecond(T newItem){
        if(first == null){
            first = new Node(newItem, null);
            return;
        }
        
        Node<T> newNode = new Node<>(newItem, first.next);
        first.next = newNode;
    }

    //removes a value from the LinkedList
    public void remove(T item){
        if(first == null)
           throw new RuntimeException("cannot delete");

        if( first.data.equals(item) ){
           first = first.next;
           return;
        }

        Node<T> cur  = first;
        Node<T> prev = null;
        while(cur != null && !cur.data.equals(item) ){
            prev = cur;
            cur = cur.next;
        }

        if(cur == null)
            throw new RuntimeException("cannot delete");

        //delete cur node
        prev.next = cur.next;
    }
    
    // check if the linkedlist contains the item
    public boolean contains(T item){
       for(T element : this)
          if(element.equals(item)) return true;

       return false;
    }
    
    public T get(int pos){
        if (first == null) throw new IndexOutOfBoundsException();

        Node<T> cursor = first;
        for (int k = 0; k < pos; k++) 
            cursor = cursor.next;

        if( cursor == null) throw new IndexOutOfBoundsException();

        return (T)cursor.data.clone(); //return copy of the data--deep copy
    }   
    
    public String toString(){
        StringBuffer result = new StringBuffer();
        for(Object x : this)
          result.append(x + ", ");

        return result.toString();
    }
    
    public boolean equals(Object other){
        if(other == null)
            return false;
        else if(getClass() != other.getClass())
            return false;
        else {
            LinkedList<T> second = (LinkedList<T>)other;
            Node<T> cursor = second.first;
            for(Object x : this) {
                if(cursor == null) return false;
                if(x.equals(cursor.data))
                    cursor = cursor.next;
            }
            if(cursor != null) return false;
            return true;
        }
    }
    
    public LinkedList<T> copylist(){
        LinkedList<T> thecopy = new LinkedList<>();
        Node<T> cursor = first;
        if(first == null) 
            return null;
        thecopy.first = new Node<>((T)first.data.clone(), null);
        Node<T> tmpCursor = thecopy.first;
        while(cursor.next != null)
        {
           cursor = cursor.next;
           tmpCursor.next = new Node<>((T)cursor.data.clone(), null);
           tmpCursor = tmpCursor.next;
        }

        return thecopy;
    }    
    
    // implement Iterable interface's iterator() method
    @Override
    public Iterator<T> iterator() {
       return new LinkedListIterator();
    }  
    
    // define a customerized iterator class 
    private class LinkedListIterator implements Iterator<T>{
       private Node<T> nextNode;

       public LinkedListIterator(){ //defines who will be the starting point
          nextNode = first;
       }

       @Override
       public boolean hasNext(){
          return nextNode != null;
       }

       @Override
       public T next(){ //defines how to advance to the next one
          if (!hasNext()) throw new NoSuchElementException();
          T ret = nextNode.data;
          nextNode = nextNode.next;
          return ret;
       }

       @Override
       public void remove(){ throw new UnsupportedOperationException(); }
     }       
}
