import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExceptionEx3 {

    public static void main(String[] args) {
        Scanner input = null;//new Scanner(System.in);
        try {
            getInputsAndDisplay(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Ready to do another task in main()");
        }
    }

    /**
     * Prompts the user for two integers for division and displays the result.
     * @param input standard input object
     * @throws IllegalArgumentException if an input is not an integer, the divisor
     * input is zero, or if {@code input} is {@code null}
     */
    public static void getInputsAndDisplay(Scanner input) throws IllegalArgumentException {
        try {
            System.out.println("Enter two integers for division: A/B");
            System.out.println("A = ");
            int a = input.nextInt();  // could throw InputMismatchException, or
            // NullPointerException if input is null
            System.out.println("B = ");
            int b = input.nextInt();  // could throw InputMismatchException
            System.out.println(a + " / " + b + " is " + doDivision(a, b));
        } catch (ArithmeticException e) {  // from the doDivision invocation
            throw new IllegalArgumentException("ArithmeticException: "
                    + "Divisor cannot be zero ");
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("InputMismatchException: "
                    + "Inputs must be an integer");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("NullPointerException: "
                    + "Scanner input cannot be null");
        } finally {
            System.out.println("Finished getInputsAndDisplay()");
        }
    }

    /**
     * Performs integer division of two numbers
     * @param a the dividend
     * @param b the divisor
     * @return the integer division: a/b
     * @throws ArithmeticException if {@code b} is 0
     */
    public static int doDivision(int a, int b) throws ArithmeticException {
        return a/b;
    }

}

