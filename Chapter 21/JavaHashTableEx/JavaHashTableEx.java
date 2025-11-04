/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahashtableex;

/**
 *
 * @author ziping
 */
public class JavaHashTableEx {

    /**
     * @param args the command line arguments
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
        
        MyHashTable<Book, Double> ht = new MyHashTable(8);
        ht.Insert(bkArr[0], 9.99);
        ht.Insert(bkArr[1], 10.99);
        ht.Insert(bkArr[2], 8.99);
        ht.Insert(bkArr[3], 7.99);  
        ht.Insert(bkArr[4], 19.99);
        ht.Insert(bkArr[5], 29.99);
        ht.Insert(bkArr[6], 15.99);
        ht.Insert(bkArr[7], 18.99);    
        
        System.out.println("book BBBBB's prices: " + ht.Lookup(new Book(211, "BBBBB")));
        
        System.out.println("remove book bbbb with prices: " + ht.Remove(new Book(111, "bbbb")));
        
        System.out.println(ht);
    }
}
