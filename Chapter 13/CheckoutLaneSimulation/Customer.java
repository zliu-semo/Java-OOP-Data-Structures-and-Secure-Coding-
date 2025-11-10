package res;

public class Customer {
   private int id;
   private int arrivalTime;
   private int serviceMinutes;
   private static int numCustomers = 0;
   
   public Customer(int arrivalTime, int serviceMinutes) {
       this.id = numCustomers;
       numCustomers += 1;
       this.arrivalTime = arrivalTime;
       this.serviceMinutes = serviceMinutes;
   }
   
   public int getId() { return id; }
   public int getArrivalTime() { return arrivalTime; }
   public int getServiceMinutes() { return serviceMinutes; }
   public static int getNumCustomers() { return numCustomers; }
   
   public void serviceCustomer() { serviceMinutes--; }
   
   @Override
   public String toString() {
       return String.format("\nCustomer %d (arrival = %d; service remaining = %d)",
               id, arrivalTime, serviceMinutes);
   }
   
}
