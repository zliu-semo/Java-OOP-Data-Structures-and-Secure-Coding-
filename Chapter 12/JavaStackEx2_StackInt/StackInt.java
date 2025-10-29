//Goal: implement a capacity-unbounded stack using an array.

package res;
import java.util.Arrays;

public class StackInt implements Cloneable {
    private int[] arr;
    private int top;
    private int currCapacity;
    public StackInt() {
        currCapacity = 8;
        arr = new int[currCapacity];
        top = -1;
    }
    
    public StackInt(int[] inputArr) {
        // TODO
    }
    
    public boolean isEmpty() {
        return top == -1;
    }    
    
    public void push(int x) {
        if (top == currCapacity - 1) {
            // Double the size of the underlying array
            currCapacity = currCapacity * 2;
            // Copy the original underlying array over
            arr = Arrays.copyOfRange(arr, 0, currCapacity);
        } 
        top++;
        arr[top] = x;
    }
    
    public int pop() {
        if (top == -1) {
            throw new IllegalStateException(
                "Stack is empty. Unsuccessful pop.");
        } 
        int ele = arr[top];
        top--;
        return ele;
    }
    
    public int peek() {
        if (top == -1) {
            throw new IllegalStateException(
                "Stack is empty. No elements to peek.");
        } 
        return arr[top];
    }
    
    @Override
    public String toString() {
        if (top == -1) {
            return "Empty stack";
        }
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = top; i > -1; i--) {
            builder.append(arr[i]);
            builder.append(';');
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(']');
        return builder.toString();
    }
    
    @Override
    public Object clone() {
        StackInt stackCopy = new StackInt();
        stackCopy.top = this.top;
        stackCopy.arr = Arrays.copyOf(this.arr, this.currCapacity);
        return stackCopy;
    }
    
    public int getTop() {
        return top;
    }   
}

