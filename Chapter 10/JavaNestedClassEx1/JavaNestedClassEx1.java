package client;

import java.util.Arrays;

import res.*;

/**
 * Client driver for JavaNestedClassEx1
 */
public class JavaNestedClassEx1 {

    public static void main(String[] args) {
        // Demonstrate inner class use cases.
        Counter c1 = new Counter();
        Counter c2 = new Counter(2, 4);
        Counter.SmallCounter s11 = c1.new SmallCounter();
        Counter.SmallCounter s12 = c1.new SmallCounter(10, 20);
        Counter.SmallCounter s21 = c2.new SmallCounter();
        
        s11.incrementSmallCount1();
        s11.incrementSmallCount2();
        s21.incrementSmallCount2();
        c2.incrementCount2();
        s21.incrementSmallCount2();
        
        System.out.println("Counter 1: " + c1.toString());
        System.out.println("SmallCounter 1-1: " + s11.toString());
        System.out.println("SmallCounter 1-2: " + s12.toString());
        System.out.println("Counter 2: " + c2.toString());
        System.out.println("SmallCounter 2-1: " + s21.toString());
        
        System.out.println("Counters 1, 2 structurally equal? " + c1.equals(c2));
        System.out.println("SmallCounters 1-1, 2-1 structurally equal? " + s11.equals(s21));
        
        System.out.println("Total Counters: " + Counter.getTotalCounters());
        System.out.println("Counter 1's SmallCounters: " + c1.getNumSmallCounters());
        System.out.println("Counter 2's SmallCounters: " + c2.getNumSmallCounters());
        
        // Add code for Knowledge Check 2 here.
        
        // Demonstrate static nested class use cases.
        System.out.println(Counter.getStaticSmallCounterStrings());
        
        Counter.StaticSmallCounter myStaticSmallCounter = 
                new Counter.StaticSmallCounter(100, "special counter");
        myStaticSmallCounter.incrementNum();
        System.out.println("Total StaticSmallCounters: " + 
            Counter.StaticSmallCounter.getTotalStaticSmallCounters());
        System.out.println("myStaticSmallCounter---> " + myStaticSmallCounter.toString());
        
        // Demonstrate local class use cases.
        int[][] t1 = c1.createTapestry("first tapestry");
        System.out.println(Arrays.deepToString(t1));
    }
}