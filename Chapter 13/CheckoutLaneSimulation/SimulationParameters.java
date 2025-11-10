package res;

/**
 * Final class - cannot be extended
 */
public final class SimulationParameters {
    private int CUST_PER_HOUR;      //Number of customers expected per hour.
    private int NUM_MINUTES;        //Number of minutes to simulate.
    private int MAX_CUST_PER_LANE;  //Maximum customers allowed per lane.
    private int MAX_LANES;          //Number of lanes.
    private int MIN_SERVICE_TIME;   //Minimum service time used in random generation.
    private int MAX_SERVICE_TIME;   //Maximum service time used in random generation. 
    
    /**
     * Default parameters
     */
    public SimulationParameters() {
        CUST_PER_HOUR = 20;
        NUM_MINUTES = 20;
        MAX_CUST_PER_LANE = 3;
        MAX_LANES = 3;
        MIN_SERVICE_TIME = 1;
        MAX_SERVICE_TIME = 5;
    }
    
    /**
     * User-specified parameters; all parameters must be at least 1. 
     * @param custPerHour number of customers expected per hour
     * @param numMinutes number of minutes to simulate
     * @param maxCustPerLane maximum customers allowed per lane
     * @param maxLanes number of lanes
     * @param minServiceTime minimum service time used in random generation
     * @param maxServiceTime maximum service time used in random generation
     */
    public SimulationParameters(int custPerHour, int numMinutes,
            int maxCustPerLane, int maxLanes, int minServiceTime, int maxServiceTime) {
        CUST_PER_HOUR = Math.max(1, custPerHour);
        NUM_MINUTES = Math.max(1, numMinutes);
        MAX_CUST_PER_LANE = Math.max(1, maxCustPerLane);
        MAX_LANES = Math.max(1, maxLanes);
        MIN_SERVICE_TIME = Math.max(1, minServiceTime);
        MAX_SERVICE_TIME = Math.max(minServiceTime, maxServiceTime);
    }
    
    // Accessor methods
    public int getCustPerHour() { return CUST_PER_HOUR; }
    public int getNumMinutes() { return NUM_MINUTES; }
    public int getMaxCustPerLane() { return MAX_CUST_PER_LANE; }
    public int getMaxLanes() { return MAX_LANES; }
    public int getMinServiceTime() { return MIN_SERVICE_TIME; }
    public int getMaxServiceTime() { return MAX_SERVICE_TIME; }
}