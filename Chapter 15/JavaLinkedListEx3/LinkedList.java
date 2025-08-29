/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalinkedlistex3;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *
 * @author ziping
 */
public class LinkedList<T> implements Listable<T> {
    private static class Node<T>{
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data, Node<T> prev, Node<T> next){
           this.data = data;
           this.prev = prev;
           this.next = next;
        }
    } 
    
    private Node<T> head; //node before the first node
    private Node<T> tail; //node after the last node
    private int count; //number of nodes
    
    public LinkedList(){
        head = null;
        tail = null;
        count = 0;
    }
    
    //add an item at the specified index position in a list
    public void add(int index, T item){
        if(index == 0){
            Node<T> newNode = new Node(item, null, null);
            head = newNode;
            tail = newNode;
        }
        else if(index >= count) {
            Node<T> newNode = new Node(item, tail, null);
            Node<T> cursor = head;
            for(int i = 0; i < count - 1; i++)
                cursor = cursor.next;
            cursor.next = newNode;
            tail = newNode;
        }
        else{
            Node<T> cursor = head;
            for(int i = 0; i < index - 1; i++)
                cursor = cursor.next;
            Node<T> newNode = new Node(item, cursor, cursor.next);
            cursor.next.prev = newNode;
            cursor.next = newNode;
        } 
        count++;
    }
    
    //compare the specified object with this list
    public boolean equals(Object other){
        if(other == null)
            return false;
        else if(getClass() != other.getClass())
            return false;
        else {
            LinkedList<T> second = (LinkedList<T>)other;
            Node<T> cursor = second.head;
            for(Object x : this) {
                if(cursor == null) return false;
                if(x.equals(cursor.data))
                    cursor = cursor.next;
            }
            if(cursor != null) return false;
            return true;
        }
    }
    //returns the item at the specified index position in a list
    public T get(int index){
        if (head == null) throw new IndexOutOfBoundsException();

        Node<T> cursor = head;
        for (int k = 0; k < index; k++) 
            cursor = cursor.next;

        if( cursor == null) throw new IndexOutOfBoundsException();

        return (T)cursor.data; //return copy of the data
    }
    
    //returns the index of the specified object in the list, 
    //or -1 if the item is not in the list
    public int indexOf(Object item){
        int num = 0;
        for(T element : this){
            if(element.equals(item)) 
                return num;
            num++;
        }

        return -1;
    }
    //removes the first item specified from the list
    public boolean remove(Object item){
        if(head == null)
           return false;

        if( head.data.equals(item) ){
           head = head.next;
           head.prev = null;
           count--;
           return true;
        }

        Node<T> cur  = head;
        Node<T> prev = null;
        while(cur != null && !cur.data.equals(item) ){
            prev = cur;
            cur = cur.next;
        }

        if(cur == null)
            return false;

        //delete cur node
        prev.next = cur.next;   
        if(prev.next == null)
            tail = prev;
        else
            cur.next.prev = prev;
        count--;
        return true;
    }
    //removes and returns the item at the specified index
    public T remove(int index){
        if (head == null) throw new IndexOutOfBoundsException();

        Node<T> cursor = head;
        Node<T> prev = null;
        for (int k = 0; k < index; k++){
            prev = cursor;
            cursor = cursor.next;
        }

        if( cursor == null) throw new IndexOutOfBoundsException();

        T ret = (T)cursor.data;        

        if( index == 0 ){
           head = head.next;
           head.prev = null;
           count--;
           return ret;
        }

        //delete cur node
        prev.next = cursor.next;   
        if(prev.next == null)
            tail = prev;
        else
            cursor.next.prev = prev;
        count--;
        return ret;
    }
    
    public void clear(){
        head = null;
        tail = null;
    }
    //returns the number of items in the list  
    @Override
    public int size(){
        return count;
    }
    
    public String toString(){
        StringBuffer result = new StringBuffer();
        for(Object x : this)
          result.append(x + ", ");

        return result.toString();
    }    

    // implement Iterable interface's iterator() method
    public Iterator<T> iterator() {
       return new LinkedListIterator();
    }  
    
    // define a customerized iterator class 
    private class LinkedListIterator implements Iterator<T>{
       private Node<T> nextNode;

       public LinkedListIterator(){ //defines who will be the starting point
          nextNode = head;
       }

       public boolean hasNext(){
          return nextNode != null;
       }

       public T next(){ //defines how to advance to the next one
          if (!hasNext()) throw new NoSuchElementException();
          T ret = nextNode.data;
          nextNode = nextNode.next;
          return ret;
       }
       
       public void remove(){
          throw new UnsupportedOperationException();
       }
    }   
    
    public ListIterator<T> listIterator(){
        return new BiLinkedListIterator();
    }
    
    public ListIterator<T> listIterator(int index){
        return new BiLinkedListIterator(index);
    }
    
    // assumes no calls to DoublyLinkedList.add() during iteration
    private class BiLinkedListIterator implements ListIterator<T> {
        // the node returned by next() call
        private Node<T> current = head;  
        // the node returned by next() or previous() call
        private Node<T> lastAccessed = null;      
        // index position for node current                                            
        private int index = 0;
        
        BiLinkedListIterator(){}
        // Returns a list-iterator starting at the specified position in the list.
        BiLinkedListIterator(int i){
            while(i>0 && hasNext())
                next();
        }

        // Returns true if this list iterator has more elements 
        // when traversing the list in the forward direction.
        public boolean hasNext(){ 
            return index < count; 
        }
        
        // Returns true if this list iterator has more elements 
        // when traversing the list in the reverse direction.
        public boolean hasPrevious(){ 
            return index > 0; 
        }
        
        // Returns the index of the element 
        // that would be returned by a subsequent call to previous().
        public int previousIndex(){ 
            return index; 
        }
        
        // Returns the index of the element 
        // that would be returned by a subsequent call to next().
        public int nextIndex(){ 
            return index;     
        }

        // Returns the item contained in the current iterator 
        // and advances the current node 
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastAccessed = current;
            T item = current.data;
            current = current.next; 
            index++;
            return item;
        }

        // Returns the item before the current iterator 
        // and moves the current node backwards.
        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            if(current == null)
                current = lastAccessed;
            T item = current.data;
            lastAccessed = current;
            current = current.prev;
            index--;
            return item;
        }

        // Replaces the last item returned by next() or previous() 
        // with the specified value
        public void set(T item) {
            if (lastAccessed == null) 
                throw new IllegalStateException();
            lastAccessed.data = item;
        }

        // Removes the last item that was returned by next() or previous()
        public void remove() { 
            if (lastAccessed == null) 
                throw new IllegalStateException();
            Node before = lastAccessed.prev;
            Node after = lastAccessed.next;
            if(before != null) // remove in the middle
                before.next = after;
            else  // remove the first node
                head = after;
            if(after != null) // remove in the middle
                after.prev = before; 
            else // remove the last node
                tail = before;
            count--;
            index--;
            lastAccessed = null;
        }

        // Inserts the specified item after the item 
        // returned from call to next( ) or previous() 
        public void add(T item) {
            Node<T> before = lastAccessed; //current.prev;
            Node<T> newNode = new Node(item, null, null);
            Node after = current;
            if(lastAccessed != null)  // insert in the middle               
                before.next = newNode;
            else  // insert as first node
                head = newNode;
            newNode.next = after;
            if(current != null)  // insert in the middle
                after.prev = newNode;
            else  // insert as the last node
                tail = newNode;
            newNode.prev = before;
            count++;
            index++;
            lastAccessed = null;
        }
    }
    
}
