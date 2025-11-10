import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Random;

/**
 * Demonstration of the use of the queue ADT through Java Collections
 */
public class Main {

    public static void main(String[] args) {
        Queue<Integer> myQueue = new LinkedList<Integer>();
        
        // Set a random number generator with the seed 126.
        Random intGenerator = new Random(126);
        for (int i = 0; i < 10; i++) {
            // Generate a random integer ranging from 0 to 15 (inclusive).
            int item = intGenerator.nextInt(16);
            myQueue.add(item);
        }
        
        // Examine the queue
        System.out.println("First element: " + myQueue.peek());
        System.out.println("Queue: " + myQueue.toString());
        
        // Iterate through the queue using a for-each loop
        System.out.println();
        System.out.println("Iterating with for-each loop");
        for (int item: myQueue) {
            System.out.print(String.format("%d ", item));
        }
        
        // Iterate through the queue using an explicit iterator
        System.out.println("\n");
        System.out.println("Iterating with iterator");
        Iterator<Integer> it = myQueue.iterator();
        while (it.hasNext()) {
            int item = it.next();
            System.out.print(String.format("%d ", item));
        }
        
        // Iterate through the queue using an explicit iterator and a lambda expression
        System.out.println("\n");
        System.out.println("Iterating with iterator and lambda expression");
        Iterator<Integer> it2 = myQueue.iterator();
        it2.forEachRemaining(item -> {
            System.out.print(String.format("%d ", item));
        });
        
        // Search for an item in the queue
        System.out.println("\n");
        System.out.println("1 in the queue? " + search(1, myQueue));
        System.out.println("10 in the queue? " + search(10, myQueue));
        System.out.println("12 in the queue? " + search(12, myQueue));
        
        // Test your Knowledge Check 1 (Java Collections Queues) method here.
        /*System.out.println();
        System.out.println("1's position? " + getIndexOf(1, myQueue));
        System.out.println("10's position? " + getIndexOf(10, myQueue));
        System.out.println("12's position? " + getIndexOf(12, myQueue));*/

        // Test your Knowledge Check 2 (Java Collections Queues) method here.
        /*System.out.println();
        System.out.println("Item in position 0? " + getElementAtIndex(0, myQueue));
        System.out.println("Item in position 5? " + getElementAtIndex(5, myQueue));
        
        try {
            System.out.println("Item in position -1? " + getElementAtIndex(-1, myQueue));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException");
        }
        
        try {
            System.out.println("Item in position 100? " + getElementAtIndex(100, myQueue));
        } catch (NoSuchElementException e) {
            System.out.println("Caught NoSuchElementException");
        }*/
    }
    
    public static boolean search(int tgt, Queue<Integer> q) {
        Queue<Integer> qCopy = new LinkedList<Integer>();
        qCopy.addAll(q);
        
        while (!qCopy.isEmpty()) {
            if (qCopy.poll() == tgt) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Knowledge Check 1 for Java Collections Queues: 
     * 
     * Write a method that returns the position of the first occurrence of a specified 
     * item in the queue, if the item exists. If the item cannot be found in the queue, 
     * return -1. Use at least one of the methods in the Queue interface. Test your 
     * method in the client driver. 
     */
    /*public static int getIndexOf(int tgt, Queue<Integer> q) {
        Queue<Integer> qCopy = new LinkedList<Integer>();
        qCopy.addAll(q);
        
        int idx = 0;
        while (!qCopy.isEmpty()) {
            if (qCopy.poll() == tgt) {
                return idx;
            }
            idx++;
        }
        return -1;
    }*/
    
    /*
     * Knowledge Check 2 for Java Collections Queues:
     * 
     * Write a method that extracts the element of a specified queue at a specified index. 
     * Your method should throw a NoSuchElementException if the specified index is outside
     * the bounds of the queue's length. If the specified index is negative, throw an 
     * IllegalArgumentException. Use at least one of the methods in the Queue interface.
     * Test your method in the client driver.
     */
    /*public static int getElementAtIndex(int idx, Queue<Integer> q) {
        if (idx < 0) {
            throw new IllegalArgumentException("Index cannot be negative.");
        }
        
        Queue<Integer> qCopy = new LinkedList<Integer>();
        qCopy.addAll(q);
        
        int counter = -1;
        int ele = Integer.MIN_VALUE;
        while (counter < idx) {
            ele = qCopy.remove();
            counter++;
        }
        return ele;
    }*/
}