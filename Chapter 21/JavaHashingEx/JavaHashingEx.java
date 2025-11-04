/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahashingex;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

/**
 *
 * @author ziping
 */
public class JavaHashingEx {

    /**
     * demonstrate hashCode() method and the meaning of hashing
     */
    public static void main(String[] args) {
        Book[] bkArr = new Book[8];
        bkArr[0] = new Book(111, "bbbb");
        bkArr[1] = new Book(111, "bbbb");
        bkArr[2] = new Book(131, "aaaa");
        bkArr[3] = new Book(121, "cccc");
        bkArr[4] = new Book(151, "abc1");
        bkArr[5] = new Book(211, "BBBBB");
        bkArr[6] = new Book(231, "AAAAA");
        bkArr[7] = new Book(221, "CCCCC");
        
        // search in an array is O(n)
        int index = 0;
        boolean found = false;
        for(Book bk : bkArr){
            if(bk.equals(new Book(151, "abc19"))){
                found = true;
                System.out.println("The book is at index: " + index);
                break;
            }
            index++;
        }
        if(!found)
            System.out.println("The book is not found");
        
        // if hashCode( ) method provided, testing if both books have same hashcode
        System.out.println("bkArr[0] hashCode: " + bkArr[0].hashCode());
        System.out.println("bkArr[1] hashCode: " + bkArr[1].hashCode());
        
        Set<Book> st = new HashSet<>(); 
        // testing hashCode( ) method provided vs not provided
        // if hashCode( ) not overriden, the duplicate copy will be added to hashSet
        // otherwise, only unique copy will be added to hashSet
        for(Book bk : bkArr)
            st.add(bk);
        // set size is one less than the array size
        System.out.println("The size of the set is:" + st.size());
        System.out.println("The set of books is:"); 
        System.out.println(st.toString()); 
        System.out.println("The Set contains the book bbbb? " + st.contains(new Book(111, "bbbb")));
        
        ArrayList<Book>[] hashBkArr = new ArrayList[8];        
        for(int i = 0; i < 8; i++)
            hashBkArr[i] = new ArrayList<Book>();
        for(Book bk : bkArr)
            hashBkArr[bk.hashCode() % 8].add(bk);
        for(int i = 0; i < 8; i++)
            System.out.println(hashBkArr[i]);
        
        Book var = new Book(211, "BBBBB");
        int row = var.hashCode() % 8; // O(1) time
        int col = hashBkArr[row].indexOf(var); //O(N) time
        System.out.println("the book is at (row, column): (" + row + ", " + col + ")");
        Object o = new Object();
        System.out.println(o.hashCode());
    }    
}
