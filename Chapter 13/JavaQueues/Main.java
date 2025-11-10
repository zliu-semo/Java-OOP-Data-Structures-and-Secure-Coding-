package client;

import res.*;

public class Main {

    public static void main(String[] args) {        
        Queue queue = new CircularArrayQueue(3);
        System.out.println("Queue is empty? " + queue.isEmpty());

        queue.enqueue(32);
        System.out.println("\nEnqueue 32");
        System.out.println("Queue is empty? " + queue.isEmpty());
        System.out.println("Length of queue: " + queue.length());

        queue.enqueue(90);
        queue.enqueue(88);
        System.out.println("\nEnqueue 90 and 88");
        System.out.println("Length of queue: " + queue.length());
        System.out.println("Queue: " + queue.toString());
       
        System.out.println("Queue iteration: ");
        for(int item : queue) {
        	System.out.print(item + ", ");
        }
        System.out.println();        

        try {
            queue.enqueue(100);
        } catch (FullQueueException e) {
            System.out.println("\n" + e.getMessage());
        }

        System.out.println("\nDequeue: " + queue.dequeue());
        System.out.println("Length of queue: " + queue.length());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Length of queue: " + queue.length());

        queue.enqueue(100);
        System.out.println("\nEnqueue 100");
        System.out.println("Queue: " + queue.toString());    

        queue.dequeue();
        queue.dequeue();
        System.out.println("\nAfter dequeuing twice, is empty? " + queue.isEmpty());

        try {
            queue.dequeue();
        } catch (EmptyQueueException e) {
            System.out.println("\n" + e.getMessage());
        }
    }
}