//Goal: use a capacity-bounded stack.
package client;

import java.util.Arrays;
import res.*;

public class Main {
    public static void main(String[] args) {
        StackInt stack = new StackInt();
        System.out.println("Stack is empty? " + stack.isEmpty());
        System.out.println("Stack: " + stack.toString());
        stack.push(29);
        System.out.println("Stack is empty? " + stack.isEmpty());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack: " + stack.toString());
        stack.push(51);
        stack.push(308);
        stack.push(65);
        stack.push(155);
        stack.push(78);
        stack.push(81);
        stack.push(99);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack: " + stack.toString());
        //stack.push(100); // will cause IllegalStateException
        StackInt copy = (StackInt) stack.clone();
        copy.pop();
        copy.pop();
        System.out.println("Stack: " + copy.toString());
        int[] target = {100, 301, 603, 301, 100};
        stack = new StackInt(target);
        int[] reversedArr = new int[target.length];
        int i = 0;
        while (!stack.isEmpty()) {
            reversedArr[i] = stack.pop();
            i++;
        }
        System.out.println("target is palindrome? " + 
            Arrays.equals(target, reversedArr));
    }
}
