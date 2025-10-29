//Goal: use an Iterable stack.

package client;
import java.util.Iterator;
import res.*;

public class Main {
    public static void main(String[] args) {
       StackIter stack = new StackIter(new int[] {1,2,3,4,5,6,7,8,9,10});
       // iterating manually
       Iterator<Integer> iter = stack.iterator();
       while (iter.hasNext()) {
           System.out.println(iter.next());
       }
       // iterating implicitly, using a for-each loop
       for (int x: stack)
           System.out.println(x);
       System.out.println("5 in stack? " + findInStack(stack, 5));
       System.out.println("15 in stack? " + findInStack(stack, 15));
    }

    public static boolean findInStack(StackIter stack, int tgt) {
        if (stack == null) {
            throw new IllegalArgumentException("input stack is null");
        }
        
        for (int x: stack) {
            if (x == tgt)
                return true;
        }
        return false;   
    }
}
    