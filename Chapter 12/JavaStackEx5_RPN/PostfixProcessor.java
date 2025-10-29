package res;

import java.util.Stack;

/**
 * Class that reads in user input from standard input
 */
public class PostfixProcessor {
    private static final String NUMBER_PATTERN = "^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$";
    private static final String OPERATOR_PATTERN = "^[+\\-*/^]{1}$";
    
    /**
     * Used to test the regular expression {@code NUMBER_EXPRESSION}
     * @param s input String
     * @return {@code true} if the input String is a valid number; {@code false} otherwise
     */
    boolean isNumber(String s) {
        String numberPattern = "^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$";
        return s.matches(numberPattern);
    }
    
    /**
     * Creates a "dictionary" of operators on the stack to integers for easier comparison
     * @param op the mathematical operator
     * @return an integer, where lower value indicate higher precedence
     */
    private int mapOperatorToInt(String op) {
        if (op.equals("^")) return 1;
        else if (op.equals("*") || op.equals("/")) return 2;
        else if (op.equals("+") || op.equals("-")) return 3;
        else if (op.equals("(")) return 4;
        return Integer.MAX_VALUE;
    }
    
    /**
     * Determines whether {@code curr} has higher precedence than {@code other}
     * @param curr one mathematical operator
     * @param other the other mathematical operator
     * @return {@code true} if {@code curr} has higher precedence than {@code other};
     * {@code false} otherwise
     */
    boolean hasHigherPrecedence(String curr, String other) {
        int currInt = mapOperatorToInt(curr);
        int otherInt = mapOperatorToInt(other);
        return (currInt < otherInt);
    }
    
    /**
     * Evaluates a given postfix expression. Prints out intermediary steps.
     * @param expr the postfix expression
     * @return result of evaluating the postfix expression
     */
    public double evalPostfixExpression(String expr) {
        System.out.println(expr);
        String[] tokens = expr.trim().split("\\s+");
        Stack<Double> stack = new Stack<Double>();
        for (String token: tokens) {
            if (token.matches(NUMBER_PATTERN)) {
                double num = Double.parseDouble(token);
                stack.push(num);
                System.out.println("\tStack: " + stack.toString());
            } else if (token.matches(OPERATOR_PATTERN)) {
                double x = 0, y = 0;
                if (!stack.empty())
                    y = stack.pop();
                else {
                    System.out.println("missing numbers for operation");
                    return Double.NaN;
                }
                
                if (!stack.empty())
                    x = stack.pop();
                else {
                    System.out.println("missing numbers for operation");
                    return Double.NaN;
                }
                
                char operator = token.charAt(0);
                double result = Double.NaN;
                switch (operator) {
                    case '+': result = x + y; break;
                    case '-': result = x - y; break;
                    case '*': result = x * y; break; 
                    case '/': result = x / y; break;
                    case '^': result = Math.pow(x, y); break;
                }
                stack.push(result);
                System.out.println("\tStack: " + stack.toString());
            } else {
                System.out.println("tokens must be only numbers and operators");
                return Double.NaN;
            }
        }
        if (stack.empty()) {
            System.out.println("invalid postfix expression");
            return Double.NaN;
        }
        return stack.pop();   
    }
    
    /**
     * Converts an infix expression to postfix notation.
     * @param expr the given infix expression
     * @return the postfix expression
     */
    public String convertToPostfix(String expr) {
        System.out.println(expr);
        StringBuilder postfix = new StringBuilder();
        String[] tokens = expr.trim().split("\\s+");
        Stack<String> stack = new Stack<String>();
        
        for (String token: tokens) {
            if (token.matches(NUMBER_PATTERN)) postfix.append(token + " ");
            else if (token.equals("(")) stack.push(token);
            else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop() + " ");
                }
                if (stack.isEmpty()) {
                    System.out.println("mismatched parentheses");
                    return "None";
                } else stack.pop();
            } else if (token.matches(OPERATOR_PATTERN)) {
                while (!stack.isEmpty() && !hasHigherPrecedence(token, stack.peek())) {
                    postfix.append(stack.pop() + " ");
                }
                stack.push(token);
            } else {
                System.out.println("tokens must be only numbers and operator");
            }
            System.out.println("\t" + stack.toString() + 
                    "\t" + postfix.toString());
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop() + " ");
        }
        return postfix.toString();
    }
}