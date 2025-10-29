/**
 * Demonstrate how to use the Java Collections Stack<E> class
 */
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new Stack<Integer>();
        System.out.println("int stack is empty? " + stackInt.empty());
        stackInt.push(100);
        stackInt.push(80);
        System.out.println("top of int stack: " + stackInt.peek());
        System.out.println("popped int element: " + stackInt.pop());
        System.out.println("top of int stack: " + stackInt.peek());
        
        String sentence1 = "Was it a cat I saw?";
        String sentence2 = "The Queen of Hearts had some tarts";
        Stack<Character> stackChar1 = stringToAlphanumericStack(sentence1);
        Stack<Character> stackChar2 = stringToAlphanumericStack(sentence2);
        System.out.println("top of char stack 1: " + stackChar1.peek());
        System.out.println("top of char stack 2: " + stackChar2.peek());
        
        System.out.println("Q in char stack 1? " + stackChar1.search('Q'));
        System.out.println("Q in char stack 2? " + stackChar2.search('Q'));
        System.out.println("Q in int stack? " + stackInt.search('Q'));
        
        System.out.println("sentence1 is palindrome? " + stringIsPalindrome(sentence1));
        System.out.println("sentence2 is palindrome? " + stringIsPalindrome(sentence2));
        
        // Add your Knowledge Check 1 (Java Stacks) client code here. 
        /*Stack<Double> stackFloat = new Stack<Double>();
        stackFloat.push(3.14);
        stackFloat.push(-100.0);
        stackFloat.push(65.43210);
        stackFloat.push(-96.1);
        stackFloat.push(0.0);
        System.out.println(topmostLessThanTarget(stackFloat, -98.0));
        System.out.println(topmostLessThanTarget(stackFloat, 7.0));
        System.out.println(topmostLessThanTarget(stackFloat, -100.0));*/
        
        
        // Add your Knowledge Check 2 (Java Stacks) client code here. 
        /*System.out.println(reverseString("WAS"));
        System.out.println(reverseString("PAM"));
        System.out.println(reverseString("Blue Ridge Mountains"));*/
    }
    
    /**
     * Converts an input String into a {@code Stack<Character>}, preserving the same order.
     * @param s the input String
     * @return an alphanumeric stack
     * @throws IllegalArgumentException if the input String is {@code null}
     */
    public static Stack<Character> stringToAlphanumericStack(String s) {
        if (s == null)
            throw new IllegalArgumentException("input String is null");
        
        Stack<Character> stackChar = new Stack<Character>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c))
                stackChar.push(Character.toUpperCase(c));
        }
        return stackChar;
    }
    
    /**
     * Checks if an input String is a palindrome, considering only its alphanumeric characters.
     * @param s the input String
     * @return {@code true} if the input String is a palindrome; {@code false} otherwise
     * @throws IllegalArgumentException if the input String is {@code null}
     */
    @SuppressWarnings("unchecked")
    public static boolean stringIsPalindrome(String s) {
        if (s == null) 
            throw new IllegalArgumentException("input String is null");
        
        Stack<Character> forward = stringToAlphanumericStack(s);
        //Stack<Character> forwardClone = (Stack<Character>) forward.clone();
        Stack<Character> backward = new Stack<Character>();
        for (char c: forward)
            backward.push(c);
        //while (!forwardClone.empty())
        //    backward.push(forwardClone.pop());
        while (!forward.empty() && !backward.empty()) {
            if (forward.pop() != backward.pop()) {
                return false;
            }
        }
        return true;
    }
    
    /*
     * Knowledge Check 1 for Java Stacks:
     * Write a method that takes in a target double and a Stack of doubles and 
     * returns the topmost element in the stack that is less than the target, 
     * without modifying the original stack. Test your program in the client 
     * driver.
     */
    /**
     * Finds and returns the topmost element in an (unsorted) stack that is
     * less than the target double.
     * @param stack the input stack
     * @param tgt the target double
     * @return the topmost element in {@code stack} that is strictly less than
     * {@code tgt}; if no elements are less than {@code tgt}, the method
     * returns {@code Double.MIN_VALUE}.
     * @throws IllegalArgumentException if the input stack is null.
     */
    public static double topmostLessThanTarget(Stack<Double> stack, double tgt) {
        if (stack == null)
            throw new IllegalArgumentException("input stack is null");
        
        @SuppressWarnings("unchecked")
        Stack<Double> cloned = (Stack<Double>) stack.clone();
        
        while (!cloned.empty()) {
            double current = cloned.pop();
            if (current < tgt)
                return current;
        }
        return Double.MIN_VALUE;
    }
    
    /*
     * Knowledge Check 2 for Java Stacks:
     * Write a method that reverses an input String using the Stack data structure 
     * and returns the reversed version of the input String. Test your program in 
     * the client driver.
     */
    /**
     * Given an input String, returns a reversed version of that String.
     * @param s the input String
     * @return a reversed version of that String, character-by-character
     * @throws IllegalArgumentException if the input String is null
     */
    public static String reverseString(String s) {
        if (s == null)
            throw new IllegalArgumentException("input String is null");
        
        Stack<Character> original = new Stack<Character>();
        int n = s.length();
        for (int i = 0; i < n; i++)
            original.push(s.charAt(i));
        
        StringBuilder builder = new StringBuilder();
        while(!original.empty())
            builder.append(original.pop());
        return builder.toString();
    }
}