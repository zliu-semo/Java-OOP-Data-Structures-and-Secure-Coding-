/**
 *  This example demonstrates how to create an array and how to access elements of an array
 *  @author ziping
 */
public class JavaArrayEx1 {

    public static void main(String[] args) {
        /*
         * initialize and assign the elements of an array
         */
        // create an integer array with ten empty slots
        int[] arrA = new int[10];

        // integer array arrA is initialized with 0 by java's default
        // for example, the first element of arrA is 0
        // we access the first element with square brackets around 0
        System.out.println("1st element of arrA is, by default: " + arrA[0]);
        System.out.println("2nd element of arrA is, by default: " + arrA[1]);
        System.out.println("3rd element of arrA is, by default: " + arrA[2]);
        System.out.println("6th element of arrA is, by default: " + arrA[5]);
        System.out.println("10th element of arrA is, by default: " + arrA[9]);
        System.out.println();

        // the length of an array can be accessed through .length
        System.out.println("arrA's length is: " + arrA.length);
        System.out.println();

        // assign new values to the array arrA
        arrA[0] = 11;
        arrA[1] = 12;
        arrA[2] = 13;
        arrA[3] = 14;
        arrA[4] = 15;
        arrA[5] = 16;
        arrA[6] = 17;
        arrA[7] = 18;
        arrA[8] = 19;
        arrA[9] = 20;
        System.out.println("1st element of arrA is, now: " + arrA[0]);
        System.out.println("2nd element of arrA is, now: " + arrA[1]);
        System.out.println("3rd element of arrA is, now: " + arrA[2]);
        System.out.println("4th element of arrA is, now: " + arrA[3]);
        System.out.println("5th element of arrA is, now: " + arrA[4]);
        System.out.println("6th element of arrA is, now: " + arrA[5]);
        System.out.println("7th element of arrA is, now: " + arrA[6]);
        System.out.println("8th element of arrA is, now: " + arrA[7]);
        System.out.println("9th element of arrA is, now: " + arrA[8]);
        System.out.println("10th element of arrA is, now: " + arrA[9]);
        System.out.println();
        // use a for loop to print array
        for(int i = 0; i < arrA.length; i++){
            System.out.printf("element %d is: %d\n", i, arrA[i]);
        }

        // Knowledge check 1:
        // Update element 7 to be negative one hundred.
        // Output the whole array.
        arrA[6] = -100;
        System.out.println("knowledge check 1 - after updating element 7, the array is as following:");
        for(int i = 0; i < arrA.length; i++){
            System.out.printf("element %d is: %d\n", i, arrA[i]);
        }

        // Knowledge check 2:
        // Calculate the product of element 7 and element 8.
        // Output the result.
        System.out.println("knowledge check 2 - the result is: " + arrA[6] * arrA[7]);

        // Knowledge check 3:
        // Calculate the sum of the first element, the sixth element and the last element.
        // Output the result.
        System.out.println("knowledge check 3 - the result is: " + arrA[0] * arrA[5]);
    }
}
