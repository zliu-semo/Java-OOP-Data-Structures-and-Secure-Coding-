//Goal: implement a base-n transformation algorithm using a stack.

package client;
import res.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("13 in binary base: " + calculateBaseN(13, 2));
        System.out.println("80 in binary base: " + calculateBaseN(80, 2));
        System.out.println("80 in hexadecimal base: " + 
            calculateBaseN(80, 6));
        System.out.println("80 in octadecimal base: " + 
            calculateBaseN(80, 8));
    }
    public static int calculateBaseN(int decimalNum, int n) {
        if (n > 9) 
            throw new IllegalArgumentException(
                "Input base must be at most 9.");
        if (decimalNum < 0) {
            throw new IllegalArgumentException(
                "Input number must be non-negative.");
        }
        StackInt stack = new StackInt();
        int quotient = decimalNum;
        while (quotient > 0) {
            int remainder = quotient % n;
            stack.push(remainder);
            quotient = quotient / n;
        }
        int result = 0;
        int power = (int) Math.pow(10, stack.getTop());
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            result += digit * power;
            power /= 10;
        }
        return result;
    }
}
