//Goal: implement an Iterable stack.

package res;
import java.util.Arrays;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackIter implements Cloneable, Iterable<Integer> {
    private int[] arr;
    private int top;
    
    private int currCapacity; 

    public StackIter() {
        currCapacity = 8;
        arr = new int[currCapacity];
        top = -1;
    }
    
    public StackIter(int[] inputArr) {
    	currCapacity = (int) Math.pow(2, 
    		    Math.ceil(Math.log(inputArr.length) / Math.log(2)));
    	arr = Arrays.copyOfRange(inputArr, 0, currCapacity);
    	top = Math.min(currCapacity - 1, inputArr.length - 1);

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
            throw new IllegalStateException("Stack is empty. Unsuccessful pop.");
        } 
        int ele = arr[top];
        if (top == currCapacity / 2) {
            currCapacity = currCapacity / 2;
            arr = Arrays.copyOfRange(arr, 0, currCapacity);
        }
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
        StackIter stackCopy = new StackIter();
        stackCopy.top = this.top;
        stackCopy.arr = Arrays.copyOf(this.arr, this.currCapacity);
        return stackCopy;
    }
    
    public int getTop() {
        return top;
    } 
    
    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> iter = new Iterator<Integer>() {
            private int currIndex = StackIter.this.top;
            @Override
            public boolean hasNext() {
                return currIndex >= 0;
            }
            @Override
            public Integer next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                Integer ele = StackIter.this.arr[currIndex];
                currIndex--;
                return ele;
            }
        };
        return iter;
    }
}
