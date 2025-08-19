import java.util.Scanner;

/**
 * demonstrate how pass-by-value works for array in Java
 * @author ziping
 */
public class JavaArrayEx3 {

    public static void main(String[] args) {
        // fill an array using a method
        // weeklyHours initially filled with all 0 by default
        // after calling inputArray( ) method, it is filled with user input
        int[] weeklyHours = new int[7];
        inputArray(weeklyHours);

        System.out.println("Enter the hourly pay rate: ");
        Scanner inVar = new Scanner(System.in);
        double payRate = inVar.nextDouble();
        System.out.printf("The weekly pay is: %.2f\n", computePay(weeklyHours, payRate));

        // [Call your Knowledge check 1 method here.]
        System.out.printf("The overtime pay is: %.2f\n", computeOvertimePay(weeklyHours, payRate));

        // [Call your Knowledge check 2 method here.]
        System.out.println("The day of the minimum hour is: " + findMinHourDay(weeklyHours));

        // [Call your Knowledge check 3 method here.]
        outputDailyPay(weeklyHours, payRate);
    }

    /**
     * assign daily working hours of a week to an array
     * @param arr   an array of daily working hours to be assigned by user
     */
    public static void inputArray(int[] arr){
        Scanner inVar = new Scanner(System.in);
        for (int index = 0; index <= 6; index++)
        {
            System.out.println("Enter hours worked on day " + index);
            arr[index] = inVar.nextInt();
        }
    }

    /**
     * calculate weekly payment with a specified pay rate
     * @param arr   an array of daily working hours for a week
     * @param rate  regular hourly pay rate
     * @return      total weekly payment
     */
    public static double computePay (int[] arr, double rate){
        double pay = 0;
        for (int index = 0; index <= 6; index++)
        {
            if (arr[index] > 8)
                pay += 8 * rate + (arr[index] - 8) * rate * 1.5;
            else
                pay += arr[index] * rate;
        }

        return pay;
    }

    // Knowlegde check 1:
    // Write a method to calculate overtime pay.
    // Call this method in main() method and output the result.
    public static double computeOvertimePay(int[] arr, double rate){
        double overpay = 0;
        for (int index = 0; index <=6; index++)
            if (arr[index] > 8)
                overpay += (arr[index] - 8) * rate * 1.5;

        return overpay;
    }

    // Knowlegde check 2:
    // Write a method to find the day that works the least amount of hours.
    // Call this method in main() method and output the result.
    public static int findMinHourDay(int[] arr){
        int hour = arr[0];
        ind minDay = 0;
        for (int i = 1; i <=6; i++)
            if (arr[i] < hour) {
                hour = arr[i];
                minDay = i;
            }

        return minDay;
    }

    /**
     * calculate daily pay with daily hours and pay rate
     * @param arr   an array of daily working hours for a week
     * @param rate  regular hourly pay rate
     * @return      an array contains daily payment
     */
    public static double[] computeDailyPay (int[] arr, double rate){
        int len = arr.length;
        double[] dailyPay = new double[len];
        for (int index = 0; index < len; index++)
        {
            if (arr[index] > 40)
                dailyPay[index] = 40 * rate + (arr[index] - 40) * rate * 1.5;
            else
                dailyPay[index] = arr[index] * rate;
        }

        return dailyPay;
    }

    // Knowlegde check 3:
    // Write a method to output daily pay of the week.
    // Call this method in main() method and output the result.
    public static void outputDailyPay(int[] arr, double rate){
        double[] dailyPay = new double[7];
        dailyPay = computeDailyPay(arr, rate);
        System.out.println("The daily pay of the week:");
        for (int index = 0; index <= 6; index++)
            System.out.printf("%.2f\n", dailyPay[index]);
    }

}


