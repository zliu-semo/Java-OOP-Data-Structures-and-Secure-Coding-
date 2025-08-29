/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalinkedlistex3;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author ziping
 */
public interface Listable<T> extends Collection<T>{
    //add an item at the specified index position in a list
    public void add(int index, T item); 
    //compare the specified object with this list
    public boolean equals(Object o);
    //returns the item at the specified index position in a list
    public T get(int index);
    //returns the index of the specified object in the list, 
    //or -1 if the item is not in the list
    public int indexOf(Object o);
    //removes the first item specified from the list
    public boolean remove(Object o);
    //removes and returns the item at the specified index
    public T remove(int index);
    //returns the number of items in the list
    public int size();
    //returns the first position for a traversing in the list
    public Iterator<T> iterator();    
    public ListIterator<T> listIterator();
    //returns true if the list is empty
    public default boolean isEmpty(){
        return size() == 0;
    }    
    //add a collection of items at the back of a list
    public default boolean addAll(Collection<? extends T> c){
        if(!c.isEmpty()){
            for(T t:c)
                add(t);
            return true;
        }
        else
            return false;
    }
    //search an item in the list, returns true if the item is in the list
    public default boolean contains(Object o){
        if(indexOf(o) == -1)
            return false;
        return true;
    }    
    //add an item at the back of a list
    public default boolean add(T item){
        if(size() == 0){
            add(0, item);
            return true;
        }
        else if(item != null){
            add(size(), item);
            return true;
        }
        else
            return false;
    }     
    //returns an array containing all of the itmes in the list    
    @Override
    public default Object[] toArray(){
        T[] anArr = (T[]) new Object[size()] ;
        for(int i = 0; i < size(); i++)
            anArr[i] = get(i);    
        return anArr;
    }
    
    @Override
    public default boolean retainAll(Collection<?> c) {
        // Left as an exercise
        return true;
    }   
    
    @Override
    public default boolean removeAll(Collection<?> c) {
      // Left as an exercise
      return true;
    }   
    
    @Override
    public default boolean containsAll(Collection<?> c) {
      // Left as an exercise
      return true;
    }

    @Override
    public default <T> T[] toArray(T[] array) {
        // Left as an exercise
        T[] anArr = (T[]) new Object[size()] ;
        for(int i = 0; i < size(); i++)
            anArr[i] = (T)get(i);    
        array = anArr;
        return anArr;   
    }    
}
