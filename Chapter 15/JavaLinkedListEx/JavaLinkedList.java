/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalinkedlist;

/**
 *
 * @author ziping
 */
public class JavaLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<String> slist = new LinkedList <>();
        if(slist.isEmpty())
            System.out.println("Created an empty string list");
        
        slist.insert("z");
        slist.insert("a");
        slist.insert("e");
        slist.insert("h");
        slist.insert("y");
        System.out.println("created a string list: " + slist);
        slist.insert("ee");
        System.out.println("after insert another new item: " + slist);
        slist.remove("e");
        System.out.println("after remove an item: " + slist);
 
        /*
        * Knowledge Check 1 for Java LinkedList Class  
        */         
        System.out.println("searching g: " + slist.search("g"));

        LinkedList<Integer> ilist = new LinkedList <>();
        if(ilist.isEmpty())
            System.out.println("Created an empty integer list");
        
        ilist.insert(50);
        ilist.insert(30);
        ilist.insert(90);
        ilist.insert(150);
        ilist.insert(29);
        System.out.println("created a string list: " + ilist);
        ilist.insert(55);
        System.out.println("after insert another new item: " + ilist);
        ilist.remove(30);
        System.out.println("after remove an item: " + ilist);        
    }
}
