package client;

import res.*;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CheckoutLaneSimulation {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Initialize tracking variables
        int totalCustomers = 0;
        int maxTimeInLine = 0;
        int minTimeInLine = Integer.MAX_VALUE;
        int totalTimeInLine = 0;
        
        // Set up simulation parameters
        SimulationParameters params = getParams();
        
        // Set up the checkout lanes
        Queue<Customer>[] sim = new Queue[params.getMaxLanes()];
        for (int i = 0; i < params.getMaxLanes(); i++) {
            sim[i] = new LinkedList<Customer>();
        }
        
        // Initialize a list to store the minutes each customer spends in line
        ArrayList<Integer> minutesSpentInLineList = new ArrayList<Integer>();
        
        // Let customers in for params.NUM_MINUTES minutes and service those already in line
        final int TOTAL_TIME = params.getNumMinutes();
        for (int t = 1; t <= TOTAL_TIME; t++) {
            try {
                letInCustomer(params, sim, t);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
            serviceLanes(params, sim, t, minutesSpentInLineList);
            displayLanes(params, sim);
            System.out.println(String.format("********** TIME: %d **********", t));
        }
        
        // After params.NUM_MINUTES, no more new customers are allowed.
        System.out.println("********** No more new customers allowed. "
                + "Servicing remaining customers.******");
        
        // Service the remaining customers
        serviceRemainingCustomers(params, sim, minutesSpentInLineList);
        totalCustomers = Customer.getNumCustomers();
        
        // Calculate the simulation analytics
        for (int m: minutesSpentInLineList) {
            if (m > maxTimeInLine) maxTimeInLine = m;
            if (m < minTimeInLine) minTimeInLine = m;
            totalTimeInLine += m;
        }
        
        System.out.println("Total customers serviced: " + totalCustomers);
        System.out.println("Maximum minutes spent in line: " + maxTimeInLine); 
        System.out.println("Minimum minutes spent in line: " + minTimeInLine);
        double avgMinutes = (double) totalTimeInLine / totalCustomers;
        System.out.println(String.format("Average minutes spent in line: %.3f", avgMinutes));
    }
    
    /**
     * Get the parameters of the simulation, based on user input
     * @return a record of the specified simulation parameters
     */
    static SimulationParameters getParams() {
        SimulationParameters params = null;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Use default parameters? 0 for YES / 1 for NO");
        int choice = Integer.parseInt(input.nextLine().trim());
        if (choice == 0) params = new SimulationParameters();
        else {
            System.out.println("Enter parameters...");
            System.out.println("Customers expected per hour: ");         
            int custPerHour = input.nextInt();  
            System.out.println("Number of minutes to simulate: ");       
            int numMinutes = input.nextInt();
            System.out.println("Maximum customers per lane: ");          
            int maxCustPerLane = input.nextInt();
            System.out.println("Maximum number of lanes: ");             
            int maxLanes = input.nextInt();
            System.out.println("Minimum service time per customer: ");   
            int minServiceTime = input.nextInt();
            System.out.println("Maximum service time per customer: ");   
            int maxServiceTime = input.nextInt();
            params = new SimulationParameters(custPerHour, numMinutes, maxCustPerLane,
                    maxLanes, minServiceTime, maxServiceTime);
        }
        System.out.println("Thank you. Simulation will now begin.");
        input.close();
        return params;
    }
    
    /**
     * Attempt to place a new customer in line, if any arrive in this minute.
     * @param params the simulation parameters
     * @param sim an array of {@code Queue}s representing available checkout lanes
     * @param currentTime the current time, in minutes, of the simulation
     * @return the new total number of customers at the end of this minute
     */
    static void letInCustomer(SimulationParameters params, Queue<Customer>[] sim,
            int currentTime) {
        // Determine if a customer arrived in this minute.
        double arrivalProbability = params.getCustPerHour() / 60.00; 
        double arrivalIndicator = (100.0 * Math.random()) - 1;
        boolean customerArrived = arrivalIndicator < (arrivalProbability * 100);
        
        if (customerArrived) {
            // Put new customer into a lane.
            boolean inLine = false;
            int laneNum = 0;
            int customerId = Customer.getNumCustomers();
            while (laneNum < params.getMaxLanes() && !inLine) {
                // Perform only if the lane is empty
                if (sim[laneNum].isEmpty()) {
                    System.out.println("Lane " + laneNum + " opening.");
                }
                // Perform if the lane is not full (including when the lane is empty)
                if (sim[laneNum].size() < params.getMaxCustPerLane()) {
                    // Create a new customer record
                    int serviceMinutes = (int)(
                            Math.random() * 
                            ((params.getMaxServiceTime() - 
                                    params.getMinServiceTime()) + 1)
                            ) + params.getMinServiceTime();
                    Customer c = new Customer(currentTime, serviceMinutes);
                    customerId = c.getId();
                    
                    // Add the new customer to the lane
                    sim[laneNum].add(c);
                    inLine = true;
                    System.out.println("Customer #" + c.getId() + " in lane " + laneNum);
                }
                laneNum += 1; // loop to find a lane with capacity 
            }
            
            if (!inLine) {
                throw new IllegalStateException("*** All lanes full.  "
                        + "Unable to place customer #" + customerId);
            }
        }
        return;
    }
    
    /**
     * Service each of the checkout lanes in this minute
     * @param params the simulation parameters
     * @param sim an array of {@code Queue}s representing available checkout lanes
     * @param currentTime the current time, in minutes, of the simulation
     */
    static void serviceLanes(
            SimulationParameters params, Queue<Customer>[] sim, 
            int currentTime, ArrayList<Integer> minutesSpentInLineList) {
        Customer currCustomer = null;
        
        for (int laneNum = 0; laneNum < params.getMaxLanes(); laneNum++) {
            // Service each customer at the front of the line
            if (!sim[laneNum].isEmpty()) {
                currCustomer = sim[laneNum].peek();
                currCustomer.serviceCustomer();
                
                // The customer is finished checking out
                if (currCustomer.getServiceMinutes() <= 0) {
                    System.out.println("Finished serving customer #" + currCustomer.getId());
                    // Calculate minutes customer spent in line
                    int currMinutesInLine = currentTime - currCustomer.getArrivalTime() + 1;
                    minutesSpentInLineList.add(currMinutesInLine);
                    // The customer leaves the line after checking out
                    sim[laneNum].remove();
                    if (sim[laneNum].isEmpty()) {
                        System.out.println("*** Lane " + laneNum + " closing.");
                    }
                } // end of finishing checking out a customer
            } // end of servicing a customer
        } // end of servicing all customers at the front of the line
        return;
    }
    
    /**
     * Service each of the checkout lanes in this minute
     * @param params the simulation parameters
     * @param sim an array of {@code Queue}s representing available checkout lanes
     */
    static void serviceRemainingCustomers(
            SimulationParameters params, Queue<Customer>[] sim,
            ArrayList<Integer> minutesSpentInLineList) {
        int t = params.getNumMinutes();
        boolean allComplete = false;
        
        while (!allComplete) {
            t += 1;
            allComplete = true;
            for (int laneNum = 0; laneNum < params.getMaxLanes(); laneNum++) {
                if (!sim[laneNum].isEmpty()) allComplete = false;
            }
            if (allComplete) {
                System.out.println("********** All customers serviced! **********");
                System.out.println(String.format("********** TIME: %d **********", t));
                break;
            } else {
                serviceLanes(params, sim, t, minutesSpentInLineList);
                displayLanes(params, sim);
            }
            System.out.println(String.format("********** TIME: %d **********", t));
        }
        return;
    }
    
    /**
     * Display the status of each checkout lane
     * @param params the simulation parameters
     * @param sim an array of {@code Queue}s representing available checkout lanes
     */
    static void displayLanes(SimulationParameters params, Queue<Customer>[] sim) {
        for (int laneNum = 0; laneNum < params.getMaxLanes(); laneNum++) {
            System.out.println(String.format("*** Lane #%d:", laneNum));
            System.out.println(sim[laneNum].toString());
        }
    }
}