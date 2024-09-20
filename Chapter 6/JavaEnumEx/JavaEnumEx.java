package client;

import resources.*;
import java.util.Scanner;

public class JavaEnumEx {

    public static void main(String[] args) {
        // Use a simple enum: Month
        // TODO: Rewrite the following code for Knowledge Check 1.
        Month m = Month.SEPT;
        String s = "The month is ";
        switch(m) {
            case JAN:
                s += "January";
                break;
            case FEB:
                s += "February";
                break;
            case MAR:
                s += "March";
                break;
            case APR:
                s += "April";
                break;
            case MAY:
                s += "May";
                break;
            case JUN:
                s += "June";
                break;
            case JULY:
                s += "July";
                break;
            case AUG:
                s += "August";
                break;
            case SEPT:
                s += "September";
                break;
            case OCT:
                s += "October";
                break;
            case NOV:
                s += "November";
                break;
            case DEC:
                s += "December";
                break;
            default:
                s += "UNSPECIFIED";
                break;
        }
        s += ".";
        System.out.println(s);
        System.out.println();
        //  END OF KNOWLEDGE CHECK 1 CODE.

        /*
         * Knowledge check 1:
         * After re-defining the Month enum, re-write the code above so that
         * it no longer uses hard-coded Strings for the names of the twelve
         * months. Check your output by running the program.
         */

        // Use a more complex enum with System.in input
        Scanner in = new Scanner(System.in);

        // Get the user input hourly rate:
        System.out.println("Please enter the hourly wage: ");
        double ratePerHour = in.nextDouble();

        // Get the user input hours worked each day:
        double[] hoursWorked = getHoursWorked(in);

        // Compute the total pay due for the week:
        double totalPay = computePay(hoursWorked, ratePerHour);
        System.out.printf("Total pay for the week: %.2f\n", totalPay);

        // Call your Knowledge Check 2 method here.
        double overtimePay = computeOvertimePay(hoursWorked, ratePerHour);
        System.out.printf("\nOvertime pay: %.2f\n\n", overtimePay);

        // Call your Knowledge Check 3 method here.
        System.out.println("The least working hour day is: " + findLeastHourDay(hoursWorked).getDayName());
        System.out.println();

        // Compute the pay due for each day of the week:
        double[] payForEachDay = computePayForEachDay(hoursWorked, ratePerHour);
        System.out.printf("Pay for Monday: %.2f\n", payForEachDay[Day.MON.getDayInt()]);

        // Call your Knowledge Check 5 method here.
        System.out.println();
        displayPayForEachDay(hoursWorked, ratePerHour);
    }

    /*
     * Useful constants used throughout the program
     */
    private static final Day[] DAYS_ARR = Day.values();
    private static final int NUM_DAYS = DAYS_ARR.length;
    private static final int MAX_REGULAR_HOURS = 8;

    /**
     * User input the hours worked for each day
     * @param in {@code Scanner} object for user input
     * @return {@code double[]} of user input
     */
    private static double[] getHoursWorked(Scanner in) {
        double[] hoursWorked = new double[NUM_DAYS];
        for (Day day: DAYS_ARR) {
            System.out.printf("Hours worked on %s: \n", day.getDayName());
            hoursWorked[day.getDayInt()] = Math.max(0, in.nextDouble());
        }
        return hoursWorked.clone();
    }

    /**
     * Computes the total pay received for a week, including overtime calculations.
     * @param hoursWorked {@code double[]} of the hours worked for each day of the week.
     * @param rate the hourly wage rate
     * @return total pay received for a week
     */
    private static double computePay(double[] hoursWorked, double rate) {
        double pay = 0;
        double addedPay = 0;
        for (int i = 0; i < NUM_DAYS; i++) {
            double hoursWorkedOnDay = hoursWorked[i];
            if (hoursWorkedOnDay > MAX_REGULAR_HOURS) {
                addedPay = MAX_REGULAR_HOURS * rate +
                        (hoursWorkedOnDay - MAX_REGULAR_HOURS) * rate * 1.5;
            } else {
                addedPay = hoursWorkedOnDay * rate;
            }
            pay += addedPay;
        }
        return pay;
    }

    /*
     * Knowledge check 2:
     * Write a method that calculates an employee's total OVERTIME
     * pay for the week, according to user input. Call this method
     * in main() and output the result.
     *
     * Try to write the method using the values of the Day enum instead
     * of using iteration through array indexing.
     */
    public static double computeOvertimePay(double[] hoursWorked, double rate) {
        double overtimePay = 0;
        for(Day day : DAYS_ARR) {
            if(hoursWorked[day.getDayInt()] > MAX_REGULAR_HOURS) {
                overtimePay += (hoursWorked[day.getDayInt()] - MAX_REGULAR_HOURS) * rate * 1.5;
            }
        }

        return overtimePay;
    }

    /*
     * Knowledge check 3:
     * Write a method that finds the day in which an employee worked the
     * least number of hours, according to user input. Call this method
     * in main() and output the result.
     */
    public static Day findLeastHourDay(double[] hoursWorked) {
        Day d = Day.MON;
        for(Day day : DAYS_ARR) {
            if(hoursWorked[day.getDayInt()] < hoursWorked[d.getDayInt()]) {
                d = day;
            }
        }

        return d;
    }
    /*
     * Knowledge check 4:
     * Rewrite this method using enum values instead of iteration through array
     * indices.
     */
    private static double[] computePayForEachDay(double[] hoursWorked, double rate) {
        double[] payForEachDay = new double[NUM_DAYS];
        for (Day day : DAYS_ARR) {
            int i = day.getDayInt();
            double hoursWorkedOnDay = hoursWorked[i];
            if (hoursWorkedOnDay > MAX_REGULAR_HOURS) {
                payForEachDay[i] = MAX_REGULAR_HOURS * rate +
                        (hoursWorkedOnDay - MAX_REGULAR_HOURS) * rate * 1.5;
            } else {
                payForEachDay[i] = hoursWorkedOnDay * rate;
            }
        }
        return payForEachDay.clone();
    }
    /**
     * Computes the pay received for each day of the week and stores the daily pay
     * separately for each day, including overtime calculations.
     * @param hoursWorked {@code double[]} of the hours worked for each day of the week.
     * @param rate the hourly wage rate
     * @return {@code double[]} of the pay received for each day of the week
     */
    /*  private static double[] computePayForEachDay(double[] hoursWorked, double rate) {
        double[] payForEachDay = new double[NUM_DAYS];
        for (int i = 0; i < NUM_DAYS; i++) {
            double hoursWorkedOnDay = hoursWorked[i];
            if (hoursWorkedOnDay > MAX_REGULAR_HOURS) {
                payForEachDay[i] = MAX_REGULAR_HOURS * rate +
                        (hoursWorkedOnDay - MAX_REGULAR_HOURS) * rate * 1.5;
            } else {
                payForEachDay[i] = hoursWorkedOnDay * rate;
            }
        }
        return payForEachDay.clone();
    }   */

    /*
     * Knowledge check 5:
     * Write a method, using enum values, to display the daily total pay for
     * each day of the week. Call this method in main() and output the result.
     */
    public static void displayPayForEachDay(double[] hoursWorked, double rate) {
        double[] payForEachDay = new double[NUM_DAYS];
        payForEachDay = computePayForEachDay(hoursWorked, rate);
        for(Day day : Day.values())
            System.out.printf("On %s, the pay: %.2f\n", day.getDayName(), payForEachDay[day.getDayInt()]);
    }
}

