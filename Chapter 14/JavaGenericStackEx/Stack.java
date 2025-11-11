/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagenericstackex;
import java.util.Arrays; 
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author ziping
 */
public class Stack<T> implements Cloneable, Comparable<Stack<T>>, Iterable<T>{
    private static final int CAPACITY = 8;
    private T[] mArray;
    private int mTop;
    
    @SuppressWarnings("unchecked") 
    // Apply the suppression here due to cast an Object[] to a T[], 
    // which the Java compiler emits an "unchecked cast" warning
    public Stack(){
        mArray = (T[])new Object[CAPACITY];
        mTop = -1;
    }
    
    @SuppressWarnings("unchecked") 
    public Stack(int initcap){
        mArray = (T[])new Object[initcap];
        mTop = -1;          
    }
    
    //copy constructor
    public Stack(Stack<T> other) {
        // shallow copy all elements from the 'other' stack
        mTop = other.mTop;
        mArray = Arrays.copyOf(other.mArray, other.mArray.length);    	
    }
    
    public boolean empty(){
        return mTop == -1;
    }
    
    @SuppressWarnings("unchecked") 
    public void push(T e){
        if (mTop + 1 >= mArray.length) {
            T[] temp = (T[])new Object[mArray.length * 2];
            System.arraycopy(mArray, 0, temp, 0, mArray.length);
            mArray = temp;
        }
        mTop++;
        mArray[mTop] = e;
    }
    
    public void pop(){
        try{
            if(mTop == -1)
                throw new Exception();
            mTop--;
        }
        catch(Exception ex){
            System.out.println("stack is empty");
        }
    }
    
    public T peek(){
        try{
            if(mTop == -1)
                throw new Exception();
            return mArray[mTop];
        }
        catch(Exception ex){
            System.out.println("stack is empty");
        } 
        return mArray[mTop];
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        try{
            if(mTop == -1)
                throw new Exception();
            for(T e : mArray){
                if(e!=null)
                    sb.append(e + ", ");
            }            
        }
        catch(Exception ex){
            System.out.println("stack is empty");
        }
        return sb.toString();
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Stack<T> sClone = new Stack<T>(mArray.length);
        sClone.mTop = mTop;
        sClone.mArray = Arrays.copyOf(mArray, mArray.length);
        return sClone;
    }
    
    @Override
    public int compareTo(Stack<T> another){
        int size = mTop + 1;
        int othersize = another.mTop + 1;
                
        if(size < othersize)
            return -1;
        else if(size > othersize)
            return 1;
        else
            return 0;
    }  
    
    @Override
    public Iterator<T> iterator(){
        return new stackIterator();
    }
    
    private class stackIterator implements Iterator<T>{
        private int index;
        // constructor: initialize index to mTop
        stackIterator() { 
            index = mTop;
        } 

        // Checks if the next element exists 
        @Override
        public boolean hasNext() { 
            return index >= 0;
        } 

        // Returns the next element in the stack and advances iterator by one slot 
        @Override
        public T next() { 
            if (!hasNext()) {
            	throw new NoSuchElementException();
            }
            T result = mArray[index];
            index--;
            return result;            
        } 

        // Used to remove an element. Implement only if needed 
        @Override
        public void remove() { 
            // Default throws UnsupportedOperationException. 
            throw new UnsupportedOperationException();
        } 
    }      
}
