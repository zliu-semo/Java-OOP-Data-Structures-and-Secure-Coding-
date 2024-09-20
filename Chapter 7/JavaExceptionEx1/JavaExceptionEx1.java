import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExceptionEx1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two integers for division
        /*System.out.println("Enter two integers for division: A/B");
        System.out.println("A = ");
        int a = input.nextInt();
        System.out.println("B = ");
        int b = input.nextInt();*/

        // Run-time Exception occurs if b = 0
        /*System.out.println(a + " / " + b + " is " +
          (a / b));

        System.out.println("Ready to do another task");
        input.close();*/

        // Fix run-time error by checking conditions before executing division
        /*if (b != 0)
          System.out.println(a + " / " + b + " is " +
            (a / b));
        else
          System.out.println("Divisor cannot be zero ");

        System.out.println("Ready to do another task");
        input.close();*/

        // Revise using try-catch-finally block
        //doDivisionAndDisplay(input);
        doDivisionAndDisplay(null);
        input.close();
    }

    public static void doDivisionAndDisplay(Scanner input) {
        try {
            System.out.println("Enter two integers for division: A/B");
            System.out.println("A = ");
            int a = input.nextInt();
            System.out.println("B = ");
            int b = input.nextInt();
            System.out.println(a + " / " + b + " is " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Catch ArithmeticException: "
                    + "Divisor cannot be zero ");
        } catch (InputMismatchException e) {
            System.out.println("Catch InputMismatchException: "
                    + "Input must be integer");
        } catch (Exception e) {
            System.out.println("Catch Exception: "
                    + "Some error occurred");
        } finally {
            System.out.println("Ready to do another task");
        }
    }
}
