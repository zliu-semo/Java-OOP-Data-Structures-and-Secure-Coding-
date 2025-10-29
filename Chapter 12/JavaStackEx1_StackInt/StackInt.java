//Goal: implement a capacity-bounded stack using an array.
package res;
import java.util.Arrays;

public class StackInt implements Cloneable {
    private int[] arr;
    private int top;
    private static final int CAPACITY = 8;
    public StackInt() {
        arr = new int[CAPACITY];
        top = -1;
    }
    
    public StackInt(int[] inputArr) {
        arr = Arrays.copyOfRange(inputArr, 0, CAPACITY);
        top = Math.min(CAPACITY - 1, inputArr.length - 1);
        if (inputArr.length >= CAPACITY) {
            System.out.println(
                String.format(
                    "Input array was too long. "
                    + "Copied over only %d elements", CAPACITY));
        }
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public void push(int x) {
        if (top == CAPACITY - 1) {
            throw new IllegalStateException(
                "Stack is full. Unsuccessful push.");
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
        stackCopy.arr = Arrays.copyOf(this.arr, CAPACITY);
        return stackCopy;
    }
}
