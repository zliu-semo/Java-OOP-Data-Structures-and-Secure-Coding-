/**
 *  This example demonstrates how to initialize an array with existing values
 *  and how to pass array as method arguments
 *  @author ziping
 */
public class JavaArrayEx2 {

    public static void main(String[] args) {
        // array can also be initialized with elements directly using {}
        // which forces arrB to be length 10
        int[] arrB = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        for(int i = 0; i < arrB.length; i++)
            System.out.printf("element %d is: %d\n", i, arrB[i]);

        int sum = 0;
        for (int i = 0; i < arrB.length; i++)
            sum += arrB[i];
        System.out.println("the sum of arrB: " + sum);

        sum = calculateArraySum(arrB);
        System.out.println("the sum of arrB using a method: " + sum);

        // [Call your Knowledge check 1 method here.]
        int product;
        System.out.println("the product of arrB: " + calculateArrayProduct(arrB));

        int x = 19, y = -19;
        System.out.println("Does x exist in arrB? " + elementExistsInArray(arrB, x));
        System.out.println("Does y exist in arrB? " + elementExistsInArray(arrB, y));

        // [Call your Knowledge check 2 method here.]
        System.out.println("x is at the position of arrB: " + getIndexofElementInArray(arrB, x));
        System.out.println("y is at the position of arrB: " + getIndexofElementInArray(arrB, y));

        System.out.println("the max of arrB is: " + findArrayMax(arrB));

        // [Call your Knowledge check 3 method here.]
        System.out.println("the min of arrB is: " + findArrayMin(arrB));

    }

    /**
     * calculate the summation of the elements of an int array
     * @param arr   an array of int values
     * @return      an int value
     */
    public static int calculateArraySum(int[] arr){
        int result = 0;
        for(int i = 0; i < arr.length; i++)
            result += arr[i];

        return result;
    }

    // Knowlegde check 1:
    // Write a method to calculate the product of an integer array.
    // Call this method in main() method and output the result.
    public static int calculateArrayProduct(int[] arr){
        int result = 1;
        for(int i = 0; i < arr.length; i++)
            result *= arr[i];

        return result;
    }

    /**
     * check if the array contains a specified value
     * @param arr   an array of int values
     * @param ele   a specified value
     * @return      true if the value is in the array, otherwise, return false
     */
    public static boolean elementExistsInArray(int[] arr, int ele){
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == ele)
                return true;

        return false;
    }

    // Knowledge check 2:
    // Write a method to return the index of an element if it is in the array;
    // otherwise, return negative one.
    // Call this funciton in main() method and output the result.
    public static int getIndexofElementInArray(int[] arr, int ele){
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == ele)
                return i;

        return -1;
    }

    /**
     * find the largest element in an array and return it
     * @param arr   an array of int values
     * @return      the largest element
     */
    public static int findArrayMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++)
            if(arr[i] > max)
                max = arr[i];

        return max;
    }

    // Knowledge check 3:
    // Write a method to find the minimum of an integer array.
    // Call this function in main() method and output the result.
    public static int findArrayMin(int[] arr){
        int min = arr[0];
        for(int i = 1; i < arr.length; i++)
            if(arr[i] < min)
                min = arr[i];

        return min;
    }
}
